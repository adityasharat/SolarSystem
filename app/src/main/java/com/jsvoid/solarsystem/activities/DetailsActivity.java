package com.jsvoid.solarsystem.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

import com.jsvoid.solarsystem.R;
import com.jsvoid.solarsystem.SolarSystemApplication;
import com.jsvoid.solarsystem.models.CelestialObject;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {

    public static final String OBJECT = "object";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        Retrofit retrofit = ((SolarSystemApplication) getApplication()).getRetrofit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        if (toolbar != null) {
            toolbar.setTitle(R.string.app_name);
            setSupportActionBar(toolbar);
        }

        ImageView mImage = (ImageView) findViewById(R.id.object_image);
        TextView mDetail = (TextView) findViewById(R.id.details);

        CelestialObject mObject = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mObject = bundle.getParcelable(OBJECT);
        }

        if (mObject != null) {
            if (mDetail != null) {
                mDetail.setText(mObject.getDetailsHtml());
            }
            if (mImage != null) {
                Picasso.with(this)
                        .load(retrofit.baseUrl().toString() + mObject.imageUrl)
                        .into(mImage);
            }
        }
    }
}
