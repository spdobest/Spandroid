package spandroid.dev.network.retrofit;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spandroid.dev.R;
import spandroid.dev.network.retrofit.dto.hive.Movie;
import spandroid.dev.network.retrofit.dto.hive.MoviesResponse;

public class RetrofitMainActivity extends AppCompatActivity {
    private static final String TAG = RetrofitMainActivity.class.getSimpleName();

    // TODO - insert your themoviedb.org API KEY here
    private final static String API_KEY = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_main);


        APiService apiService =
                RetrofitClient.getClient().create(APiService.class);

        Call<MoviesResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<MoviesResponse>() {
            @Override
            public void onResponse(Call<MoviesResponse> call, Response<MoviesResponse> response) {
                List<Movie> movies = response.body().getResults();
                Log.d(TAG, "Number of movies received: " + movies.size());
            }

            @Override
            public void onFailure(Call<MoviesResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
