package id.osg3_20.bikewiseapp.data.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import id.osg3_20.bikewiseapp.model.IncidentDetail;

@Database(entities = {IncidentDetail.class}, version = 1)
public abstract class IncidentDataBase extends RoomDatabase {

    private static IncidentDataBase INSTANCE;

    public abstract IncidentDao incidentDao();

    public static IncidentDataBase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                    IncidentDataBase.class, "Incident.db")
                    .build();
        }
        return INSTANCE;
    }
}
