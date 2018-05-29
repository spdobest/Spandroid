/*
 * Copyright © 2016, Craftsvilla.com
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import spandroid.dev.R;
import spandroid.dev.common.NetworkUtil;


/**
 * Created by Mahesh Nayak on 19-01-2016.
 */
public abstract class RecyclerviewFragment extends BaseFragment implements SwipeRefreshLayout.OnRefreshListener,
        View.OnClickListener {

    protected final int START_INDEX = 0;
    protected final int FOOTER_COUNT = 1;
    protected RecyclerView mRecyclerView;
    protected TextView mEmptyView;
    protected boolean mLoading = false;
    protected long mTotalItemCount;
    protected int mPageNum = 1, mTotalPages;


    /**
     * The {@link SwipeRefreshLayout} that detects
     * swipe gestures and triggers callbacks in the app.
     */
    protected SwipeRefreshLayout mSwipeRefreshLayout;
    private FloatingActionButton mFloatBtn;

    public abstract RecyclerView.LayoutManager getLayoutManager();

    public abstract boolean isSwipeToRefresh();

    public abstract boolean isFloatBtnVisible();


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setLayout(R.layout.fragment_recyclerview);
        return super.onCreateView(inflater, container, savedInstanceState);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mEmptyView = view.findViewById(R.id.empty_view);
        mRecyclerView = view.findViewById(R.id.recycler_view);
        mSwipeRefreshLayout = view.findViewById(R.id.swiperefresh);
        mFloatBtn = view.findViewById(R.id.float_filter);
        mFloatBtn.setOnClickListener(this);
        mSwipeRefreshLayout.setOnRefreshListener(this);
        mSwipeRefreshLayout.setColorSchemeResources(R.color.orange, R.color.blue, R.color.green, R.color.orange);
        mRecyclerView.setLayoutManager(getLayoutManager());
        enableSwipeToRefresh(isSwipeToRefresh());
        if (isFloatBtnVisible())
            mFloatBtn.setVisibility(View.VISIBLE);
        else
            mFloatBtn.setVisibility(View.GONE);
    }

    @Override
    public void setEmptyView(TextView textView, String emptyText) {
        if (mRecyclerView.getAdapter() != null && mRecyclerView.getAdapter().getItemCount() == 0) {
            textView.setText(emptyText);
            textView.setVisibility(View.VISIBLE);
        }

    }

    protected void hideFilterButton() {
        mFloatBtn.setVisibility(View.GONE);
    }

    private int getFistVisibleItemPosition() {
        RecyclerView.LayoutManager manager = mRecyclerView.getLayoutManager();
        int firstVisibleItemPos;
        if (manager instanceof GridLayoutManager)
            firstVisibleItemPos = ((GridLayoutManager) manager).findFirstVisibleItemPosition();
        else
            firstVisibleItemPos = ((LinearLayoutManager) manager).findFirstVisibleItemPosition();
        return firstVisibleItemPos;
    }

    protected boolean canLoadMore() { //int availableItems, long totalItemCount
        handleSwipeToRefresh();
        if (!NetworkUtil.isAvailable(getActivity())) {
            return false;
        }
        boolean lastItem = getFistVisibleItemPosition() + mRecyclerView.getChildCount() == mRecyclerView.getLayoutManager()
                .getItemCount();
        boolean moreRows = mPageNum < mTotalPages;
        return moreRows && lastItem && !mLoading;
    }

    private void handleSwipeToRefresh() {
        boolean enable = false;
        if (mRecyclerView != null && mRecyclerView.getChildCount() > 0) {
            // check if the first item of the list is visible
            boolean firstItemVisible = getFistVisibleItemPosition() == 0;
            // check if the top of the first item is visible
            boolean topOfFirstItemVisible = mRecyclerView.getChildAt(0).getTop() == 0;
            // enabling or disabling the refresh layout
            enable = firstItemVisible && topOfFirstItemVisible;
        }
        enableSwipeToRefresh(enable);
    }


    @Override
    public void onRefresh() {
        setRefreshing(true);
    }


    private void enableSwipeToRefresh(boolean status) {
        if (!isSwipeToRefresh()) {
            mSwipeRefreshLayout.setEnabled(false);
            return;
        }
        mSwipeRefreshLayout.setEnabled(status);

    }

    protected boolean isRefreshing() {
        return mSwipeRefreshLayout.isRefreshing();
    }

    protected void setRefreshing(boolean status) {
        mSwipeRefreshLayout.setRefreshing(status);
    }

    @Override
    public void onClick(View v) {
        //Default implementation.
    }

    @Override
    public void onDetach() {
        super.onDetach();
//        if (mRecyclerView.getAdapter() != null)
//            ((RecyclerViewAdapter) mRecyclerView.getAdapter()).onDestroy();
    }
}
