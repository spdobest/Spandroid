package spandroid.dev.dagger2.di.component;


import dagger.Component;
import spandroid.dev.dagger2.Dagger2Activity;
import spandroid.dev.dagger2.di.PerActivity;
import spandroid.dev.dagger2.di.module.ActivityModule;

/**
 * Created by janisharali on 08/12/16.
 */

@PerActivity
@Component(dependencies = ApplicationComponent.class, modules = ActivityModule.class)
public interface ActivityComponent {

    void inject(Dagger2Activity mainActivity);

}