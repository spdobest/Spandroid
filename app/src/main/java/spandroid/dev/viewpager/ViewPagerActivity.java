package spandroid.dev.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import spandroid.dev.R;
import spandroid.dev.viewpager.adapter.ParentPagerAdapter;
import spandroid.dev.viewpager.model.ChildModel;
import spandroid.dev.viewpager.model.ParentData;

/**
 * Created by sibaprasad on 28/10/17.
 */

public class ViewPagerActivity extends AppCompatActivity implements View.OnClickListener, ParentPagerAdapter.OnPageRefreshListener {

    ParentPagerAdapter parentPagerAdapter;

    @BindView(R.id.toolbar)
    Toolbar toolbar;
    /*@BindView(R.id.tabs)*/
    TabLayout tabLayoutParent;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    /*@BindView(R.id.viewpagerTabActivity)*/
    ViewPager viewpagerTab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;
    AppCompatTextView tvFilter;

    boolean isFilterAPplied;


    List<ParentData> mParentDataList = new ArrayList<>();

    List<Fragment> pagerFragmentList = new ArrayList<>();
    List<String> listTabTitle = new ArrayList<>();

    String[] arr = {"Hello", "hey", "shut off", "I will kill you", "GO to hell", "Idiot", "THank you", "Sorry"};
    String[] arr1 = {"Siba", "Satya", "Prasad", "narayan", "mohanty", "Idiot", "sp infotech", "spm - the bad Boy"};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);


        tvFilter = findViewById(R.id.tvFilter);
        tvFilter.setOnClickListener(this);

        viewpagerTab = findViewById(R.id.viewpagerTabActivity);
        tabLayoutParent = findViewById(R.id.tabLayoutParent);
        if (viewpagerTab != null) {
            setupViewPager(viewpagerTab);
            tabLayoutParent.setupWithViewPager(viewpagerTab);
        }
    }


    private void setupViewPager(ViewPager viewPager) {

        mParentDataList.addAll(getRandomParent("TAB"));

        pagerFragmentList.clear();
        listTabTitle.clear();

        parentPagerAdapter = new ParentPagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(parentPagerAdapter);
        for (int i = 0; i < mParentDataList.size(); i++) {
            ParentData parentData = mParentDataList.get(i);
            pagerFragmentList.add(CommonFragmentPager.newInstance(parentData, i, isFilterAPplied));
            listTabTitle.add(parentData.getTitle());
            //  parentPagerAdapter.addFragment(CommonFragmentPager.newInstance(parentData,i), parentData.getTitle());
        }
        parentPagerAdapter.setParentPagerData(pagerFragmentList, listTabTitle);
    }


    private List<ParentData> getRandomParent(String parentTab) {

        List<ParentData> parentDataList = new ArrayList<>();

        for (int k = 0; k < 5; k++) {

            ParentData parentData = new ParentData();
            List<String> mListChildList = new ArrayList<>();
            List<ChildModel> listChild = new ArrayList<>();

            String tabItem = "Tab " + k;

            parentData.setTitle(tabItem);

            for (int i = 0; i < 5; i++) {
                mListChildList.clear();

                String tabName = "Default";

                switch (i) {
                    case 0:
                        tabName = "SP";
                        break;
                    case 1:
                        tabName = "Siba";
                        break;
                    case 2:
                        tabName = "Prasad";
                        break;
                    case 3:
                        tabName = "Mohanty";
                        break;
                    case 4:
                        tabName = "abcd";
                        break;
                }

                String name = randomString();

                for (int j = 0; j < randInt(); j++) {
                    mListChildList.add(tabItem + " - Child " + name);
                }
                ChildModel childModel = new ChildModel();
                childModel.setTabTitle(tabItem + " - Child " + i);
                childModel.setChildListData(mListChildList);

                listChild.add(childModel);
            }

            parentData.setmListChild(listChild);
            parentDataList.add(parentData);
        }

        return parentDataList;
    }

    private int randInt() {

        // Usually this can be a field rather than a method variable
        Random rand = new Random();

        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = rand.nextInt((10 - 2) + 1) + 2;

        return randomNum;
    }

    private String randomString() {
        // Usually this can be a field rather than a method variable
        Random rand = new Random();
        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive

        int randomNum = rand.nextInt((arr.length - 2 - 1) + 1) + 1;

        String ret = "";
        if (isFilterAPplied) {
            ret = arr[randomNum];
        } else {
            ret = arr1[randomNum];
        }
        return ret;
    }

    public List<ParentData> getMainParentData() {
        return this.mParentDataList;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvFilter:
//                viewpagerTab.notifyAll();

                mParentDataList.clear();


                if (isFilterAPplied) {
                    isFilterAPplied = false;
                    tvFilter.setText("To Lower case");
                } else {
                    isFilterAPplied = true;
                    tvFilter.setText("To Upper case");
                }

                setupViewPager(viewpagerTab);

                /*mParentDataList.addAll(getRandomParent("TAB"));
                pagerFragmentList.clear();
                listTabTitle.clear();
                for (int i = 0;i<mParentDataList.size();i++) {
                    ParentData parentData = mParentDataList.get(i);
                    pagerFragmentList.add(CommonFragmentPager.newInstance(parentData,i,isFilterAPplied) );
                    listTabTitle.add(parentData.getTitle());
                    //  parentPagerAdapter.addFragment(CommonFragmentPager.newInstance(parentData,i), parentData.getTitle());
                }
                parentPagerAdapter.setParentPagerData(pagerFragmentList,listTabTitle);
*/
                break;
        }
    }

    @Override
    public void onPageRefresh() {

    }
}
