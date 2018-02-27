package spandroid.dev.recyclerView.loadmore;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import spandroid.dev.R;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView recyclerViewLoadMore;
    AppCompatEditText editSearch;
    FrameLayout rootLayout;
    ProgressBar progressLoadMore;
    boolean isLoadingMoreItems;
    LoadMoreRecyclerAdapter loadMoreRecyclerAdapter;
    List<String> listProducts = new ArrayList<>();
    GridLayoutManager gridLayoutManager;

    int firstPosition = 0;


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
        gridLayoutManager = new GridLayoutManager(RecyclerViewActivity.this, 2, LinearLayoutManager.VERTICAL, false);
        recyclerViewLoadMore.setLayoutManager(gridLayoutManager);
        recyclerViewLoadMore.setAdapter(loadMoreRecyclerAdapter);
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
}
