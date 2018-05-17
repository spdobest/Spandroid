package spandroid.dev.android8;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

public class AlarmReceiver extends BroadcastReceiver {
    Context ctx = null;

    public static final String CUSTOM_INTENT = "com.test.intent.action.ALARM";


    @Override
    public void onReceive(Context context, Intent intent) {
        /* enqueue the job */
        MyJobIntentService.Companion.enqueueWork(context, intent);
    }
    public static void cancelAlarm(Context context) {
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        
        /* cancel any pending alarm */
        alarm.cancel(getPendingIntent(context));
    }
    public static void setAlarm(boolean force,Context context) {
        cancelAlarm(context);
        AlarmManager alarm = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        // EVERY X MINUTES
        long delay = (1000 * 60 * 10);
        long when = System.currentTimeMillis();
        if (!force) {
            when += delay;
        }
        
        /* fire the broadcast */
        alarm.set(AlarmManager.RTC_WAKEUP, when, getPendingIntent(context));
    }
    private static PendingIntent getPendingIntent(Context ctx) {
        Intent alarmIntent = new Intent(ctx, AlarmReceiver.class);
        alarmIntent.setAction(CUSTOM_INTENT);

        return PendingIntent.getBroadcast(ctx, 0, alarmIntent, PendingIntent.FLAG_CANCEL_CURRENT);
    }
}