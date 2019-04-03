package id.osg3_20.bikewiseapp.data.remote;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {

    private static Retrofit retrofit = null;
//    https://api-osg3-20.polymedikal.com/incidents
    public static Retrofit getClient() {
        retrofit = new Retrofit.Builder().baseUrl("http://api-osg3-20.polymedikal.com")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }
}
