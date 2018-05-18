package spandroid.dev.base.kotlin

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import kotlinx.android.synthetic.main.fragment_base.*
import spandroid.dev.R
import spandroid.dev.base.BaseFragment

/**
 * Created by root on 5/18/18.
 */
abstract class KotlinBaseFragment :Fragment(){

    var  mToolbarListener: ToolbarListener? = null
    var  mLayoutId:Int = 0



    interface ToolbarListener {
        fun setToolbarTitle(title: String)

        fun setToolbarVisibility(value: Int)

        fun setToolbar()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        try {
            mToolbarListener = context as ToolbarListener?
        } catch (e: ClassCastException) {
            throw ClassCastException((context as Activity).localClassName + " must implement MenuClickListener, ToolbarListener, LoginSuccessListener")
        }
    }

    protected fun setEmptyView(view: TextView) {
        view.visibility = View.VISIBLE
        view.text = "data_not_available"
    }

    protected fun setEmptyView(view: TextView, message: String) {
        view.text = message
    }

    protected fun hideProgressBar() {
        progress_bar?.setVisibility(View.GONE)
    }

    protected fun showProgressBar() {
            progress_bar?.setVisibility(View.VISIBLE)
    }

    protected fun showToast(activity: Activity, msg: String) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show()
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item!!.itemId) {
            R.id.action_search -> {
            }
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_base, container, false)
        val fragmentLayoutContainer = view.findViewById<View>(R.id.fragment_layout_container) as FrameLayout
        inflater.inflate(mLayoutId, fragmentLayoutContainer)
        return view
    }

    protected fun setLayout(layoutId: Int) {
        mLayoutId = layoutId
    }

    override fun onDetach() {
        super.onDetach()
        mToolbarListener = null
    }
}