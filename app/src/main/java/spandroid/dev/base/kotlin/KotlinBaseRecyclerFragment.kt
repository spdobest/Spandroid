package spandroid.dev.base.kotlin

import android.content.Context
import android.os.Bundle
import spandroid.dev.R
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import kotlinx.android.synthetic.main.fragment_recyclerview.*
import spandroid.dev.common.NetworkUtil

/**
 * Created by Mahesh Nayak on 19-01-2016.
 */
public abstract class RecyclerviewFragment : KotlinBaseFragment(), SwipeRefreshLayout.OnRefreshListener,
        View.OnClickListener {

    var mLoading:Boolean  = false
    var mTotalItemCount:Long = 0
    val START_INDEX:Int = 0
    val FOOTER_COUNT:Int = 1
    var mPageNum:Int = 1
    var mTotalPages:Int = 0

     abstract fun getLayoutManager():RecyclerView.LayoutManager

     abstract fun isSwipeToRefresh():Boolean

     abstract fun isFloatBtnVisible():Boolean


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        setLayout(R.layout.fragment_recyclerview)

        return super.onCreateView(inflater, container, savedInstanceState)
    }


    override fun onViewCreated(view: View, @Nullable savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onActivityCreated(@Nullable savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    fun setEmptyView(text: String) {
       hideProgressBar()
    }

    protected fun hideFilterButton() {
        float_filter.setVisibility(View.GONE)
    }

    private fun getFistVisibleItemPosition() :Int {
        var manager:RecyclerView.LayoutManager  =  recycler_view.getLayoutManager()
        var firstVisibleItemPos:Int = 0

        if (manager is GridLayoutManager) {
            firstVisibleItemPos = manager.findFirstVisibleItemPosition()
        }
        else {
           // firstVisibleItemPos = manager.findFirstVisibleItemPosition()
        }
        return firstVisibleItemPos
    }

    fun canLoadMore():Boolean { //int availableItems, long totalItemCount
        handleSwipeToRefresh();
        if (!NetworkUtil.isAvailable(getActivity())) {
            return false;
        }
        var  lastItem: Boolean = getFistVisibleItemPosition() + recycler_view.getChildCount() == recycler_view.getLayoutManager()
                .getItemCount();
        var moreRows:Boolean = mPageNum < mTotalPages;
        return moreRows && lastItem && !mLoading;
    }

    private fun handleSwipeToRefresh() {
        var enable:Boolean = false
        if (recycler_view != null && recycler_view.getChildCount() > 0) {
            // check if the first item of the list is visible
            var firstItemVisible:Boolean = getFistVisibleItemPosition() == 0;
            // check if the top of the first item is visible
            var topOfFirstItemVisible:Boolean = recycler_view.getChildAt(0).getTop() == 0;
            // enabling or disabling the refresh layout
            enable = firstItemVisible && topOfFirstItemVisible;
        }
        enableSwipeToRefresh(enable);
    }



    override fun onRefresh():Unit {
        setRefreshing(true);
    }


    private fun enableSwipeToRefresh( status:Boolean) {
        if (!isSwipeToRefresh()) {
            swiperefresh.setEnabled(false)
            return
        }
       swiperefresh.setEnabled(status)

    }

     fun isRefreshing():Boolean {
         return swiperefresh.isRefreshing()
    }

    fun setRefreshing( status:Boolean) {
        swiperefresh.setRefreshing(status);
    }


    override fun onClick(v:View) {

    }

    override fun onDetach() {
        super.onDetach()
       /*if (recycler_view.getAdapter() != null)
            ((RecyclerViewAdapter) mRecyclerView.getAdapter()).onDestroy() */
    }
}