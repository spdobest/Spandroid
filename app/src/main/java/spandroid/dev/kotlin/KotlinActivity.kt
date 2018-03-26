package spandroid.dev.kotlin

import android.os.Bundle
import android.os.Handler
import android.support.v7.app.AppCompatActivity
import spandroid.dev.R

class KotlinActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_main)

        Handler().postDelayed(Runnable {

        }, 1000)

    }
}
