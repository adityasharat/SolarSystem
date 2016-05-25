package com.jsvoid.solarsystem.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.SpannableStringBuilder;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.jsvoid.solarsystem.R;
import com.jsvoid.solarsystem.SolarSystemApplication;
import com.jsvoid.solarsystem.models.CelestialObject;
import com.squareup.picasso.Picasso;

import retrofit2.Retrofit;

public class DetailsActivity extends AppCompatActivity {

    public static final String OBJECT = "object";
    public static final String BASE_WIKI_URL = "https://en.wikipedia.org";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_details);

        Retrofit retrofit = ((SolarSystemApplication) getApplication()).getRetrofit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

        ImageView mImage = (ImageView) findViewById(R.id.object_image);
        TextView mDetail = (TextView) findViewById(R.id.details);

        CelestialObject mObject = null;
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            mObject = bundle.getParcelable(OBJECT);
        }

        if (mObject != null) {
            if (toolbar != null) {
                toolbar.setTitle(mObject.name);
                setSupportActionBar(toolbar);
            }
            if (mDetail != null) {
                mDetail.setText(convertToClickable(mObject.getDetailsHtml()));
                mDetail.setMovementMethod(LinkMovementMethod.getInstance());
            }
            if (mImage != null) {
                Picasso.with(this)
                        .load(retrofit.baseUrl().toString() + mObject.imageUrl)
                        .placeholder(R.drawable.image_preview)
                        .into(mImage);
            }
        }
    }

    private SpannableStringBuilder convertToClickable(Spanned html) {
        SpannableStringBuilder builder = new SpannableStringBuilder(html);
        URLSpan[] urls = builder.getSpans(0, html.length(), URLSpan.class);
        for (URLSpan span : urls) {
            makeLinkClickable(builder, span);
        }
        return builder;
    }

    private void makeLinkClickable(SpannableStringBuilder builder, final URLSpan span) {
        int start = builder.getSpanStart(span);
        int end = builder.getSpanEnd(span);
        int flags = builder.getSpanFlags(span);
        ClickableSpan clickable = new ClickableSpan() {
            public void onClick(View view) {
                String url = BASE_WIKI_URL + span.getURL();
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                startActivity(intent);
            }
        };
        builder.setSpan(clickable, start, end, flags);
        builder.removeSpan(span);
    }
}
