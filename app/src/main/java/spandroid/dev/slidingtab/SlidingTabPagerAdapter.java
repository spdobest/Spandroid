package spandroid.dev.slidingtab;

import android.app.Activity;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import spandroid.dev.R;

public class SlidingTabPagerAdapter extends PagerAdapter {
    String tabs[] = {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5", "Test 6", "Test 7", "Test 8", "Test 1", "Test 2", "Test 3", "Test 4", "Test 5", "Test 6", "Test 7", "Test 8"};
    Activity activity;

    public SlidingTabPagerAdapter(Activity activity) {
        this.activity = activity;
    }

    @Override
    public int getCount() {
        return tabs.length;
    }

    @Override
    public boolean isViewFromObject(View view, Object o) {
        return o == view;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return tabs[position];
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        // Inflate a new layout from our resources
        View view = null;
        if (position % 2 == 0) {
            view = activity.getLayoutInflater().inflate(R.layout.sliding_tab_pager_item, container, false);
        } else {
            view = activity.getLayoutInflater().inflate(R.layout.sliding_tab_pager_item2, container, false);
        }
        // Add the newly created View to the ViewPager
        container.addView(view);

        // Retrieve a TextView from the inflated View, and update it's text
        TextView title = view.findViewById(R.id.item_title);
        title.setText(tabs[position]);

        // Return the View
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

}
