package com.jsvoid.solarsystem.adapters;

import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.jsvoid.solarsystem.R;
import com.jsvoid.solarsystem.models.CelestialObject;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * CelestialObjectAdapter
 *
 * @author aditya.sharat
 */
public class CelestialObjectAdapter extends RecyclerView.Adapter<CelestialObjectAdapter.CelestialObjectViewHolder> {

    private final String baseUrl;
    @Nullable
    LayoutInflater inflater;
    @Nullable
    private Listener listener;
    @Nullable
    private List<CelestialObject> objects;

    public CelestialObjectAdapter(String baseUrl, @Nullable List<CelestialObject> objects) {
        this.objects = objects;
        this.baseUrl = baseUrl;
    }

    @Override
    public CelestialObjectViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (inflater == null) {
            inflater = LayoutInflater.from(parent.getContext());
        }

        View view = inflater.inflate(R.layout.celestial_object_list_item, parent, false);
        return new CelestialObjectViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CelestialObjectViewHolder holder, int position) {
        if (objects != null) {
            holder.update(objects.get(position), position);
        }
    }

    @Override
    public int getItemCount() {
        if (objects == null) {
            return 0;
        }
        return objects.size();
    }

    public Listener getListener() {
        return listener;
    }

    public void setListener(@Nullable Listener listener) {
        this.listener = listener;
    }

    public void update(List<CelestialObject> objects) {
        this.objects = objects;
        notifyDataSetChanged();
    }

    public interface Listener {
        void onSelect(CelestialObject object);
    }

    public class CelestialObjectViewHolder extends RecyclerView.ViewHolder {

        private int itemPosition;
        private TextView mName;
        private ImageView mImage;

        public CelestialObjectViewHolder(View itemView) {
            super(itemView);
            setup();
        }

        private void setup() {
            mName = (TextView) itemView.findViewById(R.id.object_name);
            mImage = (ImageView) itemView.findViewById(R.id.object_image);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null && objects != null) {
                        listener.onSelect(objects.get(getItemPosition()));
                    }
                }
            });
        }

        public void update(CelestialObject object, int position) {
            mName.setText(object.name);
            Picasso.with(mImage.getContext())
                    .load(baseUrl + object.thumbnailUrl)
                    .placeholder(R.drawable.image_preview)
                    .resize(mImage.getLayoutParams().width, mImage.getLayoutParams().height)
                    .into(mImage);
            setItemPosition(position);
        }

        public int getItemPosition() {
            return itemPosition;
        }

        public void setItemPosition(int position) {
            this.itemPosition = position;
        }
    }
}
