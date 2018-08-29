package spandroid.dev.android8_oreo.nitification

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import spandroid.dev.R
import kotlinx.android.synthetic.main.activity_oreo_notification.*


class OreoNotificationActivity : AppCompatActivity() {
// https://www.androidauthority.com/android-8-0-oreo-app-implementing-notification-channels-801097/
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_oreo_notification)
    }



}
