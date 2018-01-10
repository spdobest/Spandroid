package spandroid.dev.alarmManager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import spandroid.dev.app.SpandroidApplication;


public class BootLoaderReciever extends BroadcastReceiver {
    private static final String TAG = "BootLoaderReciever";

    @Override
    public void onReceive(Context context, Intent intent) {
        AlarmUtility.setAlarm(SpandroidApplication.getInstance());
    }
}