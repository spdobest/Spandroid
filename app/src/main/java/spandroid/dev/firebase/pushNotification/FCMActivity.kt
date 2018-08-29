package spandroid.dev.firebase.pushNotification

import android.content.Intent
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.google.android.gms.tasks.OnSuccessListener

import com.google.firebase.iid.FirebaseInstanceId
import com.google.firebase.iid.InstanceIdResult

import kotlinx.android.synthetic.main.activity_fcm.*

import spandroid.dev.R

class FCMActivity : AppCompatActivity() {

    // https://stackoverflow.com/questions/37711082/how-to-handle-notification-when-app-in-background-in-firebase
    // https://stackoverflow.com/questions/37711082/how-to-handle-notification-when-app-in-background-in-firebase/42279260#42279260


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fcm)


        var title:String = ""
        var message:String = ""
        val intent:Intent = intent
        if(intent.hasExtra("title")){
            title = intent.getStringExtra("title")
        }
        if(intent.hasExtra("message")){
            message = intent.getStringExtra("message")
        }

        textViewNotificationMessage.setText(message)
        textViewNotificationTitle.setText(title)

        FirebaseInstanceId.getInstance().instanceId.addOnSuccessListener(this, OnSuccessListener<InstanceIdResult> { instanceIdResult ->
                val newToken = instanceIdResult.token
                Log.e("newToken", newToken)


                // Saving reg id to shared preferences
                storeRegIdInPref(newToken)

                // sending reg id to your server
                sendRegistrationToServer(newToken)

                // Notify UI that registration has completed, so the progress indicator can be hidden.
                val registrationComplete = Intent(Config.REGISTRATION_COMPLETE)
                registrationComplete.putExtra("token", newToken)
                LocalBroadcastManager.getInstance(this).sendBroadcast(registrationComplete)

        })

    }

    private fun sendRegistrationToServer(token: String) {
        // sending gcm token to server
        Log.e("TAG", "sendRegistrationToServer: $token")
    }

    private fun storeRegIdInPref(token: String) {
        val pref = applicationContext.getSharedPreferences(Config.SHARED_PREF, 0)
        val editor = pref.edit()
        editor.putString("regId", token)
        editor.commit()
    }
}
