package id.osg3_20.bikewiseapp;

import android.content.Context;

import id.osg3_20.bikewiseapp.data.IncidentRepository;
import id.osg3_20.bikewiseapp.data.local.IncidentLocalDataSource;
import id.osg3_20.bikewiseapp.data.remote.IncidentRemoteDataSource;

public class Injection {
    public static IncidentRepository provideIncidentRepository(Context context) {
        return new IncidentRepository(new IncidentRemoteDataSource(), new IncidentLocalDataSource(context));
    }
}
