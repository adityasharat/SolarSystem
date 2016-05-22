package com.jsvoid.solarsystem.models;

/**
 * CelestialObject
 *
 * @author aditya.sharat
 */
public class CelestialObject {

    public final String name;
    public final String details;
    public final String imageUrl;

    public CelestialObject(String name, String details, String imageUrl) {
        this.name = name;
        this.details = details;
        this.imageUrl = imageUrl;
    }
}
