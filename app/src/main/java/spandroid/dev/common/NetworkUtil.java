/*
 * Copyright © 2016, Craftsvilla.com
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class NetworkUtil {

    public static boolean isAvailable(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = cm.getActiveNetworkInfo();
        return (networkInfo != null && networkInfo.isConnected());
    }
}
