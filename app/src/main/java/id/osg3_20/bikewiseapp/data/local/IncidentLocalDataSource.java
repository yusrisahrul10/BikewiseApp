package id.osg3_20.bikewiseapp.data.local;

import android.content.Context;

import java.util.List;

import id.osg3_20.bikewiseapp.data.IncidentDataSource;
import id.osg3_20.bikewiseapp.model.IncidentDetail;
import id.osg3_20.bikewiseapp.model.Incident;

public class IncidentLocalDataSource implements IncidentDataSource {

    private Context context;
    private IncidentDao incidentDao;

    public IncidentLocalDataSource(Context context) {
        this.context = context;
        incidentDao = IncidentDataBase.getInstance(context).incidentDao();
    }


    @Override
    public void getListIncident(final GetIncidentCallBack callBack) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                final List<IncidentDetail> incidents = incidentDao.getIncident();
                if (!incidents.isEmpty()) {
                    callBack.onIncidentLoaded(new Incident(incidents));
                } else {
                    callBack.onDataNotAvailable("DataBase kosong");
                }
            }
        };
        new Thread(runnable).start();
    }

    public void saveData(final List<IncidentDetail> incidentDetailList) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                incidentDao.insertIncident(incidentDetailList);
            }
        };
        new Thread(runnable).start();
    }
}
