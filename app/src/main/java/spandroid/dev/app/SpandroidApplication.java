package spandroid.dev.app;

import android.app.Application;
import android.content.Context;

/**
 * Created by root on 1/2/18.
 */

public class SpandroidApplication extends Application{

    private static Context appContext = null;
    private static SpandroidApplication instance;

    public static SpandroidApplication getStateInstance() {
        return instance;
    }

    public static Context getInstance() {
        return SpandroidApplication.appContext;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
    }
}
