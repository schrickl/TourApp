package com.example.android.tourapp;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * {@link PoiAdapter} is an {@link ArrayAdapter} that can provide the layout for each list item
 * based on a data source, which is a list of {@link Poi} objects.
 */
public class PoiAdapter extends ArrayAdapter<Poi> {

    /**
     * Create a new {@link PoiAdapter} object.
     *
     * @param context is the current context (i.e. Activity) that the adapter is being created in.
     * @param pois is the list of {@link Poi}s to be displayed.
     */
    public PoiAdapter(Context context, ArrayList<Poi> pois) {
        super(context, 0, pois);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Check if an existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        // Get the {@link Poi} object located at this position in the list
        Poi currentPoi = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID name_text_view.
        TextView poiNameTextView = (TextView) listItemView.findViewById(R.id.name_text_view);
        // Get the name from the currentPoi object and set this text on
        // the POI name TextView.
        poiNameTextView.setText(currentPoi.getPoiName());

        // Find the TextView in the list_item.xml layout with the ID address_text_view.
        TextView poiAddressTextView = (TextView) listItemView.findViewById(R.id.address_text_view);
        // Get the default translation from the currentPoi object and set this text on
        // the default TextView.
        poiAddressTextView.setText(currentPoi.getPoiAddress());

        // Find the ImageView in the list_item.xml layout with the ID image.
        ImageView imageView = (ImageView) listItemView.findViewById(R.id.image);
        // Display the provided image based on the resource ID
        imageView.setImageResource(currentPoi.getImageResourceId());

        // Return the whole list item layout (containing 2 TextViews) so that it can be shown in
        // the ListView.
        return listItemView;
    }
}
