package spandroid.dev.android8_oreo.notificationChannel;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.support.v4.app.NotificationCompat;
import android.support.v4.app.NotificationManagerCompat;

import spandroid.dev.R;

import static android.content.Context.NOTIFICATION_SERVICE;

public class NotificationUtility {

    // https://www.journaldev.com/19421/android-notification-channel-dots

    public void showNotification(Context context) {
        String channelId = "123";
        String channel_name = "Channelname";
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            NotificationChannel notificationChannel = new NotificationChannel(channelId, channel_name, NotificationManager.IMPORTANCE_HIGH);
            notificationChannel.enableLights(true);
            notificationChannel.enableVibration(true);
            notificationChannel.setVibrationPattern(new long[]{100, 200, 300, 400, 500, 400, 300, 200, 400});
            NotificationManager notificationManager = (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);
            notificationManager.createNotificationChannel(notificationChannel);
        } else {


            NotificationCompat.Builder notification = new NotificationCompat.Builder(context, "channel_id")
                    .setContentTitle("Test Title")
                    .setContentText("Test Message")
                    .setSmallIcon(R.mipmap.ic_launcher);


            @SuppressLint("ServiceCast") NotificationManagerCompat notificationManagerCompat = (NotificationManagerCompat) context.getSystemService(NOTIFICATION_SERVICE);

            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(NOTIFICATION_SERVICE);

            // notificationManager.notify(0, notificationManagerCompat);

            notificationManager.notify(1, notification.build());
        }
    }
}
