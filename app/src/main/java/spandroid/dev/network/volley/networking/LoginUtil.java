/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.network.volley.networking;

import android.content.Context;
import android.text.TextUtils;

import spandroid.dev.network.volley.VolleyPreferenceManager;

/**
 * Created by Mahesh Nayak on 23-03-2016.
 */
public class LoginUtil {

    public static boolean isUserLoggedIn(Context ctx) {
        VolleyPreferenceManager manager = VolleyPreferenceManager.getInstance(ctx);
        return !TextUtils.isEmpty(manager.getToken());
    }
}
