package com.jsvoid.solarsystem.activities;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.Toast;

import com.jsvoid.solarsystem.R;
import com.jsvoid.solarsystem.SolarSystemApplication;
import com.jsvoid.solarsystem.models.CelestialObject;
import com.jsvoid.solarsystem.services.CelestialObjectResource;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

/**
 * ListActivity
 *
 * @author aditya.sharat
 */
public class ListActivity extends AppCompatActivity {

    private Retrofit retrofit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }
        setup();
        fetch();
    }

    private void fetch() {
        CelestialObjectResource resource = retrofit.create(CelestialObjectResource.class);
        Call<List<CelestialObject>> call = resource.query();
        call.enqueue(new Callback<List<CelestialObject>>() {
            @Override
            public void onResponse(Call<List<CelestialObject>> call, Response<List<CelestialObject>> response) {
                if (response.isSuccessful()) {
                    Log.i("yay", "fetched");
                } else {
                    Log.i("fuck", "fucked");
                }
            }

            @Override
            public void onFailure(Call<List<CelestialObject>> call, Throwable t) {
                Toast.makeText(getApplicationContext(), R.string.error_fetch_objects, Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void setup() {
        retrofit = ((SolarSystemApplication)getApplication()).getRetrofit();
    }
}
