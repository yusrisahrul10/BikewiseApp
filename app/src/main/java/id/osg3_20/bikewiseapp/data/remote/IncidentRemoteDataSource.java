package id.osg3_20.bikewiseapp.data.remote;

import id.osg3_20.bikewiseapp.data.IncidentDataSource;
import id.osg3_20.bikewiseapp.model.Incident;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class IncidentRemoteDataSource implements IncidentDataSource {

    private ApiInterface apiInterface = ApiClient.getClient().create(ApiInterface.class);

    @Override
    public void getListIncident(final GetIncidentCallBack callBack) {

        Call<Incident> call = apiInterface.getAllIncident();
        call.enqueue(new Callback<Incident>() {
            @Override
            public void onResponse(Call<Incident> call, Response<Incident> response) {
                callBack.onIncidentLoaded(response.body());
            }

            @Override
            public void onFailure(Call<Incident> call, Throwable t) {
                callBack.onDataNotAvailable(t.toString());
            }
        });
    }
}
