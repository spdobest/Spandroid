package spandroid.dev.viewpager.adapter;

/**
 * Created by root on 1/12/18.
 */

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sibaprasad on 23/12/16.
 */

public class ParentPagerAdapter extends FragmentStatePagerAdapter {
    private static final String TAG = "ParentPagerAdapter";
    OnPageRefreshListener onPageRefreshListener;
    private List<Fragment> mFragments = new ArrayList<>();
    private List<String> mFragmentTitles = new ArrayList<>();

    public ParentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void addFragment(Fragment fragment, String title) {
        mFragments.add(fragment);
        mFragmentTitles.add(title);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mFragmentTitles.get(position);
    }


    public void setParentPagerData(List<Fragment> beeWiseResponse, List<String> listTit) {
        this.mFragments = beeWiseResponse;
        this.mFragmentTitles = listTit;
        notifyDataSetChanged();
    }

    public void setParentPageRefreshListener(OnPageRefreshListener mPageRefreshListener) {
        this.onPageRefreshListener = mPageRefreshListener;
    }

    public interface OnPageRefreshListener {
        void onPageRefresh();
    }

}