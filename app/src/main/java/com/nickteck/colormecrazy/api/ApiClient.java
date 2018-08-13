package com.nickteck.colormecrazy.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by admin on 8/10/2018.
 */

public class ApiClient {

    public static Retrofit retrofit = null;
    public static final String BASE_URL = "http://colourmecrazy.in/web_service/";
    public static Gson gson;
//    public static final String BASE_URL = "http://192.168.1.8/prawnandcrab/webservice/";



    public static Retrofit getClient()
    {
        gson = new GsonBuilder()
                .setLenient()
                .create();

        if (retrofit == null)
        {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
