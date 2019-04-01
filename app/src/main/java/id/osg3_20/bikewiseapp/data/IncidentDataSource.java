package id.osg3_20.bikewiseapp.data;

import id.osg3_20.bikewiseapp.model.Incident;

public interface IncidentDataSource {

    void getListIncident(GetIncidentCallBack callBack);

    interface GetIncidentCallBack{
        void onIncidentLoaded (Incident dataIncidents);
        void onDataNotAvailable (String errorMessage);
    }

}
