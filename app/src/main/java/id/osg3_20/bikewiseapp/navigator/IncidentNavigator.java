package id.osg3_20.bikewiseapp.navigator;

import java.util.List;

import id.osg3_20.bikewiseapp.model.IncidentDetail;

public interface IncidentNavigator {
    void loadListIncident(List<IncidentDetail> listIncident);
    void errorLoadListIncident(String message);
}
