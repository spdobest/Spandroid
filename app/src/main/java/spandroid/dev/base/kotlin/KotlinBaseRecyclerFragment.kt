package spandroid.dev.base.kotlin

import android.os.Bundle
import android.support.v4.widget.SwipeRefreshLayout
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.fragment_recyclerview.*
import spandroid.dev.R
import spandroid.dev.common.NetworkUtil

/**
 * Created by Mahesh Nayak on 19-01-2016.
 */
abstract class RecyclerviewFragment : KotlinBaseFragment(), SwipeRefreshLayout.OnRefreshListener,
        View.OnClickListener {

    var mLoading: Boolean = false
    var mTotalItemCount: Long = 0
    val START_INDEX: Int = 0
    val FOOTER_COUNT: Int = 1
    var mPageNum: Int = 1
    var mTotalPages: Int = 0

    abstract fun getLayoutManager(): RecyclerView.LayoutManager

    abstract fun isSwipeToRefresh(): Boolean

    abstract fun isFloatBtnVisible(): Boolean


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        setLayout(R.layout.fragment_recyclerview)

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    fun setEmptyView(text: String) {
        hideProgressBar()
    }

    protected fun hideFilterButton() {
        float_filter.visibility = View.GONE
    }

    private fun getFistVisibleItemPosition(): Int {
        var manager: RecyclerView.LayoutManager = recycler_view.layoutManager
        var firstVisibleItemPos: Int = 0

        if (manager is GridLayoutManager) {
            firstVisibleItemPos = manager.findFirstVisibleItemPosition()
        } else {
            // firstVisibleItemPos = manager.findFirstVisibleItemPosition()
        }
        return firstVisibleItemPos
    }

    fun canLoadMore(): Boolean { //int availableItems, long totalItemCount
        handleSwipeToRefresh()
        if (!NetworkUtil.isAvailable(activity)) {
            return false
        }
        var lastItem: Boolean = getFistVisibleItemPosition() + recycler_view.childCount == recycler_view.layoutManager
                .itemCount
        var moreRows: Boolean = mPageNum < mTotalPages
        return moreRows && lastItem && !mLoading
    }

    private fun handleSwipeToRefresh() {
        var enable: Boolean = false
        if (recycler_view != null && recycler_view.childCount > 0) {
            // check if the first item of the list is visible
            var firstItemVisible: Boolean = getFistVisibleItemPosition() == 0
            // check if the top of the first item is visible
            var topOfFirstItemVisible: Boolean = recycler_view.getChildAt(0).top == 0
            // enabling or disabling the refresh layout
            enable = firstItemVisible && topOfFirstItemVisible
        }
        enableSwipeToRefresh(enable)
    }


    override fun onRefresh(): Unit {
        setRefreshing(true)
    }


    private fun enableSwipeToRefresh(status: Boolean) {
        if (!isSwipeToRefresh()) {
            swiperefresh.isEnabled = false
            return
        }
        swiperefresh.isEnabled = status

    }

    fun isRefreshing(): Boolean {
        return swiperefresh.isRefreshing
    }

    fun setRefreshing(status: Boolean) {
        swiperefresh.isRefreshing = status
    }


    override fun onClick(v: View) {

    }

}