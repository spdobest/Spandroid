package spandroid.dev.kotlin.base

/**
 * Created by root on 3/23/18.
 */
interface BaseInterface {

    /**
     * This interface is emplemented by both the BaseFragment and BaseActivity
     */

    fun showProgress(loadingMessage: String = "Loading")

    fun showError(errorMessage: String = "Error")

    fun hideProgress()
}