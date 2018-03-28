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
import android.support.design.widget.FloatingActionButton
import kotlinx.android.synthetic.main.fragment_circular_reavel_animation.*
import spandroid.dev.R.id.fab


class CircularReavelAnimationFragment : Fragment() {


    lateinit var fabCircle: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment

        var view: View = inflater.inflate(R.layout.fragment_circular_reavel_animation, container, false)

        fabCircle = view.findViewById(R.id.fabCircle)

        fabCircle.setOnClickListener(View.OnClickListener { showDiag() })


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

        fun newInstance(): CircularReavelAnimationFragment {
            val fragment = CircularReavelAnimationFragment()
//            val args = Bundle()
//            fragment.arguments = args
            return fragment
        }
    }


    private fun showDiag() {

        val dialogView = View.inflate(activity, R.layout.dialog_anim, null)

        val dialog = Dialog(activity, R.style.MyAlertDialogStyle)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setContentView(dialogView)

        val imageView: ImageView = dialog.findViewById(R.id.closeDialogImg)
        imageView.setOnClickListener(View.OnClickListener { revealShow(dialogView, false, dialog) })

        dialog.setOnShowListener(DialogInterface.OnShowListener { revealShow(dialogView, true, dialog) })

        dialog.setOnKeyListener(object : DialogInterface.OnKeyListener {
            override fun onKey(dialogInterface: DialogInterface, i: Int, keyEvent: KeyEvent): Boolean {
                if (i == KeyEvent.KEYCODE_BACK) {

                    revealShow(dialogView, false, dialog)
                    return true
                }

                return false
            }
        })



        dialog.getWindow().setBackgroundDrawable(ColorDrawable(android.graphics.Color.TRANSPARENT))

        dialog.show()
    }

    private fun revealShow(dialogView: View, b: Boolean, dialog: Dialog) {

        val view: View = dialogView.findViewById(R.id.dialog)

        val w = view.getWidth()
        val h = view.getHeight()

        val endRadius = Math.hypot(w.toDouble(), h.toDouble()).toFloat()

        val cx = (fabCircle.getX() + fabCircle.getWidth() / 2).toInt()
        val cy = fabCircle.getY().toInt() + fabCircle.getHeight() + 56


        if (b) {
            val revealAnimator = ViewAnimationUtils.createCircularReveal(view, cx, cy, 0.0f, endRadius)

            view.setVisibility(View.VISIBLE)
            revealAnimator.duration = 700
            revealAnimator.start()

        } else {

            val anim = ViewAnimationUtils.createCircularReveal(view, cx, cy, endRadius, 0.0f)

            anim.addListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator) {
                    super.onAnimationEnd(animation)
                    dialog.dismiss()
                    view.setVisibility(View.INVISIBLE)

                }
            })
            anim.duration = 700
            anim.start()
        }

    }
}
