package spandroid.dev.managers;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

/**
 * Created by sibaprasad on 14/01/18.
 */

public class AnalyticsManager {

    static FirebaseAnalytics firebaseAnalytics = null;

    public static FirebaseAnalytics getInstance(Context context) {
        if (firebaseAnalytics == null) {
            firebaseAnalytics = FirebaseAnalytics.getInstance(context);
        }
        return firebaseAnalytics;
    }

    public static void sendClick(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("item_purchased", "Pizza");
        bundle.putInt("item_quantity", 1);
        getInstance(context).logEvent("MenuClick", bundle);
    }

    public static void startGame(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("item_purchased", "Pizza");
        bundle.putInt("item_quantity", 1);

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("StartGame", bundle);
    }

    public static void selectMatrix(Context context, String typeOfMatrix) {
        Bundle bundle = new Bundle();
        bundle.putString("item_quantity", typeOfMatrix);

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("SelectMatrix", bundle);
    }

    public static void share(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("click", "share");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("share", bundle);
    }

    public static void aboutUs(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("click", "aboutUs");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("MenuClick", bundle);
    }


    public static void hint(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("Click", "hint");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("Hint", bundle);
    }

    public static void reset(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("click", "reset");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("Reset", bundle);
    }

    public static void menu(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("click", "menu");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("Menu", bundle);
    }

    public static void next(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("click", "next");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("Next", bundle);
    }

    public static void prev(Context context) {
        Bundle bundle = new Bundle();
        bundle.putString("click", "prev");

        //Sets whether analytics collection is enabled for this app on this device.
        getInstance(context).setAnalyticsCollectionEnabled(true);
        //Sets the minimum engagement time required before starting a session. The default value is 10000 (10 seconds). Let's make it 20 seconds just for the fun
        getInstance(context).setMinimumSessionDuration(20000);
        //Sets the duration of inactivity that terminates the current session. The default value is 1800000 (30 minutes).
        getInstance(context).setSessionTimeoutDuration(500);

        getInstance(context).logEvent("Prev", bundle);
    }

}
