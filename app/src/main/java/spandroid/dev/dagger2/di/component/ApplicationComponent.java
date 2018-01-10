package spandroid.dev.dagger2.di.component;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Component;
import spandroid.dev.app.SpandroidApplication;
import spandroid.dev.dagger2.data.DataManager;
import spandroid.dev.dagger2.data.DbHelper;
import spandroid.dev.dagger2.data.SharedPrefsHelper;
import spandroid.dev.dagger2.di.ApplicationContext;
import spandroid.dev.dagger2.di.module.ApplicationModule;


/**
 * Created by janisharali on 08/12/16.
 */

@Singleton
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

    void inject(SpandroidApplication demoApplication);

    @ApplicationContext
    Context getContext();

    Application getApplication();

    DataManager getDataManager();

    SharedPrefsHelper getPreferenceHelper();

    DbHelper getDbHelper();

}