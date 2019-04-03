package id.osg3_20.bikewiseapp.data;

import android.content.Context;

import id.osg3_20.bikewiseapp.data.local.IncidentLocalDataSource;
import id.osg3_20.bikewiseapp.data.remote.IncidentRemoteDataSource;
import id.osg3_20.bikewiseapp.model.Incident;

public class IncidentRepository implements IncidentDataSource{

    private IncidentLocalDataSource incidentLocalDataSource;
    private IncidentRemoteDataSource incidentRemoteDataSource;

    public IncidentRepository (IncidentRemoteDataSource incidentRemoteDataSource, IncidentLocalDataSource incidentLocalDataSource){
        this.incidentLocalDataSource = incidentLocalDataSource;
        this.incidentRemoteDataSource = incidentRemoteDataSource;
    }


    @Override
    public void getListIncident(final GetIncidentCallBack callBack) {
        incidentLocalDataSource.getListIncident(new GetIncidentCallBack() {
            @Override
            public void onIncidentLoaded(Incident dataIncidents) {
                callBack.onIncidentLoaded(dataIncidents);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                getTeamsfromRemoteDataSource(callBack);
            }
        });
    }

    public void getTeamsfromRemoteDataSource(final GetIncidentCallBack callBack){

        incidentRemoteDataSource.getListIncident(new GetIncidentCallBack() {
            @Override
            public void onIncidentLoaded(Incident dataIncidents) {
                incidentLocalDataSource.saveData(dataIncidents.getIncidents());
                callBack.onIncidentLoaded(dataIncidents);
            }

            @Override
            public void onDataNotAvailable(String errorMessage) {
                callBack.onDataNotAvailable(errorMessage);
            }
        });
    };
}
