package spandroid.dev.notification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spandroid.dev.R
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import android.view.View

import kotlinx.android.synthetic.main.activity_notification.*



class NotificationActivity : AppCompatActivity(),View.OnClickListener {


    private val notificationUtils:NotificationUtil = NotificationUtil()

    override fun onClick(view: View?) {
         when(view?.id){

             R.id.button_standard_notification ->{
                 notificationUtils.showStandardHeadsUpNotification(this)
             }

             R.id.button_bundled_notification ->{
                 notificationUtils.showBundledNotifications(this)
             }

             R.id.button_remote_input_notification ->{
                 notificationUtils.showRemoteInputNotification(this)
             }

             R.id.button_custom_content_view_notification ->{
                 notificationUtils.showCustomContentViewNotification(this)
             }

             R.id.button_custom_content_big_view_notification ->{
                 notificationUtils.showCustomBigContentViewNotification(this)
             }

             R.id.button_custom_media_content_view_notification ->{
                 notificationUtils.showCustomMediaViewNotification(this)
             }

             R.id.button_custom_normal_and_big_content_views_notification ->{
                 notificationUtils.showCustomBigContentViewNotification(this)
             }

         }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_notification)

        button_standard_notification.setOnClickListener(this)
        button_bundled_notification.setOnClickListener(this)
        button_remote_input_notification.setOnClickListener(this)
        button_custom_content_view_notification.setOnClickListener(this)
        button_custom_content_big_view_notification.setOnClickListener(this)
        button_custom_media_content_view_notification.setOnClickListener(this)
        button_custom_normal_and_big_content_views_notification.setOnClickListener(this)


    }

    private fun createNotificationChannel() {
        // Create the NotificationChannel, but only on API 26+ because
        // the NotificationChannel class is new and not in the support library
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val name = "Channel"//getString(R.string.channel_name)
            val description = "Desc"//getString(R.string.channel_description)
            val importance = NotificationManager.IMPORTANCE_DEFAULT
            val CHANNEL_ID = "ChannelId"
            val channel = NotificationChannel(CHANNEL_ID, name, importance)
            channel.description = description
            // Register the channel with the system; you can't change the importance
            // or other notification behaviors after this
            val notificationManager = getSystemService<NotificationManager>(NotificationManager::class.java!!)
            notificationManager!!.createNotificationChannel(channel)
        }
        else{

        }
    }

}
