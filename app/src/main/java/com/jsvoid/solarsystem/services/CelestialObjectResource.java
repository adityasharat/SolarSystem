package com.jsvoid.solarsystem.services;

import com.jsvoid.solarsystem.models.CelestialObject;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * CelestialObjectResource
 *
 * @author aditya.sharat
 */
public interface CelestialObjectResource {
    @GET("objects.json")
    Call<List<CelestialObject>> query();
}
