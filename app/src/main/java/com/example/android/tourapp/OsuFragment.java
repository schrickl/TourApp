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
 * {@link Fragment} that displays a list of Ohio State POIs.
 */
public class OsuFragment extends Fragment {

    public OsuFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_list, container, false);

        // Create a list of pois
        final ArrayList<Poi> pois = new ArrayList<Poi>();
        pois.add(new Poi(R.string.osu_stadium, R.string.address_stadium, R.string.url_stadium, R.drawable.osu_stadium));
        pois.add(new Poi(R.string.osu_center, R.string.address_center, R.string.url_center, R.drawable.osu_center));
        pois.add(new Poi(R.string.osu_hayes, R.string.address_hayes, R.string.url_hayes, R.drawable.osu_hayes));
        pois.add(new Poi(R.string.osu_howlett, R.string.address_howlett, R.string.url_howlett, R.drawable.osu_howlett));
        pois.add(new Poi(R.string.osu_union, R.string.address_union, R.string.url_union, R.drawable.osu_union));
        pois.add(new Poi(R.string.osu_orton, R.string.address_orton, R.string.url_orton, R.drawable.osu_orton));
        pois.add(new Poi(R.string.osu_wexner, R.string.address_wexner, R.string.url_wexner, R.drawable.osu_wexner));
        pois.add(new Poi(R.string.osu_rpac, R.string.address_rpac, R.string.url_rpac, R.drawable.osu_rpac));

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

