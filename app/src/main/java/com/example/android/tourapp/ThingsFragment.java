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
 * {@link Fragment} that displays a list of things to do POIs.
 */
public class ThingsFragment extends Fragment {

    public ThingsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_list, container, false);

        // Create a list of pois
        final ArrayList<Poi> pois = new ArrayList<Poi>();
        pois.add(new Poi(R.string.todo_cosi, R.string.address_cosi, R.string.url_cosi, R.drawable.todo_cosi));
        pois.add(new Poi(R.string.todo_zoo, R.string.address_zoo, R.string.url_zoo, R.drawable.todo_zoo));
        pois.add(new Poi(R.string.todo_easton, R.string.address_easton, R.string.url_easton, R.drawable.todo_easton));
        pois.add(new Poi(R.string.todo_gardens, R.string.address_gardens, R.string.url_gardens, R.drawable.todo_gardens));
        pois.add(new Poi(R.string.todo_theater, R.string.address_theater, R.string.url_theater, R.drawable.todo_theater));
        pois.add(new Poi(R.string.todo_arena, R.string.address_arena, R.string.url_arena, R.drawable.todo_arena));
        pois.add(new Poi(R.string.todo_market, R.string.address_market, R.string.url_market, R.drawable.todo_market));
        pois.add(new Poi(R.string.todo_village, R.string.address_village, R.string.url_village, R.drawable.todo_village));

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
