package id.osg3_20.bikewiseapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import java.util.List;
import id.osg3_20.bikewiseapp.R;
import id.osg3_20.bikewiseapp.model.IncidentDetail;


public class IncidentAdapter extends RecyclerView.Adapter<IncidentAdapter.IncidentHolder> {

    private List<IncidentDetail> listIncident;

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
    }

    @Override
    public int getItemCount() {
        return listIncident.size();
    }

    public class IncidentHolder extends RecyclerView.ViewHolder {

        TextView title;

        public IncidentHolder(@NonNull View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.tv_title);
        }
    }

}
