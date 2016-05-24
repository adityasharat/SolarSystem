package com.jsvoid.solarsystem.models;

import com.google.gson.annotations.SerializedName;

/**
 * CelestialObject
 *
 * @author aditya.sharat
 */
public class CelestialObject {

    public final String name;

    public final String details;

    public final String imageUrl;

    @SerializedName("thumbnailUrl")
    public final String thumbnailUrl;

    public CelestialObject(String name, String details, String imageUrl, String thumbnailUrl) {
        this.name = name;
        this.details = details;
        this.imageUrl = imageUrl;
        this.thumbnailUrl = thumbnailUrl;
    }
}
