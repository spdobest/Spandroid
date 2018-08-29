package spandroid.dev.firebase

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.content.LocalBroadcastManager
import android.util.Log
import spandroid.dev.R
import com.google.firebase.iid.InstanceIdResult
import com.google.android.gms.tasks.OnSuccessListener
import com.google.firebase.iid.FirebaseInstanceId
import spandroid.dev.firebase.pushNotification.Config
import spandroid.dev.firebase.pushNotification.FCMActivity


class FirebaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firebase)

        var title:String = ""
        var message:String = ""
        val intent:Intent = intent
        if(intent.hasExtra("title")){
            title = intent.getStringExtra("title")
        }
        if(intent.hasExtra("message")){
            message = intent.getStringExtra("message")
        }

        val intentFcm = Intent(this, FCMActivity::class.java)
        intentFcm.putExtra("title", title)
        intentFcm.putExtra("body", message)

        print("message "+message+"   "+title)


    }
}
