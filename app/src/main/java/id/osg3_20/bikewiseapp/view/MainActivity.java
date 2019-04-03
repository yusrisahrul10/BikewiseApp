package id.osg3_20.bikewiseapp.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.osg3_20.bikewiseapp.Injection;
import id.osg3_20.bikewiseapp.R;
import id.osg3_20.bikewiseapp.adapter.IncidentAdapter;
import id.osg3_20.bikewiseapp.model.IncidentDetail;
import id.osg3_20.bikewiseapp.navigator.IncidentNavigator;
import id.osg3_20.bikewiseapp.navigator.OnRecyclerItemClickLister;
import id.osg3_20.bikewiseapp.viewmodel.IncidentViewModel;

public class MainActivity extends AppCompatActivity implements IncidentNavigator {

    private IncidentViewModel mIncidentViewModel;
    private RecyclerView mRecyclerView;

    private IncidentAdapter adapter;
    private List<IncidentDetail> dataListIncident;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mRecyclerView = (RecyclerView) findViewById(R.id.rv_incident);
        mIncidentViewModel = new IncidentViewModel(Injection.provideIncidentRepository(this), this);
        dataListIncident = new ArrayList<>();
        mIncidentViewModel.setNavigator(this);
        mIncidentViewModel.getListIncident();
        initAdapter();

        adapter.setOnRecyclerItemClickLister(new OnRecyclerItemClickLister() {
            @Override
            public void onItemClick(RecyclerView.Adapter adapter, int position) {
                goToDetail(position);
            }
        });
    }

    @Override
    public void loadListIncident(List<IncidentDetail> listIncident) {
        dataListIncident.addAll(listIncident);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void errorLoadListIncident(String message) {
        Log.e("ERROR", message);
    }

    private void initAdapter() {
        adapter = new IncidentAdapter(dataListIncident);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mRecyclerView.addItemDecoration(new DividerItemDecoration(this, DividerItemDecoration.VERTICAL));
        mRecyclerView.setAdapter(adapter);
    }

    private void goToDetail(int position) {
        IncidentDetail incidentDetail = adapter.getIncidetDetail(position);

        Intent intent = new Intent (this, IncidentDetailActivity.class);
        intent.putExtra("title", incidentDetail.getTitle());
        intent.putExtra("image_url", incidentDetail.getImage_url());
        intent.putExtra("description", incidentDetail.getDescription());
        intent.putExtra("address", incidentDetail.getAddress());
        intent.putExtra("type", incidentDetail.getType());
        startActivity(intent);
    }
}
