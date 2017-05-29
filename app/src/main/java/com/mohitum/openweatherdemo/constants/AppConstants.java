package com.mohitum.openweatherdemo.constants;

/**
 * Class to manage application constants
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class AppConstants {

    /****************** Intent extra data flags ********************/
    public static final String INTENT_DATA = "data";

    /****************** Default Location Constants (for Delhi, India) ********************/
    public static final String DEF_LATITUDES = "28.65195";
    public static final String DEF_LONGITUDES = "77.23149";
    public static final int DEF_FORECAST_COUNT = 5;

    public static final String OPEN_WEATHER_APP_ID = "263c6024d568f5510f1f7a5ab8c635a2";

    /**
     * Private Constructor to hide the implicit public one
     */
    private AppConstants() {
        // No initialization required
    }
}
