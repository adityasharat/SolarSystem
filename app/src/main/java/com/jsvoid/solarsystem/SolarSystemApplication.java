package com.jsvoid.solarsystem;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * SolarSystemApplication
 *
 * @author aditya.sharat
 */
public class SolarSystemApplication extends Application {

    private static final String BASE_URL = "http://jsvoid.com/files/solarsystem/";

    private Retrofit retrofit;

    public Retrofit getRetrofit() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

}
