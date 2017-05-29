package com.mohitum.openweatherdemo.ui;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mohitum.openweatherdemo.constants.AppConstants;
import com.mohitum.openweatherdemo.models.List;

import static com.mohitum.openweatherdemo.constants.AppConstants.DEF_FORECAST_COUNT;

/**
 * A simple pager adapter that represents 5 forecast objects, in sequence
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class ForecastPagerAdapter extends FragmentStatePagerAdapter {

    private java.util.List<List> forecastDataList;

    public ForecastPagerAdapter(FragmentManager fm, java.util.List<List> forecastDataList) {
        super(fm);
        this.forecastDataList = forecastDataList;
    }

    @Override
    public Fragment getItem(int position) {
        ForecastFragment fragment = new ForecastFragment();

        Bundle args = new Bundle();
        args.putParcelable(AppConstants.INTENT_DATA, forecastDataList.get(position));

        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public int getCount() {
        return forecastDataList.size();
    }

    @Override
    public float getPageWidth(int position) {
        return 1.0f/DEF_FORECAST_COUNT;
    }
}
