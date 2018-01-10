package spandroid.dev.slidingtab;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spandroid.dev.R;

public class SlidingFragment extends Fragment {

    private SlidingTabLayout mSlidingTabLayout;

    private ViewPager mViewPager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.sliding_tab_fragment_layout, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        setUpPager(view);
        setUpTabColor();
    }

    void setUpPager(View view) {
        mViewPager = view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new SlidingTabPagerAdapter(getActivity()));
        mSlidingTabLayout = view.findViewById(R.id.sliding_tabs);
        mSlidingTabLayout.setViewPager(mViewPager);
    }

    void setUpTabColor() {
        mSlidingTabLayout.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                // TODO Auto-generated method stub
                return SlidingFragment.this.getResources().getColor(R.color.colorRed);
            }

            @Override
            public int getDividerColor(int position) {
                // TODO Auto-generated method stub
                return SlidingFragment.this.getResources().getColor(R.color.colorRed);
            }
        });
    }

}
