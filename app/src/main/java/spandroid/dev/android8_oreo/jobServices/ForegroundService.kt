package spandroid.dev.android8_oreo.jobServices

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.Service
import android.content.Context
import android.content.Intent
import android.graphics.Color
import android.os.IBinder
import android.support.v4.app.NotificationManagerCompat

public class ForegroundService : Service() {

    val CHANNEL_ONE_ID = "com.jessicathornsby.myapplication.ONE"
    val CHANNEL_ONE_NAME = "Channel One"
    val CHANNEL_TWO_ID = "com.jessicathornsby.myapplication.TWO"
    val CHANNEL_TWO_NAME = "Channel Two"
    private lateinit var notifManager: NotificationManager
    override fun onBind(p0: Intent?): IBinder {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }


    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        buildNotification()
        return super.onStartCommand(intent, flags, startId)
    }

    private fun buildNotification() {

            val notificationChannel = NotificationChannel(CHANNEL_ONE_ID,
                    CHANNEL_ONE_NAME, NotificationManagerCompat.IMPORTANCE_HIGH)
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.setShowBadge(true)
            notificationChannel.lockscreenVisibility = Notification.VISIBILITY_PUBLIC
            getManager().createNotificationChannel(notificationChannel)
    }

    private fun getManager(): NotificationManager {
        if (notifManager == null) {
            notifManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        }
        return notifManager
    }

}