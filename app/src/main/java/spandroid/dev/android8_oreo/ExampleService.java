package spandroid.dev.android8_oreo;

import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.JobIntentService;

import javax.annotation.Nullable;

public class ExampleService extends JobIntentService {

    // Must create a default constructor
    public ExampleService() {
        super();
    }

    @Override
    protected void onHandleWork(@NonNull Intent intent) {

    }

}