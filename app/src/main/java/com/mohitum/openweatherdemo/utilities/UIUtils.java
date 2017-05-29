package com.mohitum.openweatherdemo.utilities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.widget.TextView;

import com.mohitum.openweatherdemo.R;

/**
 * Class containing UI utilities
 * Created by mohitum on 26-05-2017.
 *
 * @version 1.0
 */
public class UIUtils {

    /**
     * Private Constructor to hide the implicit public one
     */
    private UIUtils() {
        // No initialization required
    }

    /**
     * Show any error or info messages on the activity UI in SnackBar.
     *
     * @param activity calling activity context
     * @param message message to display
     */
    public static void showMessageInSnackBar(Activity activity, CharSequence message){
        Snackbar snackbar = Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_LONG);

        // Changing message text color
        View sbView = snackbar.getView();
        TextView textView = (TextView) sbView.findViewById(android.support.design.R.id.snackbar_text);
        textView.setTextColor(Color.YELLOW);
        snackbar.show();
    }

    /**
     * Method to show progress alert dialog with custom message
     *
     * @param mActivity calling activity context
     * @param message custom message
     */
    public static ProgressDialog showProgressDialog(Context mActivity, String message) {
        ProgressDialog progressDialog = new ProgressDialog(mActivity);
        progressDialog.setMessage(message);
        progressDialog.setCancelable(false);
        progressDialog.setIndeterminate(true);
        progressDialog.show();
        return progressDialog;
    }

    /**
     * Dismisses a dialog if already running
     *
     * @param dialog dialog to be dismissed
     */
    public static void dismissProgressDialog(ProgressDialog dialog) {
        if (dialog != null && dialog.isShowing()) { //  check for null and showing
            // dismiss the dialog
            dialog.dismiss();
        }
    }
}
