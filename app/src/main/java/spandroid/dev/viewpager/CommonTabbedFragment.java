package spandroid.dev.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import spandroid.dev.R;
import spandroid.dev.viewpager.adapter.MoviesAdapter;
import spandroid.dev.viewpager.model.ChildModel;
import spandroid.dev.viewpager.model.ParentData;

/**
 * Created by sibaprasad on 22/12/16.
 */

public class CommonTabbedFragment extends Fragment implements OnDeleteCLickListener {
    public static final String TAG = "CommonTabbedFragment";
    int tabType = -1;

    List<String> listData = new ArrayList<>();

    MoviesAdapter moviesAdapter;
    /*@BindView(R.id.recyclerViewTab)*/
    RecyclerView recyclerViewTab;
    @BindView(R.id.imageViewPlayPause)
    AppCompatImageView imageViewPlayPause;
    @BindView(R.id.progressBarMediaPlayer)
    ProgressBar progressBarMediaPlayer;

    ChildModel childModel;
    int childPosition = -1;
    int parentPosition = -1;

    boolean isFilterApplied;

    public static CommonTabbedFragment newInstance(ChildModel mChildModel,
                                                   int parentPos,
                                                   int childPosition,
                                                   boolean isFilterApplied) {

        Bundle args = new Bundle();
        args.putParcelable(Constants.BundelKey.CHILD_DATA, mChildModel);
        args.putInt(Constants.BundelKey.PARENT_POTITION, parentPos);
        args.putInt(Constants.BundelKey.CHILD_POTITION, childPosition);
        args.putBoolean(Constants.BundelKey.ISFILTER_APPLIED, isFilterApplied);
        CommonTabbedFragment fragment = new CommonTabbedFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            if (bundle.containsKey(Constants.BundelKey.CHILD_DATA)) {
                childModel = bundle.getParcelable(Constants.BundelKey.CHILD_DATA);
            }
            if (bundle.containsKey(Constants.BundelKey.CHILD_POTITION)) {
                childPosition = bundle.getInt(Constants.BundelKey.CHILD_POTITION);
            }
            if (bundle.containsKey(Constants.BundelKey.PARENT_POTITION)) {
                parentPosition = bundle.getInt(Constants.BundelKey.PARENT_POTITION);
            }

            if (bundle.containsKey(Constants.BundelKey.ISFILTER_APPLIED)) {
                this.isFilterApplied = bundle.getBoolean(Constants.BundelKey.ISFILTER_APPLIED);
            }

            Log.i(TAG, "onCreate: Child Fragment " + isFilterApplied);

        }


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_commonfragment, container, false);

        initView(rootView);

        ButterKnife.bind(this, rootView);
        return rootView;
    }

    private void initView(View rootView) {
        recyclerViewTab = rootView.findViewById(R.id.recyclerViewTab);

        listData.clear();
        for (String s : childModel.getChildListData()) {
            if (isFilterApplied) {
                listData.add(s.toUpperCase());
            } else {
                listData.add(s.toLowerCase());
            }
        }

      /*  List<ParentData> parentDataList = ((ViewPagerActivity)getActivity()).getMainParentData();
      //  listData.clear();
        if(parentDataList!=null && parentDataList.size() > parentPosition &&
                parentDataList.get(parentPosition).getmListChild()!=null &&
                parentDataList.get(parentPosition).getmListChild().size()> childPosition &&
                parentDataList.get(parentPosition).getmListChild().get(childPosition)!=null
                ){
            listData.addAll(parentDataList.get(parentPosition).getmListChild().get(childPosition).getChildListData());
        }*/
        setupRecyclerView(recyclerViewTab);
    }

    private void setupRecyclerView(RecyclerView recyclerView) {
        moviesAdapter = new MoviesAdapter(getActivity(), listData);
        recyclerView.setLayoutManager(new LinearLayoutManager(recyclerView.getContext()));
        recyclerView.setAdapter(moviesAdapter);
    }

    private List<String> getRandomSublist(String[] array, int amount) {
        ArrayList<String> list = new ArrayList<>(amount);
        Random random = new Random();
        while (list.size() < amount) {
            list.add(array[random.nextInt(array.length)]);
        }
        return list;
    }

    @Override
    public boolean getUserVisibleHint() {
        return super.getUserVisibleHint();
    }

    @Override
    public void setUserVisibleHint(boolean isFragmentVisible_) {
        super.setUserVisibleHint(true);


        if (this.isVisible()) {
            if (isFragmentVisible_) {
                List<ParentData> parentDataList = ((ViewPagerActivity) getActivity()).getMainParentData();
                listData.clear();

                listData.clear();
                for (String s : childModel.getChildListData()) {
                    if (isFilterApplied) {
                        listData.add(s.toUpperCase());
                    } else {
                        listData.add(s.toLowerCase());
                    }
                }

                //  listData.addAll(parentDataList.get(parentPosition).getmListChild().get(childPosition).getChildListData());
                moviesAdapter.notifyDataSetChanged();
            }
        }
    }

    @Override
    public void onDeleteItem(int position) {

    }
}