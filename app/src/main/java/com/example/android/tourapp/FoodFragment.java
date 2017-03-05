package com.example.android.tourapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * {@link Fragment} that displays a list of restaurant POIs.
 */
public class FoodFragment extends Fragment {

    public FoodFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_list, container, false);

        // Create a list of pois
        final ArrayList<Poi> pois = new ArrayList<Poi>();
        pois.add(new Poi(R.string.food_lindeys, R.string.address_lindeys, R.string.url_lindeys, R.drawable.food_lindeys));
        pois.add(new Poi(R.string.food_cucina, R.string.address_cucina, R.string.url_cucina, R.drawable.food_cucina));
        pois.add(new Poi(R.string.food_mitchells, R.string.address_mitchells, R.string.url_mitchells, R.drawable.food_mitchells));
        pois.add(new Poi(R.string.food_northstar, R.string.address_northstar, R.string.url_northstar, R.drawable.food_northstar));
        pois.add(new Poi(R.string.food_thurman, R.string.address_thurman, R.string.url_thurman, R.drawable.food_thurman));
        pois.add(new Poi(R.string.food_diner, R.string.address_diner, R.string.url_diner, R.drawable.food_diner));
        pois.add(new Poi(R.string.food_barcelona, R.string.address_barcelona, R.string.url_barcelona, R.drawable.food_barcelona));
        pois.add(new Poi(R.string.food_refectory, R.string.address_refectory, R.string.url_refectory, R.drawable.food_refectory));

        // Create an {@link PoiAdapter}, whose data source is a list of {@link Poi}s. The
        // adapter knows how to create list items for each item in the list.
        PoiAdapter adapter = new PoiAdapter(getActivity(), pois);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // poi_list.xml layout file.
        ListView listView = (ListView) rootView.findViewById(R.id.list);

        // Make the {@link ListView} use the {@link PoiAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Poi} in the list.
        listView.setAdapter(adapter);

        // Set a click listener to play the audio when the list item is clicked on
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                // Get the {@link Poi} object at the given position the user clicked on
                Poi poi = pois.get(position);
                // Grab the POI url from the current position and launch it in a web browser
                Intent i = new Intent(Intent.ACTION_VIEW, Uri.parse(getString(poi.getPoiUrl())));
                startActivity(i);
            }
        });

        return rootView;
    }
}
