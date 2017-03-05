package com.example.android.tourapp;

/**
 * {@link Poi} represents a place of interest that the user may want to visit.
 * It contains resource IDs for the name, address, url, and image of that POI.
 */
public class Poi {

    /**
     * String resource ID for the name of the Poi.
     */
    private int mPoiName;

    /**
     * String resource ID for the address of the Poi
     */
    private int mPoiAddress;

    /**
     * String resource ID for the url of the POI.
     */
    private int mPoiUrl;

    /**
     * Image resource ID for the POI.
     */
    private int mImageResourceId;

    /**
     * Create a new Poi object.
     *
     * @param name is the string resource ID for the name of the POI
     * @param address is the string resource ID for the address of the POI
     * @param url is the string resource ID for the url of the POI
     * @param imageResourceId is the resource ID for the image associated with this POI
     */
    public Poi(int name, int address, int url, int imageResourceId) {
        mPoiName = name;
        mPoiAddress = address;
        mPoiUrl = url;
        mImageResourceId = imageResourceId;
    }

    /**
     * Get the string resource ID for the name of the POI.
     */
    public int getPoiName() {
        return mPoiName;
    }

    /**
     * Get the string resource ID for the address of the POI.
     */
    public int getPoiAddress() {
        return mPoiAddress;
    }

    /**
     * Get the string resource ID for the url of the POI.
     */
    public int getPoiUrl() {
        return mPoiUrl;
    }

    /**
     * Return the image resource ID of the POI.
     */
    public int getImageResourceId() {
        return mImageResourceId;
    }
}
