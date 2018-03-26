package spandroid.dev.kotlin.base

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import spandroid.dev.R


abstract class BaseKotlinActivityWithDrawer : AppCompatActivity(), BaseInterface {

    private val mLayoutContainer: FrameLayout? = null

    companion object {
        val TAG = "BaseKotlinActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_base_kotlin)
    }

    /**
     * ************************* END OF OVERRIDED METHODS OF FRAGMENT  ****************************
     */


    protected fun setLayout(layoutId: Int) {
        layoutInflater.inflate(layoutId, mLayoutContainer)
    }


    /**
     *loadingMessage is Option, u can pass message or not
     */
    override fun showProgress(loadingMessage: String) {

    }

    override fun showError(errorMessage: String) {

    }

    override fun hideProgress() {

    }

}
