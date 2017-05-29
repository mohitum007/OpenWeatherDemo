package com.mohitum.openweatherdemo.utilities;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Class containing common Utility methods
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class Utils {

    /**
     * Private Constructor to hide the implicit public one
     */
    private Utils() {
        // No initialization required
    }

    /**
     * Get the method name for a depth in call stack.
     * Utility function
     *
     * @param depth depth in the call stack (0 means current method, 1 means call method, ...)
     * @return method name
     */
    static String getMethodName(int depth) {
        StackTraceElement[] ste = Thread.currentThread().getStackTrace();
        /* Add 0 is getStackTrace(),
        Add 1 is getMethodName(int depth) and
        Add 2 is invoking method. */
        return ste[2 + depth].getMethodName(); //Thank you Tom Tresansky
    }

    /**
     * Check if internet connection is available or not
     *
     * @param mContext calling context of the application
     * @return true if internet is available else false
     */
    public static boolean isInternetConnectionAvaliable(Context mContext) {
        if (null == mContext) {
            return true;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) mContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        // test for connection
        NetworkInfo netInfo = null;
        if (null != connectivityManager) {
            netInfo = connectivityManager.getActiveNetworkInfo();
        }
        return (null != netInfo && netInfo.isAvailable() && netInfo.isConnected());
    }
}
