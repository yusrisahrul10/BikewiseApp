package id.osg3_20.bikewiseapp.viewmodel;

import android.content.Context;

import id.osg3_20.bikewiseapp.data.IncidentDataSource;
import id.osg3_20.bikewiseapp.data.IncidentRepository;
import id.osg3_20.bikewiseapp.model.Incident;
import id.osg3_20.bikewiseapp.navigator.IncidentNavigator;

public class IncidentViewModel {
    private IncidentRepository incidentRepository;
    private Context context;
    private IncidentNavigator incidentNavigator;

    public IncidentViewModel(IncidentRepository incidentRepository, Context context) {
        this.incidentRepository = incidentRepository;
        this.context = context;
    }

    public void setNavigator(IncidentNavigator navigator) { this.incidentNavigator = navigator; }

    public void getListIncident() {
        incidentRepository.getListIncident(new IncidentDataSource.GetIncidentCallBack() {
            @Override
            public void onIncidentLoaded(Incident dataIncidents) {
                incidentNavigator.loadListIncident(dataIncidents.getIncidents());
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                incidentNavigator.errorLoadListIncident(errorMessage);
            }
        });
    }

    public void getIncident(String id) {

    }
}
