package com.example.gideonmanurung.sbmptnapps.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Gideon Manurung on 5/22/2017.
 */

public class RESTClient {
    private static APIProject REST_CLIENT;

    static {
        //dieksekusi sebelum constructor, tapi hanya sekali untuksemua instans
        setupRestClient();
    }
    private RESTClient() {}
    public static APIProject get() {
        return REST_CLIENT;
    }
    private static void setupRestClient() {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.43.104:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        REST_CLIENT = retrofit.create(APIProject.class);
    }
}
