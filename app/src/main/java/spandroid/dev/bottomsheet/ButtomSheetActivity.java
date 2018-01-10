package spandroid.dev.bottomsheet;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.BottomSheetDialog;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

import spandroid.dev.R;
import spandroid.dev.adapter.SortListAdapter;


/**
 * Created by Venkatesh on 3/18/16.
 */
public class ButtomSheetActivity extends AppCompatActivity implements View.OnClickListener {

    RecyclerView recyclerView;
    boolean showFAB = true;

    FloatingActionButton fabBottomSheet;
    BottomSheetDialog bottomSheetDialog;

    SortListAdapter sortListAdapter;
    byte sortListPosition;
    List<String> listSortname = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buttomsheet);
        final Toolbar toolbar = findViewById(R.id.gmail_toolbar);
        fabBottomSheet = findViewById(R.id.fabBottomSheet);
        fabBottomSheet.setOnClickListener(this);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.gmail_list);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        listSortname.add("Popularity");
        listSortname.add("Price : Low to High");
        listSortname.add("Price : High To Low");
        listSortname.add("Men");
        listSortname.add("Women");


        /**
         * Bottom Sheet
         */

        // To handle FAB animation upon entrance and exit
        final Animation growAnimation = AnimationUtils.loadAnimation(this, R.anim.simple_grow);
        final Animation shrinkAnimation = AnimationUtils.loadAnimation(this, R.anim.simple_srink);


        final FloatingActionButton fab = findViewById(R.id.gmail_fab);

        fab.setVisibility(View.VISIBLE);
        fab.startAnimation(growAnimation);


        shrinkAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                fab.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });


        CoordinatorLayout coordinatorLayout = findViewById(R.id.gmail_coordinator);
        View bottomSheet = coordinatorLayout.findViewById(R.id.gmail_bottom_sheet);

        BottomSheetBehavior behavior = BottomSheetBehavior.from(bottomSheet);

        behavior.setBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {

                switch (newState) {

                    case BottomSheetBehavior.STATE_DRAGGING:
                        if (showFAB)
                            fab.startAnimation(shrinkAnimation);
                        break;

                    case BottomSheetBehavior.STATE_COLLAPSED:
                        showFAB = true;
                        fab.setVisibility(View.VISIBLE);
                        fab.startAnimation(growAnimation);
                        break;

                    case BottomSheetBehavior.STATE_EXPANDED:
                        showFAB = false;
                        break;


                }

            }

            @Override
            public void onSlide(View bottomSheet, float slideOffset) {

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_buttomsheet, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_settings:
                return true;
            case android.R.id.home:
                supportFinishAfterTransition();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fabBottomSheet:
                openSortBottomSheetDialog();
                break;
        }
    }

    protected void openSortBottomSheetDialog() {
        ListView listviewSort;


        if (bottomSheetDialog == null)
            bottomSheetDialog = new BottomSheetDialog(ButtomSheetActivity.this);

        bottomSheetDialog.setContentView(R.layout.bottomsheet_sort);
        listviewSort = bottomSheetDialog.findViewById(R.id.listviewSort);

        sortListAdapter = new SortListAdapter(ButtomSheetActivity.this, listSortname);
        sortListAdapter.setSelectedRow(sortListPosition);
        listviewSort.setAdapter(sortListAdapter);
        listviewSort.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                sortListPosition = (byte) i;
                sortListAdapter.setSelectedRow(sortListPosition);
                bottomSheetDialog.dismiss();
            }
        });

        bottomSheetDialog.show();

    }
}
