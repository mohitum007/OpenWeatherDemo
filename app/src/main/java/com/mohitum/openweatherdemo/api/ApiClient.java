package com.mohitum.openweatherdemo.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Class to manage singleton retrofit Api Client instance
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class ApiClient {

    /**
     * Retrofit instance
     */
    private static Retrofit retrofit = null;

    /**
     * To get the retrofit API client instance
     *
     * @return create new or return an existing retrofit instance
     */
    public static Retrofit getClient() {
        if (retrofit==null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(AppUrls.API_BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}