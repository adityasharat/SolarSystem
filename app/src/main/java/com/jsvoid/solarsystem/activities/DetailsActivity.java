package com.jsvoid.solarsystem.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.jsvoid.solarsystem.R;
import com.jsvoid.solarsystem.models.CelestialObject;

public class DetailsActivity extends AppCompatActivity {

    public static final String OBJECT = "object";

    private CelestialObject mObject;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mObject = bundle.getParcelable(OBJECT);
        }
    }
}
