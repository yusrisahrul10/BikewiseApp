package id.osg3_20.bikewiseapp.data.remote;

import id.osg3_20.bikewiseapp.model.Incident;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiInterface {

    @GET("/api/v2/incidents")
    Call<Incident> getAllIncident();


}
