package spandroid.dev.network.retrofit;

import java.util.List;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.Part;
import retrofit2.http.Path;
import retrofit2.http.Query;
import spandroid.dev.network.retrofit.dto.MultipleResource;
import spandroid.dev.network.retrofit.dto.User;
import spandroid.dev.network.retrofit.dto.UserList;
import spandroid.dev.network.retrofit.dto.hive.MoviesResponse;

/**
 * Created by amitpadekar on 27/11/15.
 */
public interface APiService {

    // android hive

    @GET("movie/top_rated")
    Call<MoviesResponse> getTopRatedMovies(@Query("api_key") String apiKey);

    @GET("movie/{id}")
    Call<MoviesResponse> getMovieDetails(@Path("id") int id, @Query("api_key") String apiKey);


    @GET("/api/unknown")
    Call<MultipleResource> doGetListResources();

    @POST("/api/users")
    Call<User> createUser(@Body User user);

    @GET("/api/users?")
    Call<UserList> doGetUserList(@Query("page") String page);

    @FormUrlEncoded
    @POST("/api/users?")
    Call<UserList> doCreateUserWithField(@Field("name") String name, @Field("job") String job);


    @GET("getHomeBanners/")
    Call<User> getBanerData();


    @GET("group/{id}/users")
    Call<List<User>> groupList(@Path("id") int groupId);

    @FormUrlEncoded
    @POST("user/edit")
    Call<User> updateUser(@Field("first_name") String first, @Field("last_name") String last);

    @Multipart
    @PUT("user/photo")
    Call<User> updateUser(@Part("photo") RequestBody photo, @Part("description") RequestBody description);

	/*@Headers("Cache-Control: max-age=640000")
    @GET("widget/list")
	Call<List<Widget>> widgetList();*/


    @Headers({
            "Accept: application/vnd.github.v3.full+json",
            "User-Agent: Retrofit-Sample-App"
    })
    @GET("users/{username}")
    Call<User> getUser(@Path("username") String username);

}
