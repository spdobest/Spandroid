package spandroid.dev.network;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spandroid.dev.R;
import spandroid.dev.network.adapter.NetworkRecyclerAdapter;
import spandroid.dev.network.async.HttpHandler;
import spandroid.dev.network.retrofit.APiService;
import spandroid.dev.network.retrofit.RetrofitClient;
import spandroid.dev.network.retrofit.dto.hive.Movie;
import spandroid.dev.network.retrofit.dto.hive.MoviesResponse;
import spandroid.dev.network.volley.networking.APIRequest;
import spandroid.dev.network.volley.networking.Connectivity;
import spandroid.dev.network.volley.networking.DialogUtil;
import spandroid.dev.network.volley.networking.RequestCode;
import spandroid.dev.network.volley.networking.VolleyUtil;

import static spandroid.dev.network.volley.networking.URLConstants.url;

public class MainNetworkActivity extends AppCompatActivity {

    private static final String TAG = "MainNetworkActivity";
    private static final int TYPE_ASYNC = 1, TYPE_RETRO = 3, TYPE_VOLLEY = 2;
    @BindView(R.id.tvVolley)
    AppCompatTextView tvVolley;
    @BindView(R.id.tvRetrofit)
    AppCompatTextView tvRetrofit;
    @BindView(R.id.tvAsync)
    AppCompatTextView tvAsync;
    @BindView(R.id.recyclerViewNetwork)
    RecyclerView recyclerViewNetwork;
    @BindView(R.id.tvVolley_activity)
    AppCompatTextView tvVolleyActivity;
    @BindView(R.id.tvRetrofit_activity)
    AppCompatTextView tvRetrofitActivity;
    @BindView(R.id.tvAsync_activity)
    AppCompatTextView tvAsyncActivity;
    @BindView(R.id.tvVolleyTime)
    AppCompatTextView tvVolleyTime;
    @BindView(R.id.tvRetrofitTime)
    AppCompatTextView tvRetrofitTime;
    @BindView(R.id.tvAsyncTime)
    AppCompatTextView tvAsyncTime;
    // https://www.themoviedb.org
//    private String API_KEY = "eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJhdWQiOiJiN2ViMzg5ZTllNmFkNWU0MzQwNzdlNGI2ZDgzYWQ3OCIsInN1YiI6IjVhOTI5YWQ5MGUwYTI2MTZjMzAxY2IyOCIsInNjb3BlcyI6WyJhcGlfcmVhZCJdLCJ2ZXJzaW9uIjoxfQ.7cfwffsiBkqvtyALjlZw36WkszoptSf3ZsYQlIkrzDY";
    private String API_KEY = "b7eb389e9e6ad5e434077e4b6d83ad78";
    private ProgressDialog pDialog;
    private List<Movie> listMovies = new ArrayList<>();
    private NetworkRecyclerAdapter networkRecyclerAdapter;
    private long timeStart = 0;
    private int networkType = -1;


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {


        if (requestCode == 123) {
            if (data != null && data.hasExtra("data_uri")) {
                String uri = data.getExtras().getString("data_uri");
            }
        }

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_network);
        ButterKnife.bind(this);


//        Intent intent = new Intent(this, ImagePickerManager.class);
//        startActivityForResult(intent, 123);

        recyclerViewNetwork.setLayoutManager(new LinearLayoutManager(MainNetworkActivity.this,
                LinearLayoutManager.VERTICAL, false));
        networkRecyclerAdapter = new NetworkRecyclerAdapter(listMovies, MainNetworkActivity.this);
        recyclerViewNetwork.setAdapter(networkRecyclerAdapter);

        //    AnalyticsManager.aboutUs(MainNetworkActivity.this);


    }

    @OnClick({R.id.tvVolley, R.id.tvRetrofit, R.id.tvAsync, R.id.tvVolley_activity, R.id.tvRetrofit_activity, R.id.tvAsync_activity})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvVolley:
                networkType = TYPE_VOLLEY;
                timeStart = System.currentTimeMillis();
                startVolleyCall("Volley");
                break;
            case R.id.tvRetrofit:
                networkType = TYPE_RETRO;
                timeStart = System.currentTimeMillis();
                startRetrofitCall();
                break;
            case R.id.tvAsync:
                networkType = TYPE_ASYNC;
                timeStart = System.currentTimeMillis();
                new GetMoviewAsync().execute();
                break;
            case R.id.tvVolley_activity:

                break;
            case R.id.tvRetrofit_activity:

                break;
            case R.id.tvAsync_activity:

                break;
        }
    }

    private void startRetrofitCall() {

        APiService apiService =
                RetrofitClient.getClient().create(APiService.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        showProgress("Retrofit Loading");
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {

                if (response != null && response.body() != null &&
                        response.body().getResults() != null &&
                        response.body().getResults().size() > 0) {
                    refreshMovie(response.body().getResults());
                } else {
                    hideProgress();
                    Toast.makeText(MainNetworkActivity.this, "Retro Error", Toast.LENGTH_SHORT).show();
                }

            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
                hideProgress();
                Toast.makeText(MainNetworkActivity.this, "Retro Error", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void startVolleyCall(String tag) {
        String url = "http://api.themoviedb.org/3/movie/top_rated?api_key=b7eb389e9e6ad5e434077e4b6d83ad78";
        try {
            if (Connectivity.isConnected(this)) {
                showProgress("Volley Loading");
                APIRequest.Builder<MoviesResponse> builder = new APIRequest.Builder<>(this, Request.Method.GET,
                        MoviesResponse.class,
                        url,
                        new com.android.volley.Response.Listener<MoviesResponse>() {
                            @Override
                            public void onResponse(MoviesResponse response) {
                                if (response != null && response.getResults() != null && response.getResults().size() > 0) {
                                    refreshMovie(response.getResults());
                                } else {
                                    hideProgress();
                                    Toast.makeText(MainNetworkActivity.this, "VOlley Error", Toast.LENGTH_SHORT).show();
                                }
                            }
                        }, new com.android.volley.Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                        hideProgress();
                        Toast.makeText(MainNetworkActivity.this, "VOlley Error", Toast.LENGTH_SHORT).show();
                        if (error.networkResponse != null) {
                            if (error.networkResponse.statusCode == RequestCode.INTERNAL_SERVER_ERROR) {

                            }
                        } else {

                        }
                    }
                });


                APIRequest request = builder.build();
                request.setTag(tag);
                VolleyUtil.getInstance(this).addToRequestQueue(request);
            } else {
                DialogUtil.showNoNetworkAlert(this);
            }
        } catch (Exception e) {
            e.printStackTrace();
            hideProgress();
        }
    }

    private void stopTimer(int type) {
        switch (type) {
            case TYPE_ASYNC:
                tvAsyncTime.setText("Time " + ((System.currentTimeMillis() - timeStart) / 1000) + " Sec");
                break;
            case TYPE_VOLLEY:
                tvVolleyTime.setText("Time " + ((System.currentTimeMillis() - timeStart) / 1000) + " Sec");
                break;
            case TYPE_RETRO:
                tvRetrofitTime.setText("Time " + ((System.currentTimeMillis() - timeStart) / 1000) + " Sec");
                break;
        }
    }

    private void showProgress(String message) {
        // Showing progress dialog
        if (pDialog == null) {
            pDialog = new ProgressDialog(MainNetworkActivity.this);
        }
        pDialog.setMessage(message);
        pDialog.setCancelable(false);
        pDialog.show();
    }

    private void hideProgress() {
        if (pDialog != null && pDialog.isShowing()) {
            pDialog.dismiss();
        }
    }

    private void refreshMovie(List<Movie> movieList) {
        stopTimer(networkType);
        hideProgress();
        if (movieList != null && movieList.size() > 0) {
            listMovies.addAll(movieList);
        }
        networkRecyclerAdapter.notifyDataSetChanged();
    }

    /**
     * Async task class to get json by making HTTP call
     */
    private class GetMoviewAsync extends AsyncTask<Void, Void, MoviesResponse> {

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            showProgress("Async Loading");
        }

        @Override
        protected MoviesResponse doInBackground(Void... arg0) {

            listMovies.clear();

            HttpHandler sh = new HttpHandler();

            url = "http://api.themoviedb.org/3/movie/top_rated?api_key=b7eb389e9e6ad5e434077e4b6d83ad78";

            // Making a request to url and getting response
            String jsonStr = sh.makeServiceCall(url);
            Log.e(TAG, "Response from url: " + jsonStr);
            MoviesResponse moviesResponse = null;
            moviesResponse = new Gson().fromJson(jsonStr, MoviesResponse.class);
            if (moviesResponse != null) {

            } else {
                Log.e(TAG, "Couldn't get json from server.");
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(getApplicationContext(),
                                "Couldn't get json from server. Check LogCat for possible errors!",
                                Toast.LENGTH_LONG)
                                .show();
                    }
                });

            }

            return moviesResponse;
        }

        @Override
        protected void onPostExecute(MoviesResponse result) {
            super.onPostExecute(result);
            refreshMovie(result.getResults());
            // Dismiss the progress dialog
            hideProgress();
            stopTimer(networkType);
            /**
             * Updating parsed JSON data into ListView
             * */
            networkRecyclerAdapter.notifyDataSetChanged();
        }

    }


}
