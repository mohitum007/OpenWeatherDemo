package com.mohitum.openweatherdemo.api;

public class AppUrls {

    /**
     * Base url for the open weather web apis
     */
    private static final String BASE_URL = "http://api.openweathermap.org/";

    /**
     * open weather web apis release version
     */
    private static final String API_VERSION_STRING = "data/2.5/";

    /**
     * Base url for the accessing open weather web apis
     */
    static final String API_BASE_URL = BASE_URL + API_VERSION_STRING;

    /**
     * Web api method folder to get forecast for 5 days with 3 hours refresh interval
     */
    static final String GET_FORCAST = "forecast/daily";

    public static final String ICON_ID_KEY = "icon_id";

    public static final String ICON_URL = "http://openweathermap.org/img/w/" + ICON_ID_KEY + ".png";

}