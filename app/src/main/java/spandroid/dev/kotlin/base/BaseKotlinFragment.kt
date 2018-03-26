package spandroid.dev.kotlin.base

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_base_kotlin.*
import spandroid.dev.R

/**
 * This is the base fragment where all the fragments are extends this class
 * all the ready-made code are available here
 *
 */
abstract class BaseKotlinFragment : Fragment() {

    var mLayoutId: Int = -1

    companion object {
        val TAG = "BaseKotlinFragment"
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


        var fragmentView = inflater.inflate(R.layout.fragment_base_kotlin, container, false)

        initializeResources()
        setListeners()

        inflater.inflate(mLayoutId, frameLayoutRootBaseKotlin)


        return fragmentView
    }


    /**
     * remove the callback from here
     */

    override fun onDetach() {
        super.onDetach()
    }


    protected fun setLayout(layoutId: Int) {
        mLayoutId = layoutId
    }


    protected abstract fun setLayoutFileName(layoutId: Int)

    protected abstract fun initializeResources()

    protected abstract fun setListeners()

    protected abstract fun getToolBarTitle(): Int

    /**
     * ************************* END OF OVERRIDED METHODS OF FRAGMENT  ****************************
     */

    /**
     *loadingMessage is Option, u can pass message or not
     */
    fun showProgress(loadingMessage: String = "Loading") {
        tvMessageBaseFragment?.visibility = View.VISIBLE
        progressBaseFragment?.visibility = View.VISIBLE
        tvMessageBaseFragment?.text = loadingMessage
    }

    fun showError(errorMessage: String = "Error") {
        tvMessageBaseFragment?.visibility = View.VISIBLE
        tvMessageBaseFragment?.text = errorMessage
    }

    fun hideProgress() {
        tvMessageBaseFragment?.visibility = View.GONE
        progressBaseFragment?.visibility = View.GONE
    }

}
