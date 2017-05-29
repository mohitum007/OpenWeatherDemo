package com.mohitum.openweatherdemo.baseui;

import android.support.v4.app.Fragment;

/**
 * Base class for application fragments.
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public abstract class BaseFragment extends Fragment {

    /**
     * Initialize Fragment view and layout components
     */
    public void initFragment(){
        getArgumentsData();
        initializeLayout();
        setUpFragmentListeners();
        setUpFragmentLayout();
    }

    /**
     * Get data from Fragment launching arguments
     */
    public abstract void getArgumentsData();

    /**
     * Initialize layout from XML components
     */
    public abstract void initializeLayout();

    /**
     * Set up Fragment component listeners and various interface callbacks
     */
    public abstract void setUpFragmentListeners();

    /**
     * Set up layout components data and related runtime initialization and changes
     */
    public abstract void setUpFragmentLayout();
}