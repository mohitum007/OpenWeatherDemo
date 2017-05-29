package com.mohitum.openweatherdemo.baseui;

import android.support.annotation.LayoutRes;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;

/**
 * Base class for application activities.
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        initActivity();
    }

    @Override
    public void setContentView(View view) {
        super.setContentView(view);
        initActivity();
    }

    @Override
    public void setContentView(View view, ViewGroup.LayoutParams params) {
        super.setContentView(view, params);
        initActivity();
    }

    /**
     * Initialize activity view and layout components
     */
    private void initActivity(){
        getIntentData();
        initializeLayout();
        setUpActivityListeners();
        setUpActivityLayout();
    }

    /**
     * Get data from activity launching intent
     */
    public abstract void getIntentData();

    /**
     * Initialize layout from XML components
     */
    public abstract void initializeLayout();

    /**
     * Set up activity component listeners and various interface callbacks
     */
    public abstract void setUpActivityListeners();

    /**
     * Set up layout components data and related runtime initialization and changes
     */
    public abstract void setUpActivityLayout();

}