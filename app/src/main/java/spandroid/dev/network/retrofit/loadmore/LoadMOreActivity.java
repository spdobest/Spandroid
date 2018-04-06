package spandroid.dev.network.retrofit.loadmore;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spandroid.dev.R;
import spandroid.dev.network.retrofit.APiService;
import spandroid.dev.network.retrofit.RetrofitClient;
import spandroid.dev.network.retrofit.dto.hive.Movie;
import spandroid.dev.network.retrofit.dto.hive.MoviesResponse;
import spandroid.dev.network.retrofit.loadmore.model.UserData;
import spandroid.dev.recyclerView.loadmore_dragdrop.LoadMoreAndDragDropRecyclerActivity;
import spandroid.dev.recyclerView.loadmore_dragdrop.LoadMoreRecyclerAdapter;

public class LoadMOreActivity extends AppCompatActivity {

    RecyclerView recyclerLoadMore;
    ProgressBar progressBarLoadMore;
    List<String> listProducts = new ArrayList<>();
    LoadMoreRecyclerAdapter loadMoreRecyclerAdapter;
    LinearLayoutManager linearLayoutManager;

    int firstPosition = 0;
    boolean isLoadingMoreItems = false;

    int pageOffset = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_load_more);

        recyclerLoadMore = findViewById(R.id.recyclerLoadMore);
        progressBarLoadMore = findViewById(R.id.progressBarLoadMore);


        loadMoreRecyclerAdapter = new LoadMoreRecyclerAdapter(listProducts);
        linearLayoutManager = new LinearLayoutManager(LoadMOreActivity.this);
        recyclerLoadMore.setLayoutManager(linearLayoutManager);
        recyclerLoadMore.setAdapter(loadMoreRecyclerAdapter);

        makeAPiCall(pageOffset);

        recyclerLoadMore.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    if (!isLoadingMoreItems) {
                        recyclerLoadMore.setVisibility(View.GONE);
                    }

                } else {
                    // progressLoadMore.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                int visibleItemCount = linearLayoutManager.getChildCount();
                int totalItemCount = linearLayoutManager.getItemCount();
                int firstVisibleItemPosition = linearLayoutManager.findFirstVisibleItemPosition();

                if (!isLoadingMoreItems) {
                    if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount
                            && firstVisibleItemPosition >= 0) {
                        isLoadingMoreItems = true;

                        firstPosition = listProducts.size();

                        progressBarLoadMore.setVisibility(View.VISIBLE);


                        makeAPiCall(pageOffset);

                        new Handler().postDelayed(new Runnable() {
                            @Override
                            public void run() {
                                for (int i = 0; i < 10; i++) {
                                    listProducts.add("T SHirt Demo " + i);
                                }
                                isLoadingMoreItems = false;
                                progressBarLoadMore.setVisibility(View.GONE);
                                loadMoreRecyclerAdapter.notifyItemRangeChanged(firstPosition, listProducts.size());
                            }
                        }, 3000);
                    }
                }
            }
        });


    }


    private void makeAPiCall(int pageNumber) {
        APiService apiService =
                RetrofitClient.getClient().create(APiService.class);

        Call<List<UserData>> call = apiService.getUserList("+919821273130");
        call.enqueue(new Callback<List<UserData>>() {
            @Override
            public void onResponse(Call<List<UserData>> call, Response<List<UserData>> response) {
                List<UserData> movies = response.body();
                pageOffset = pageOffset + 1;
                progressBarLoadMore.setVisibility(View.GONE);


                if (movies != null && movies.size() > 0) {
                    for (int i = 0; i < movies.size(); i++) {
                        listProducts.add(movies.get(i).getProfilePic());
                    }
                }
                isLoadingMoreItems = false;
                progressBarLoadMore.setVisibility(View.GONE);
                loadMoreRecyclerAdapter.notifyItemRangeChanged(firstPosition, listProducts.size());


            }

            @Override
            public void onFailure(Call<List<UserData>> call, Throwable t) {
                // Log error here since request failed
            }
        });
    }

}
