/*
 * Copyright © 2016, Craftsvilla.com
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.common;

import android.content.Context;
import android.util.DisplayMetrics;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class MemoryUtil {

    public static int getCacheSize(Context ctx) {
        final DisplayMetrics displayMetrics = ctx.getResources().
                getDisplayMetrics();
        final int screenWidth = displayMetrics.widthPixels;
        final int screenHeight = displayMetrics.heightPixels;
        // 4 bytes per pixel
        final int screenBytes = screenWidth * screenHeight * 4;

        return screenBytes * 3;
    }
}
