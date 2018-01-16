package spandroid.dev.viewpager;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import spandroid.dev.R;
import spandroid.dev.viewpager.adapter.ChildPagerAdapter;
import spandroid.dev.viewpager.adapter.MoviesAdapter;
import spandroid.dev.viewpager.model.ChildModel;
import spandroid.dev.viewpager.model.ParentData;

public class CommonFragmentPager extends Fragment implements View.OnClickListener {

    private static final String TAG = "FragmentList";

    MoviesAdapter moviesAdapter;
    List<String> listMovies = new ArrayList<>();
    List<String> listMoviesMail = new ArrayList<>();

    List<Fragment> listChildFragment = new ArrayList<>();
    List<String> listTitle = new ArrayList<>();

    //    ParentPagerAdapter parentPagerAdapter;
    ChildPagerAdapter childPagerAdapter;

    /*@BindView(R.id.tabsChild)*/
    TabLayout tabs;
    @BindView(R.id.appbar)
    AppBarLayout appbar;
    /*@BindView(R.id.viewpagerTab)*/
    ViewPager viewpagerTab;
    @BindView(R.id.main_content)
    CoordinatorLayout mainContent;

    List<ChildModel> childModelList = new ArrayList<>();

    int parentPosition = -1;
    boolean isFilterApplied;

    public CommonFragmentPager() {
        // Required empty public constructor
    }


    public static CommonFragmentPager newInstance(ParentData parentData, int parentPosition, boolean isFilterApplied) {

        Bundle args = new Bundle();
        args.putParcelableArrayList(Constants.BundelKey.CHILD_DATA, (ArrayList<? extends Parcelable>) parentData.getmListChild());
        args.putInt(Constants.BundelKey.PARENT_POTITION, parentPosition);
        args.putBoolean(Constants.BundelKey.ISFILTER_APPLIED, isFilterApplied);
        CommonFragmentPager fragment = new CommonFragmentPager();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(Constants.BundelKey.CHILD_DATA)) {
                childModelList = bundle.getParcelableArrayList(Constants.BundelKey.CHILD_DATA);
            }
            if (bundle.containsKey(Constants.BundelKey.PARENT_POTITION)) {
                parentPosition = bundle.getInt(Constants.BundelKey.PARENT_POTITION);
            }
            if (bundle.containsKey(Constants.BundelKey.ISFILTER_APPLIED)) {
                this.isFilterApplied = bundle.getBoolean(Constants.BundelKey.ISFILTER_APPLIED);
            }

            Log.i(TAG, "onCreate: Parent Fragment " + isFilterApplied);

        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_pager, container, false);
        ButterKnife.bind(this, view);

        initVIew(view);
        return view;
    }

    private void initVIew(View view) {

        viewpagerTab = view.findViewById(R.id.viewpagerTab);
        tabs = view.findViewById(R.id.tabsChild);

        if (viewpagerTab != null) {
            setupViewPager(viewpagerTab);
            tabs.setupWithViewPager(viewpagerTab);
        }
    }

    @Override
    public void onClick(View view) {

    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

    private void setupViewPager(ViewPager viewPager) {
        listChildFragment.clear();
        childPagerAdapter = new ChildPagerAdapter(getChildFragmentManager());

        for (int i = 0; i < childModelList.size(); i++) {
            ChildModel childModel = childModelList.get(i);
            listChildFragment.add(CommonTabbedFragment.newInstance(childModel, i, parentPosition, isFilterApplied));
            listTitle.add(childModelList.get(i).getTabTitle());
            //  parentPagerAdapter.addFragment(CommonFragmentPager.newInstance(parentData,i), parentData.getTitle());
        }
        childPagerAdapter.setCHildPagerData(listChildFragment, listTitle);
        viewPager.setAdapter(childPagerAdapter);


        //  childPagerAdapter = new ChildPagerAdapter(getChildFragmentManager());

      /*  List<ParentData> parentDataList = ((ViewPagerActivity)getActivity()).getMainParentData();
       // childModelList.clear();
        if(parentDataList!=null && parentDataList.size() > parentPosition &&
                parentDataList.get(parentPosition).getmListChild()!=null

                ){
            childModelList.addAll(parentDataList.get(parentPosition).getmListChild());
        }*/

        /*for (int i = 0; i < childModelList.size(); i++) {
            ChildModel childModel = childModelList.get(i);
            childPagerAdapter.addFragment(CommonTabbedFragment.newInstance(childModel, parentPosition, i,isFilterApplied), childModel.getTabTitle());
        }

        viewPager.setAdapter(childPagerAdapter);*/
    }

    @Override
    public void setUserVisibleHint(boolean isFragmentVisible_) {
        super.setUserVisibleHint(true);


        if (this.isVisible()) {
            if (isFragmentVisible_) {

            }
        }
    }
}
