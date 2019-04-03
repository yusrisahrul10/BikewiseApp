package id.osg3_20.bikewiseapp.model;

import java.util.List;

public class Incident {

    List<IncidentDetail> incidents;

    public Incident(List<IncidentDetail> incidents){
        this.incidents=incidents;
    }

    public List<IncidentDetail> getIncidents() {
        return incidents;
    }
}
