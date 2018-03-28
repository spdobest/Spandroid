package spandroid.dev.animation

import android.animation.Animator
import android.app.Dialog
import android.content.Context
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment

import spandroid.dev.R
import android.graphics.drawable.ColorDrawable
import android.view.KeyEvent.KEYCODE_BACK
import android.content.DialogInterface
import android.view.*
import android.view.Window.FEATURE_NO_TITLE
import android.widget.ImageView
import android.animation.AnimatorListenerAdapter
import android.view.ViewAnimationUtils.createCircularReveal
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import kotlinx.android.synthetic.main.fragment_circle_revel_fragment2.*
import spandroid.dev.R.id.fab
import android.view.ViewAnimationUtils.createCircularReveal
import spandroid.dev.R.id.fab
import android.support.v4.content.res.ResourcesCompat
import android.content.res.ColorStateList
import android.support.v4.view.ViewCompat.setBackgroundTintList
import android.opengl.ETC1.getHeight
import android.opengl.ETC1.getWidth
import android.support.design.widget.FloatingActionButton


class CircleRevelFragment2 : Fragment() {


    private var isOpen = false
    lateinit var fab: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        var view:View = inflater.inflate(R.layout.fragment_circle_revel_fragment2, container, false)
        fab = view.findViewById(R.id.fab)
        fab.setOnClickListener(View.OnClickListener { viewMenu() })


        return view
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        /*if (context is OnFragmentInteractionListener) {
            mListener = context
        } else {
            throw RuntimeException(context!!.toString() + " must implement OnFragmentInteractionListener")
        }*/
    }


    companion object {

        fun newInstance( ): CircleRevelFragment2 {
            val fragment = CircleRevelFragment2()
//            val args = Bundle()
//            fragment.arguments = args
            return fragment
        }
    }


    private fun viewMenu() {

        if (!isOpen) {

            val x = layoutContent.getRight()
            val y = layoutContent.getBottom()

            val startRadius:Float = 0.0f
            val endRadius = Math.hypot(layoutMain.getWidth().toDouble(), layoutMain.getHeight().toDouble()).toFloat()

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(resources, android.R.color.white, null)))
            fab.setImageResource(R.drawable.ic_ab_close)

            val anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRadius, endRadius)

            layoutButtons.setVisibility(View.VISIBLE)
            anim.start()

            isOpen = true

        } else {

            val x = layoutButtons.getRight()
            val y = layoutButtons.getBottom()

            val startRadius = Math.max(layoutContent.getWidth(), layoutContent.getHeight()).toFloat()
            val endRadius:Float = 0.0f

            fab.setBackgroundTintList(ColorStateList.valueOf(ResourcesCompat.getColor(resources, R.color.colorAccent, null)))
            fab.setImageResource(R.drawable.ic_add_white_24dp)

            val anim = ViewAnimationUtils.createCircularReveal(layoutButtons, x, y, startRadius, endRadius)
            anim.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animator: Animator) {

                }

                override fun onAnimationEnd(animator: Animator) {
                    layoutButtons.setVisibility(View.GONE)
                }

                override fun onAnimationCancel(animator: Animator) {

                }

                override fun onAnimationRepeat(animator: Animator) {

                }
            })
            anim.start()

            isOpen = false
        }
    }
}
