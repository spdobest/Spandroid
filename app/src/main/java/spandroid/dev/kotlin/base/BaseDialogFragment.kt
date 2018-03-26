package spandroid.dev.kotlin.base

import android.app.Dialog
import android.app.DialogFragment
import android.content.Context
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import spandroid.dev.R

/**
 * Created by root on 3/23/18.
 */
class BaseDialogFragment : DialogFragment() {

    companion object {
        val TAG = "BaseDialogFragment"
    }

    /**
     * ************************* START OF OVERRIDED METHODS OF FRAGMENT  ****************************
     */

    /**
     * OnATtach() of Base Fragment
     * Initialize all the interfaces here
     */
    override fun onAttach(context: Context?) {
        super.onAttach(context)

    }

    /**
     * OnCreate Of Base Fragment
     *
     * The onCreate() method in a Fragment is called after the Activity's onAttachFragment()
     * but before that Fragment's onCreateView().
     * In this method, you can assign variables, get Intent extras,
     * and anything else that doesn't involve the View hierarchy (i.e. non-graphical initialisations).
     * This is because this method can be called when the Activity's onCreate() is not finished,
     * and so trying to access the View hierarchy here may result in a crash.
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    /**
     * OnCreateView of Base Fragment
     * the method you initialize and create all your objects,
     * including your TextView), so it's not a matter of performance.
     *
     * After the onCreate() is called (in the Fragment), the Fragment's onCreateView() is called.
     * You can assign your View variables and do any graphical initialisations.
     * You are expected to return a  View from this method, and this is the main UI view,
     * but if your Fragment does not use any layouts or graphics,
     * you can return null (happens by default if you don't override).
     */
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_base_kotlin, container, false)
    }

    override fun onStart() {
        super.onStart()
        val dialog = dialog
        if (dialog != null) {
//            dialog.window!!.setWindowAnimations(
//                    R.style.styleDialogFragment)
            dialog.window!!.setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
            dialog.window!!.setBackgroundDrawable(ColorDrawable(Color.WHITE))
        }
    }


    /**
     * remove the callback from here
     */

    override fun onDetach() {
        super.onDetach()
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = super.onCreateDialog(savedInstanceState)
        dialog.window!!.requestFeature(Window.FEATURE_NO_TITLE)
        return dialog
    }


    /**
     * ************************* END OF OVERRIDED METHODS OF FRAGMENT  ****************************
     */

}