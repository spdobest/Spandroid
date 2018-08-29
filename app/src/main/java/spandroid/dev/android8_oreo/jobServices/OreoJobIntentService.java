package spandroid.dev.android8_oreo.jobServices;

import android.content.Context;
import android.content.Intent;
import android.support.v4.app.JobIntentService;

public class OreoJobIntentService extends JobIntentService {

    public static void enqueueWork(Context context, Intent work) {
        enqueueWork(context, OreoJobIntentService.class,123, work);
    }

    @Override
    protected void onHandleWork(Intent intent) {
        performTask();
    }

    private void performTask(){

    }
}