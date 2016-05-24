package com.jsvoid.solarsystem.models;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.Html;
import android.text.Spanned;

import com.google.gson.annotations.SerializedName;

/**
 * CelestialObject
 *
 * @author aditya.sharat
 */
public class CelestialObject implements Parcelable {

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

    public CelestialObject(Parcel source) {
        name = source.readString();
        thumbnailUrl = source.readString();
        imageUrl = source.readString();
        details = source.readString();
    }

    public static final Creator<CelestialObject> CREATOR = new Creator<CelestialObject>() {
        @Override
        public CelestialObject createFromParcel(Parcel source) {
            return new CelestialObject(source);
        }

        @Override
        public CelestialObject[] newArray(int size) {
            return new CelestialObject[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(thumbnailUrl);
        dest.writeString(imageUrl);
        dest.writeString(details);
    }
}
