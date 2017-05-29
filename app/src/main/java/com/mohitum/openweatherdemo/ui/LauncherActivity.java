package com.mohitum.openweatherdemo.ui;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import com.mohitum.openweatherdemo.R;
import com.mohitum.openweatherdemo.baseui.BaseActivity;

/**
 * Class to present application Splash launcher screen
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class LauncherActivity extends BaseActivity implements Runnable {

    /**
     * Handler to handle the runnable thread on completion
     */
    private Handler splashTimeHandler;

    /**
     * Splash display time
     */
    private static final long SPLASH_RUN_TIME = 2000L;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);
    }

    @Override
    public void getIntentData() {
        //No action required
    }

    @Override
    public void initializeLayout() {
        //No action required
    }

    @Override
    public void setUpActivityListeners() {
        //No action required
    }

    @Override
    public void setUpActivityLayout() {
        splashTimeHandler = new Handler();
        splashTimeHandler.postDelayed(this, SPLASH_RUN_TIME);
    }

    @Override
    public void run() {
        // Start Home activity and finish current activity.
        Intent homeIntent = new Intent(LauncherActivity.this, WeatherHomeActivity.class);
        LauncherActivity.this.startActivity(homeIntent);
        LauncherActivity.this.finish();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        // remove callbacks
        splashTimeHandler.removeCallbacks(this);
    }

}
