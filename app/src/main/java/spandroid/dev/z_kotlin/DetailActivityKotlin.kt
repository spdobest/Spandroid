package spandroid.dev.z_kotlin

import android.net.Uri
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_kotlin_details.*
import spandroid.dev.R
import spandroid.dev.kotlin.KotlinFragment1

class DetailActivityKotlin : AppCompatActivity(), View.OnClickListener, KotlinFragment1.OnFragmentInteractionListener {
    override fun onFragmentInteraction(uri: Uri) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    var count: Int = 0

    override fun onClick(view: View?) {

        when (view?.id) {
            R.id.btnToast -> {
                Toast.makeText(this, "Hello", Toast.LENGTH_LONG).show()
            }
            R.id.btnCount -> {
                tvTitle.text = "${++count}"
            }
            R.id.btnSnackbar -> {
                Snackbar.make(rootConstraint, "SnackBar", Snackbar.LENGTH_LONG)
            }
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_kotlin_details)

        btnToast.setOnClickListener(this)
        btnSnackbar.setOnClickListener(this)
        btnCount.setOnClickListener(this)

        var ft = supportFragmentManager.beginTransaction()
        ft.add(R.id.rootConstraint, KotlinFragment1.newInstance("Spm", "asdads"), "tag").commit()

    }
}
