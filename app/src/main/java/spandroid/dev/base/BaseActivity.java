package spandroid.dev.base;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.FrameLayout;

import spandroid.dev.R;


public abstract class BaseActivity extends AppCompatActivity implements BaseFragment.MenuClickListener,
        BaseFragment.ToolbarListener,
        BaseFragment.LoginSuccessListener {
    protected Toolbar mToolBar;
    protected DrawerLayout mDrawerLayout;
    protected ExpandableListView mNavigationListView;
    protected DialogFragment fragment;
    private FrameLayout mLayoutContainer;
    private ActionBarDrawerToggle mDrawerToggle;
    private View mNavigationHeaderView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_base);

        mLayoutContainer = findViewById(R.id.layout_container);
        mToolBar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        setSupportActionBar(mToolBar);

    }

    protected void setHomeUpIndicator() {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mToolBar.setTitleTextColor(ContextCompat.getColor(this, android.R.color.white));
        if (getSupportActionBar() != null)
            getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void setHomeUpIndicator(int colorId) {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mToolBar.setTitleTextColor(ContextCompat.getColor(this, colorId));
        if (getSupportActionBar() != null)
            getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    protected void setHomeUpButtonColor(int colorId) {
        //  final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
//        if (getSupportActionBar() != null)
//            getSupportActionBar().setHomeAsUpIndicator(ImageUtil.changeTintColor(this, upArrow, colorId));
    }

    protected void setLayout(int layoutId) {
        getLayoutInflater().inflate(layoutId, mLayoutContainer);
    }

    protected void initDrawer() {
        // mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);
        initDrawerToggle();
    }

    protected void lockDrawer() {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
    }

    private void initDrawerToggle() {
        mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolBar, R.string.app_name,
                R.string.abc_action_bar_home_description) {

            /** Called when a drawer has settled in a completely closed state. */
            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
            }

            /** Called when a drawer has settled in a completely open state. */
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        mDrawerLayout.addDrawerListener(mDrawerToggle);
        if (getSupportActionBar() != null)
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        mDrawerToggle.syncState();

    }


    @Override
    public void onCartClick(String analyticsSource) {

    }

    @Override
    public void onMenuWishListClick() {
        //Default implementation.
    }

    @Override
    public void onAccountClick() {
//Default implementation
    }

    protected void showMenuButton() {
        mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED);
        initDrawerToggle();
    }

    protected void showBackButton() {
       /* mDrawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED);
        mDrawerToggle.setDrawerIndicatorEnabled(false);
        final Drawable upArrow = ContextCompat.getDrawable(this, R.drawable.abc_ic_ab_back_mtrl_am_alpha);
        mDrawerToggle.setHomeAsUpIndicator(ImageUtil.changeTintColor(this, upArrow, android.R.color.black));
        setSupportActionBar(mToolBar);*/
    }


    protected void hideToolBar() {
        mToolBar.setVisibility(View.GONE);
    }

    @Override
    public void setToolbarTitle(String title) {
        if (getSupportActionBar() != null)
            getSupportActionBar().setTitle(title);
    }

    @Override
    public void setToolbarVisibility(int value) {
        mToolBar.setVisibility(value);
    }

    @Override
    public void setToolbar() {
        setHomeUpButtonColor(android.R.color.black);
        setSupportActionBar(mToolBar);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void onLoginSuccess() {
        //Dummy implementation
    }

    @Override
    public void onLogoutSuccess() {
        //Dummy Implementation.
    }

    @Override
    public void onLogoutClick() {
        //Default method.
    }

    @Override
    public void onHomeClick() {

    }

    @Override
    public void onOrdersClick() {

    }
}
