package spandroid.dev.recyclerView.multilevel;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import butterknife.BindView;
import butterknife.ButterKnife;
import spandroid.dev.R;
import spandroid.dev.recyclerView.multilevel.adapter.RecyclerParentAdapter;
import spandroid.dev.recyclerView.multilevel.model.ChildModel;
import spandroid.dev.recyclerView.multilevel.model.ParentModel;

public class MultiLevelRecyclerViewActivity extends AppCompatActivity implements OnChildSelectListener {

    @BindView(R.id.recyclerVIewParent)
    RecyclerView recyclerVIewParent;

    RecyclerParentAdapter recyclerParentAdapter;
    List<ParentModel> parentModelList = new ArrayList<>();

    int min = 1;
    int max = 11;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multi_level_recycler_view);
        ButterKnife.bind(this);


        for (int i = 0; i < 7; i++) {

            ParentModel parentModel = new ParentModel();
            int maxItems = new Random().nextInt(max - min + 1) + min;
            parentModel.setTitle("Header " + maxItems);
            parentModel.setChecked(false);

            List<ChildModel> listChild = new ArrayList<>();

            for (int j = 0; j < maxItems; j++) {
                ChildModel childModel = new ChildModel();
                childModel.setTitle("Title" + j);
                childModel.setChecked(false);
                childModel.setImageType(new Random().nextInt(max - min + 1) + min);
                listChild.add(childModel);
            }
            parentModel.setListChild(listChild);
            parentModelList.add(parentModel);
        }

        recyclerVIewParent.setLayoutManager(new LinearLayoutManager(MultiLevelRecyclerViewActivity.this,
                LinearLayoutManager.VERTICAL, false));
        recyclerParentAdapter = new RecyclerParentAdapter(parentModelList, this);
        recyclerVIewParent.setAdapter(recyclerParentAdapter);


    }

    @Override
    public void onChildSelect(int position, ChildModel childModel, int parentPosition) {
        if (childModel.isChecked()) {
            parentModelList.get(parentPosition).getListChild().get(position).setChecked(false);
            parentModelList.get(parentPosition).setChecked(false);
        } else {
            parentModelList.get(parentPosition).getListChild().get(position).setChecked(true);
            for (ChildModel mChildModel1 : parentModelList.get(parentPosition).getListChild()) {
                if (mChildModel1.isChecked()) {
                    parentModelList.get(parentPosition).setChecked(true);
                    break;
                } else {
                    parentModelList.get(parentPosition).setChecked(false);
                }
            }
        }


        recyclerParentAdapter.notifyItemChanged(parentPosition);
    }


    public interface MyConstants {

        int TYPE1 = 1;
        int TYPE2 = 2;
        int TYPE3 = 3;
        int TYPE4 = 4;
        int TYPE5 = 5;
        int TYPE6 = 6;
        int TYPE7 = 7;
        int TYPE8 = 8;
        int TYPE9 = 9;
        int TYPE10 = 10;
        int TYPE11 = 11;

    }
}
