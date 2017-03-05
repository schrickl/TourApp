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
 * {@link Fragment} that displays a list of hotel POIs.
 */
public class HotelsFragment extends Fragment {

    public HotelsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.poi_list, container, false);

        // Create a list of pois
        final ArrayList<Poi> pois = new ArrayList<Poi>();
        pois.add(new Poi(R.string.hotel_homewood, R.string.address_homewood, R.string.url_homewood, R.drawable.hotel_homewood));
        pois.add(new Poi(R.string.hotel_blackwell, R.string.address_blackwell, R.string.url_blackwell, R.drawable.hotel_blackwell));
        pois.add(new Poi(R.string.hotel_hyatt, R.string.address_hyatt, R.string.url_hyatt, R.drawable.hotel_hyatt));
        pois.add(new Poi(R.string.hotel_hampton, R.string.address_hampton, R.string.url_hampton, R.drawable.hotel_hampton));
        pois.add(new Poi(R.string.hotel_drury, R.string.address_drury, R.string.url_drury, R.drawable.hotel_drury));
        pois.add(new Poi(R.string.hotel_meridien, R.string.address_meridien, R.string.url_meridien, R.drawable.hotel_meridien));
        pois.add(new Poi(R.string.hotel_residence, R.string.address_residence, R.string.url_residence, R.drawable.hotel_residence));
        pois.add(new Poi(R.string.hotel_holiday, R.string.address_holiday, R.string.url_holiday, R.drawable.hotel_holiday));

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
