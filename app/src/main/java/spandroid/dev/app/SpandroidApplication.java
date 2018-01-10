package spandroid.dev.app;

import android.app.Application;
import android.content.Context;

import javax.inject.Inject;

import spandroid.dev.dagger2.data.DataManager;
import spandroid.dev.dagger2.di.component.ApplicationComponent;
import spandroid.dev.dagger2.di.module.ApplicationModule;

/**
 * Created by root on 1/2/18.
 */

public class SpandroidApplication extends Application{

    private static Context appContext = null;
    private static SpandroidApplication instance;
    protected ApplicationComponent applicationComponent;
    @Inject
    DataManager dataManager;

    public static SpandroidApplication getStateInstance() {
        return instance;
    }

    public static Context getInstance() {
        return SpandroidApplication.appContext;
    }

    public static SpandroidApplication get(Context context) {
        return (SpandroidApplication) context.getApplicationContext();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        appContext = getApplicationContext();
        applicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(new ApplicationModule(this))
                .build();
        applicationComponent.inject(this);
    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }

}
