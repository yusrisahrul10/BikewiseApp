package id.osg3_20.bikewiseapp.data.local;


import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import id.osg3_20.bikewiseapp.model.IncidentDetail;

@Dao
public interface IncidentDao {

    @Query("SELECT * FROM incidents")
    List<IncidentDetail> getIncident();

    @Insert
    void insertIncident(List<IncidentDetail> incidents);
}
