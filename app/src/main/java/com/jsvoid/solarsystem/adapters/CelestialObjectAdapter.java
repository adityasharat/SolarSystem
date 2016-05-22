package com.jsvoid.solarsystem.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.jsvoid.solarsystem.models.CelestialObject;

import java.util.List;

/**
 * CelestialObjectAdapter
 *
 * @author aditya.sharat
 */
public class CelestialObjectAdapter extends RecyclerView.Adapter<CelestialObjectAdapter.CelestialObjectViewHolder> {

    private final List<CelestialObject> objects;

    public CelestialObjectAdapter(List<CelestialObject> objects) {
        this.objects = objects;
    }

    @Override
    public CelestialObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(CelestialObjectViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }

    public class CelestialObjectViewHolder extends RecyclerView.ViewHolder {

        public CelestialObjectViewHolder(View itemView) {
            super(itemView);
        }
    }
}
