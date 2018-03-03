package spandroid.dev.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import spandroid.dev.R

class KotlinActivity : AppCompatActivity() {

    var name = "Sibaprasad mohanty"

    var byteRange: Byte = 0

    val number1 = 12.5
    val number2 = 3.5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin)


        println(name)

    }
}
