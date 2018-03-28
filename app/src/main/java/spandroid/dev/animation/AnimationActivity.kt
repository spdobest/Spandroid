package spandroid.dev.animation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_animation.*

import spandroid.dev.R

class AnimationActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_animation)

        supportFragmentManager
                .beginTransaction()
                .add(R.id.fragmentContainerAnimation, CircleRevelFragment2.newInstance(), "rageComicList")
                .commit()

    }
}
