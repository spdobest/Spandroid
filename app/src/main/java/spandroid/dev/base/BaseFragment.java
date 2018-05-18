/*
 * Copyright © 2016, Craftsvilla.com
 * Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.base;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import spandroid.dev.R;

/**
 * Created by Mahesh Nayak on 15-01-2016.
 * All the common implementations of the fragments are implemented here.
 */
public abstract class BaseFragment extends Fragment {
    private ProgressBar mProgressBar;
    private int mLayoutId;
    protected String mRequestTag;

    public interface MenuClickListener {

        void onCartClick(String analyticsSource);

        void onAccountClick();

        void onLogoutClick();

        void onMenuWishListClick();

        void onOrdersClick();

        void onHomeClick();
    }

    public interface CategoryClickListener {
        void onCategoryClicked(String item);
    }

    public interface ToolbarListener {
        void setToolbarTitle(String title);

        void setToolbarVisibility(int value);

        void setToolbar();
    }

    public interface LoginSuccessListener {
        void onLoginSuccess();

        void onLogoutSuccess();
    }

    protected ToolbarListener mToolbarListener;
    protected MenuClickListener mMenuClickListener;
    protected LoginSuccessListener mLoginListener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mMenuClickListener = (MenuClickListener) context;
            mToolbarListener = (ToolbarListener) context;
            mLoginListener = (LoginSuccessListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(((Activity) context).getLocalClassName()
                    + " must implement MenuClickListener, ToolbarListener, LoginSuccessListener");
        }
    }


    protected void setEmptyView(TextView view) {
        view.setVisibility(View.VISIBLE);
        view.setText("data_not_available");
    }

    protected void setEmptyView(TextView view, String message) {
        view.setText(message);
    }

    protected void hideProgressBar() {
        if (mProgressBar != null)
            mProgressBar.setVisibility(View.GONE);
    }

    protected void showProgressBar() {
        if (mProgressBar != null)
            mProgressBar.setVisibility(View.VISIBLE);
    }

    protected void showToast(Activity activity, String msg) {
        Toast.makeText(activity, msg, Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_search:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_base, container, false);
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        FrameLayout fragmentLayoutContainer = (FrameLayout) view.findViewById(R.id.fragment_layout_container);
        inflater.inflate(mLayoutId, fragmentLayoutContainer);
        return view;
    }

    protected void setLayout(int layoutId) {
        mLayoutId = layoutId;
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mMenuClickListener = null;
        mToolbarListener = null;
        mLoginListener = null;
    }
}
