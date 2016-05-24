package com.jsvoid.solarsystem.models;

import android.support.annotation.Nullable;
import android.text.Html;
import android.text.Spanned;

import com.google.gson.annotations.SerializedName;

/**
 * CelestialObject
 *
 * @author aditya.sharat
 */
public class CelestialObject {

    @SerializedName("name")
    public final String name;

    @SerializedName("details")
    public final String details;

    @SerializedName("imageUrl")
    public final String imageUrl;

    @SerializedName("thumbnailUrl")
    public final String thumbnailUrl;

    private Spanned detailsHtml;
    private String detailsStriped;

    public CelestialObject(String name, String details, String imageUrl, String thumbnailUrl) {
        this.name = name;
        this.details = details;
        this.imageUrl = imageUrl;
        this.thumbnailUrl = thumbnailUrl;
    }

    public Spanned getDetailsHtml() {
        if (detailsHtml == null) {
            detailsHtml = Html.fromHtml(details);
        }
        return detailsHtml;
    }

    public String getDetailsStriped() {
        if (detailsStriped == null) {
            detailsStriped = getDetailsHtml().toString();
        }
        return detailsStriped;
    }
}
