package com.mohitum.openweatherdemo.api;

import com.mohitum.openweatherdemo.models.Forecast;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Interface to manage web api calls with their callbacks
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public interface IApiInterface {

    /**
     * This method will get forecast for 5 days with 3 hours refresh interval
     *
     * @param latitudes location latitudes
     * @param longitudes location longitudes
     * @param appid open weather appId for API access
     *
     * @return the weather forecast in the in the Forecast response Object
     */
    @GET(AppUrls.GET_FORCAST)
    Call<Forecast> getForcast(@Query("lat") String latitudes,
                              @Query("lon") String longitudes,
                              @Query("cnt") String count,
                              @Query("appid") String appid);
}