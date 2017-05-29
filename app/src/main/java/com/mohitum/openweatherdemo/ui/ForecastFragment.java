package com.mohitum.openweatherdemo.ui;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mohitum.openweatherdemo.R;
import com.mohitum.openweatherdemo.api.AppUrls;
import com.mohitum.openweatherdemo.baseui.BaseFragment;
import com.mohitum.openweatherdemo.constants.AppConstants;
import com.mohitum.openweatherdemo.models.List;
import com.mohitum.openweatherdemo.models.Temp;
import com.mohitum.openweatherdemo.utilities.UIUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class ForecastFragment extends BaseFragment {

    private View rootView;

    private TextView txtVwDate;
    private TextView txtVwTemperature;
    private ImageView imgVwWeatherIcon;

    private List forecast;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_forecast, container, false);
        initFragment();
        return rootView;
    }

    @Override
    public void getArgumentsData() {
        Bundle arguments = getArguments();
        if(arguments != null){
            forecast = arguments.getParcelable(AppConstants.INTENT_DATA);
        }
    }

    @Override
    public void initializeLayout() {
        txtVwDate = (TextView)rootView.findViewById(R.id.txt_vw_date);
        txtVwTemperature = (TextView)rootView.findViewById(R.id.txt_vw_temperature);
        imgVwWeatherIcon = (ImageView)rootView.findViewById(R.id.img_vw_weather_icon);
    }

    @Override
    public void setUpFragmentListeners() {
        // No action required
    }

    @Override
    public void setUpFragmentLayout() {
        if(forecast != null){
            long dateStamp = forecast.getDt();
            SimpleDateFormat format = new SimpleDateFormat("E, dd MMM", Locale.US);
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(dateStamp*1000L);
            txtVwDate.setText(format.format(calendar.getTime()));

            Temp tempurature = forecast.getTemp();
            String temperatureText = String.format(Locale.US, "%.0f", tempurature.getMin() - 273.15) + "℃/" + String.format(Locale.US, "%.0f", tempurature.getMax() - 273.15) + "℃";
            txtVwTemperature.setText(temperatureText);


            Glide.with(getActivity())
                    .load(AppUrls.ICON_URL.replace(AppUrls.ICON_ID_KEY, forecast.getWeather().get(0).getIcon())).into(imgVwWeatherIcon);
        }
    }


}
