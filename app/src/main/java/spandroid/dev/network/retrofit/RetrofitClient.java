package spandroid.dev.network.retrofit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import spandroid.dev.app.SpandroidApplication;

public class RetrofitClient {

    public static final String BASE_URL = "http://api.themoviedb.org/3/";
    public static int cacheSize = 10 * 1024 * 1024; // 10 MB
    private static Retrofit retrofit = null;
    private static String baseUrl = "https://api.github.com/";
    private static Cache cache = null;
    private static OkHttpClient okHttpClient = null;

    public static Retrofit getClient() {

        if (cache == null) {
            cache = new Cache(SpandroidApplication.getInstance().getCacheDir(), cacheSize);
        }
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .cache(cache)
                    .build();
        }

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .client(okHttpClient)
                    .build();
        }
        return retrofit;
    }

    // https://code.tutsplus.com/tutorials/getting-started-with-retrofit-2--cms-27792

}