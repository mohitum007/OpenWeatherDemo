package com.mohitum.openweatherdemo.ui;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mohitum.openweatherdemo.R;
import com.mohitum.openweatherdemo.api.ApiClient;
import com.mohitum.openweatherdemo.api.AppUrls;
import com.mohitum.openweatherdemo.api.IApiInterface;
import com.mohitum.openweatherdemo.baseui.BaseActivity;
import com.mohitum.openweatherdemo.models.Forecast;
import com.mohitum.openweatherdemo.models.List;
import com.mohitum.openweatherdemo.models.Temp;
import com.mohitum.openweatherdemo.utilities.AppLogger;
import com.mohitum.openweatherdemo.utilities.UIUtils;
import com.mohitum.openweatherdemo.utilities.Utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

import static com.mohitum.openweatherdemo.constants.AppConstants.DEF_FORECAST_COUNT;
import static com.mohitum.openweatherdemo.constants.AppConstants.DEF_LATITUDES;
import static com.mohitum.openweatherdemo.constants.AppConstants.DEF_LONGITUDES;
import static com.mohitum.openweatherdemo.constants.AppConstants.OPEN_WEATHER_APP_ID;

/**
 * Class to present application main Home screen
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class WeatherHomeActivity extends BaseActivity {

    /**
     * Progress dialog instance to show for time consuming process
     */
    private ProgressDialog progressDialog;

    /**
     * Retrofit api service instance
     */
    private IApiInterface apiService;

    private ViewPager vwPgrForecast;
    
    private TextView txtVwCity;
    private TextView txtVwDate;
    private TextView txtVwDetails;
    private TextView txtVwTemperature;
    private ImageView imgVwWeatherIcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_weather_home);
    }

    @Override
    public void getIntentData() {
        //No action required
    }

    @Override
    public void initializeLayout() {
        apiService = ApiClient.getClient().create(IApiInterface.class);

        txtVwCity = (TextView) findViewById(R.id.txt_vw_city);
        txtVwDate = (TextView) findViewById(R.id.txt_vw_date);
        txtVwDetails = (TextView) findViewById(R.id.txt_vw_details);
        txtVwTemperature = (TextView) findViewById(R.id.txt_vw_temperature);
        imgVwWeatherIcon = (ImageView) findViewById(R.id.img_vw_weather_icon);
        
        vwPgrForecast = (ViewPager) findViewById(R.id.vw_pgr_forecast);
    }

    @Override
    public void setUpActivityListeners() {
        //No action required
    }

    @Override
    public void setUpActivityLayout() {
        if(Utils.isInternetConnectionAvaliable(WeatherHomeActivity.this)) {
            getForecastData();
        } else {
            UIUtils.showMessageInSnackBar(WeatherHomeActivity.this, getString(R.string.no_internet_connection));
        }
    }

    private void getForecastData(){
        progressDialog = UIUtils.showProgressDialog(WeatherHomeActivity.this, getString(R.string.loading_default_message));
        Call<Forecast> call = apiService.getForcast(DEF_LATITUDES, DEF_LONGITUDES,
                String.valueOf(DEF_FORECAST_COUNT), OPEN_WEATHER_APP_ID);
        call.enqueue(new Callback<Forecast>() {
            @Override
            public void onResponse(Call<Forecast> call, Response<Forecast> response) {
                UIUtils.dismissProgressDialog(progressDialog);
                Forecast forecastResponse = response.body();
                if(forecastResponse != null) {
                    java.util.List<List> forecastList = forecastResponse.getList();
                    ForecastPagerAdapter forecastPagerAdapter = new ForecastPagerAdapter(getSupportFragmentManager(), forecastList);
                    vwPgrForecast.setAdapter(forecastPagerAdapter);

                    updateUIWithTodaysForecast(forecastResponse.getCity().getName() + ", " + forecastResponse.getCity().getCountry(), forecastList.get(0));
                } else {
                    UIUtils.showMessageInSnackBar(WeatherHomeActivity.this, getString(R.string.data_not_found));
                }
            }

            @Override
            public void onFailure(Call<Forecast> call, Throwable throwable) {
                UIUtils.dismissProgressDialog(progressDialog);
                AppLogger.logThrowableError(throwable, getClass().getSimpleName());
                UIUtils.showMessageInSnackBar(WeatherHomeActivity.this, getString(R.string.server_error));
            }
        });
    }

    private void updateUIWithTodaysForecast(String cityName, List forecast){
        txtVwCity.setText(cityName);
        long dateStamp = forecast.getDt();
        SimpleDateFormat format = new SimpleDateFormat("E, dd MMMM yyyy ", Locale.US);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(dateStamp*1000L);
        txtVwDate.setText(format.format(calendar.getTime()));
        String details = forecast.getWeather().get(0).getDescription().toUpperCase(Locale.US) +
                "\n" + "Humidity: " + forecast.getHumidity() + "%" +
                "\n" + "Pressure: " + forecast.getPressure() + " hPa";
        txtVwDetails.setText(details);

        Temp tempurature = forecast.getTemp();
        String temperatureText = "Minimum: " + String.format(Locale.US, "%.1f", tempurature.getMin() - 273.15) + "℃, " + "Maximum: " + String.format(Locale.US, "%.1f", tempurature.getMax() - 273.15) + "℃" +
                "\n" + "Day Time: " + String.format(Locale.US, "%.1f", tempurature.getDay() - 273.15) + "℃, " + "Night Time: " + String.format(Locale.US, "%.1f", tempurature.getNight() - 273.15) + "℃" +
                "\n" + "Morning: " + String.format(Locale.US, "%.1f", tempurature.getMorn() - 273.15) + "℃, " + "Evening: " + String.format(Locale.US, "%.1f", tempurature.getEve() - 273.15) + "℃";
        txtVwTemperature.setText(temperatureText);


        Glide.with(WeatherHomeActivity.this)
                .load(AppUrls.ICON_URL.replace(AppUrls.ICON_ID_KEY, forecast.getWeather().get(0).getIcon())).into(imgVwWeatherIcon);
    }
}
