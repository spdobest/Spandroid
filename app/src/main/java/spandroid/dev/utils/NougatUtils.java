package spandroid.dev.utils;

import android.os.Build;

/**
 * Created by root on 11/24/17.
 */

public class NougatUtils {


    /**
     * Check if the device OS version is NOUGHT OR above (24 or above)
     *
     * @return
     */

    public static boolean isNougatDevice() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            return true;
        } else {
            return false;
        }
    }
}
