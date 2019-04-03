package id.osg3_20.bikewiseapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;

    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder().baseUrl("http://bikewise.org")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
