package spandroid.dev.recyclerView.loadmore_dragdrop;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import spandroid.dev.R;

public class LoadMoreAndDragDropRecyclerActivity extends AppCompatActivity {

    RecyclerView recyclerViewLoadMore;
    AppCompatEditText editSearch;
    FrameLayout rootLayout;
    ProgressBar progressLoadMore;
    boolean isLoadingMoreItems;
    LoadMoreRecyclerAdapter loadMoreRecyclerAdapter;
    List<String> listProducts = new ArrayList<>();
    GridLayoutManager gridLayoutManager;

    int firstPosition = 0;
    ItemTouchHelper.Callback _ithCallback = new ItemTouchHelper.Callback() {
        //and in your imlpementaion of
        public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
            // get the viewHolder's and target's positions in your adapter data, swap them
            Collections.swap(listProducts, viewHolder.getAdapterPosition(), target.getAdapterPosition());
            // and notify the adapter that its dataset has changed
            loadMoreRecyclerAdapter.notifyItemMoved(viewHolder.getAdapterPosition(), target.getAdapterPosition());
            return true;
        }

        @Override
        public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
            //TODO
        }

        //defines the enabled move directions in each state (idle, swiping, dragging).
        @Override
        public int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return makeFlag(ItemTouchHelper.ACTION_STATE_DRAG,
                    ItemTouchHelper.DOWN | ItemTouchHelper.UP | ItemTouchHelper.START | ItemTouchHelper.END);
        }
    };

    @Override
    protected void onResume() {
        super.onResume();
        rootLayout.setFocusable(true);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerViewLoadMore = findViewById(R.id.recyclerViewLoadMore);
        rootLayout = findViewById(R.id.rootLayout);
        editSearch = findViewById(R.id.editSearch);
        progressLoadMore = findViewById(R.id.progressLoadMore);

        for (int i = 0; i < 20; i++) {
            listProducts.add("Items " + i);
        }

        loadMoreRecyclerAdapter = new LoadMoreRecyclerAdapter(listProducts);
        gridLayoutManager = new GridLayoutManager(LoadMoreAndDragDropRecyclerActivity.this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerViewLoadMore.setLayoutManager(gridLayoutManager);
        recyclerViewLoadMore.setAdapter(loadMoreRecyclerAdapter);

        setDragAndDrop();

        recyclerViewLoadMore.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!isLoadingMoreItems) {
                        progressLoadMore.setVisibility(View.GONE);
                    }

                } else {
                    // progressLoadMore.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = gridLayoutManager.getChildCount();
                int totalItemCount = gridLayoutManager.getItemCount();
                int firstVisibleItemPosition = gridLayoutManager.findFirstVisibleItemPosition();

                if (!isLoadingMoreItems) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0) {
                        isLoadingMoreItems = true;

                        firstPosition = listProducts.size();

                        progressLoadMore.setVisibility(View.VISIBLE);
                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 10; i++) {
                                    listProducts.add("T SHirt Demo " + i);
                                }
                                isLoadingMoreItems = false;
                                progressLoadMore.setVisibility(View.GONE);
                                loadMoreRecyclerAdapter.notifyItemRangeChanged(firstPosition, listProducts.size());
                            }
                        }, 3000);
                    }
                }
            }
        });
    }

    private void setDragAndDrop() {
        // Create an `ItemTouchHelper` and attach it to the `RecyclerView`
        ItemTouchHelper ith = new ItemTouchHelper(_ithCallback);
        ith.attachToRecyclerView(recyclerViewLoadMore);

// Extend the Callback class


    }
}
