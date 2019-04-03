package id.osg3_20.bikewiseapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;
import id.osg3_20.bikewiseapp.R;
import id.osg3_20.bikewiseapp.model.IncidentDetail;
import id.osg3_20.bikewiseapp.navigator.OnRecyclerItemClickLister;


public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentHolder> {

    private List<IncidentDetail> listIncident;

    private OnRecyclerItemClickLister onRecyclerItemClickLister;

    public IncidentAdapter(List<IncidentDetail> listIncident) {
        this.listIncident = listIncident;
    }

    @NonNull
    @Override
    public IncidentHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()
        ).inflate(R.layout.item_list, viewGroup, false);
        return new IncidentHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull IncidentHolder holder, int i) {

        IncidentDetail data = listIncident.get(i);
        holder.title.setText(data.getTitle());
        holder.address.setText(data.getAddress());
        holder.type.setText(data.getType());

        Picasso.get()
                .load(data.getImage_url())
                .into(holder.image_thumb);
    }

    @Override
    public int getItemCount() {
        return listIncident.size();
    }

    public class IncidentHolder extends RecyclerView.ViewHolder {

        TextView title, address, type;
        ImageView image_thumb;

        public IncidentHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
            address = (TextView) itemView.findViewById(R.id.tv_address);
            type = (TextView) itemView.findViewById(R.id.tv_type);
            image_thumb = (ImageView) itemView.findViewById(R.id.image_thumb);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onRecyclerItemClickLister.onItemClick(IncidentAdapter.this, getAdapterPosition());
                }
            });
        }
    }

    public void setOnRecyclerItemClickLister(OnRecyclerItemClickLister onRecyclerItemClickLister) {
        this.onRecyclerItemClickLister = onRecyclerItemClickLister;
    }

    public IncidentDetail getIncidetDetail(int position) {
        return listIncident.get(position);
    }

}
