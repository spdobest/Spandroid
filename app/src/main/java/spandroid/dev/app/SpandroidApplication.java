package spandroid.dev.app;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

import javax.inject.Inject;

import spandroid.dev.R;
import spandroid.dev.dagger2.data.DataManager;
import spandroid.dev.dagger2.di.component.ApplicationComponent;
import spandroid.dev.dagger2.di.component.DaggerApplicationComponent;
import spandroid.dev.dagger2.di.module.ApplicationModule;

/**
 * Created by root on 1/2/18.
 */

public class SpandroidApplication extends Application{

    private static final String TAG = "SpandroidApplication";

    static ImageLoader imageLoader;

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

    public static ImageLoader getImageLoader() {
        if (imageLoader == null) {
            imageLoader = ImageLoader.getInstance();
        }
        return imageLoader;

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


        try {
            DisplayImageOptions options = new DisplayImageOptions.Builder()
                    .cacheOnDisk(true)
                    .cacheInMemory(true)
                    .considerExifParams(true)
                    .bitmapConfig(Bitmap.Config.RGB_565)
                    .resetViewBeforeLoading(true)
                    .showImageOnFail(R.drawable.empty_photo)
                    .showImageOnLoading(R.drawable.empty_photo)
                    .build();


            ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(getApplicationContext())
                    .denyCacheImageMultipleSizesInMemory()
                    .defaultDisplayImageOptions(options)
                    .memoryCache(new LruMemoryCache(4 * 1024 * 1024))
                    .memoryCacheSize(4 * 1024 * 1024)
                    .memoryCacheSizePercentage(25)
                    .writeDebugLogs()
                    .threadPriority(Thread.NORM_PRIORITY - 1) // default
                    .tasksProcessingOrder(QueueProcessingType.FIFO) // default
                    .denyCacheImageMultipleSizesInMemory()
                    .writeDebugLogs()
                    .build();


            imageLoader = ImageLoader.getInstance();
            imageLoader.init(config);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public ApplicationComponent getComponent() {
        return applicationComponent;
    }
}
