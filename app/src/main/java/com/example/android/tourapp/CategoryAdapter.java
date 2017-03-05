package com.example.android.tourapp;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * {@link CategoryAdapter} is a {@link FragmentPagerAdapter} that can provide the layout for
 * each list item based on a data source which is a list of {@link Poi} objects.
 */
public class CategoryAdapter extends FragmentPagerAdapter {

    /** Context of the app */
    private Context mContext;

    /**
     * Create a new {@link CategoryAdapter} object.
     *
     * @param context is the context of the app
     * @param fm is the fragment manager that will keep each fragment's state in the adapter
     *           across swipes.
     */
    public CategoryAdapter(Context context, FragmentManager fm) {
        super(fm);
        mContext = context;
    }

    /**
     * Return the {@link Fragment} that should be displayed for the given page number.
     */
    @Override
    public Fragment getItem(int position) {
        Fragment frag = new Fragment();

        switch (position) {
            case 0:
                frag = new HotelsFragment();
                break;
            case 1:
                frag = new FoodFragment();
                break;
            case 2:
                frag = new ThingsFragment();
                break;
            case 3:
                frag = new OsuFragment();
                break;
        }

        return frag;
    }

    /**
     * Return the total number of pages.
     */
    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        CharSequence charSeq = "";

        switch (position) {
            case 0:
                charSeq = mContext.getString(R.string.category_hotels);
                break;
            case 1:
                charSeq = mContext.getString(R.string.category_restaurants);
                break;
            case 2:
                charSeq = mContext.getString(R.string.category_things);
                break;
            case 3:
                charSeq = mContext.getString(R.string.category_osu);
                break;
        }

        return charSeq;
    }
}
