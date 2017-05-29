package com.mohitum.openweatherdemo.utilities;

import android.util.Log;

/**
 * Class to log the exceptions, info and errors
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class AppLogger {

    /**
     * Tag to log the exception in stack trace
     */
    private static final String EXCEPTON_TAG = "MyException";

    /**
     * Tag to log the information in stack trace
     */
    private static final String INFO_TAG = "MyInfo";

    /**
     * Flag to trace logs for debugging only
     */
    private static final boolean IS_IN_DEBUG_MODE = true;

    /**
     * Private Constructor to hide the implicit public one
     */
    private AppLogger(){
        //No action required
    }

    /**
     * Method to log the exceptions and errors in logcat. Developer can set the tag to view in logcat
     *
     * @param error error message
     * @param className class name where exception occurs
     */
    public static void logError(Exception error, String className){
        String methodName = Utils.getMethodName(2);   // 2 is used to fetch the calling method name where exception occurs

        if(IS_IN_DEBUG_MODE){    /* If application in debug mode then log the exception in logcat*/
            Log.e(EXCEPTON_TAG, "Error:" + error + " Method " + methodName + " Class Name " + className);
        }
    }

    /**
     * Method to log the Throwable and errors in logcat. Developer can set the tag to view in logcat
     *
     * @param error error message
     * @param className class name where Throwable occurs
     */
    public static void logThrowableError(Throwable error, String className){
        String methodName = Utils.getMethodName(2);   // 2 is used to fetch the calling method name where Throwable occurs

        if(IS_IN_DEBUG_MODE){    /* If application in debug mode then log the exception in logcat*/
            Log.e(EXCEPTON_TAG, "Error:" + error + " Method " + methodName + " Class Name " + className);
        }
    }


    /**
     * Method to log the information in logcat. Developer can set the tag to @INFO_TAG to view in logcat
     *
     * @param info message to log in logcat
     */
    public static void logInfo(String info){
        if(IS_IN_DEBUG_MODE){
            Log.i(INFO_TAG, info);
        }
    }
}
