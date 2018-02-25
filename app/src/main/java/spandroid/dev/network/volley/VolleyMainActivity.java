package spandroid.dev.network.volley;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;

import spandroid.dev.R;
import spandroid.dev.network.retrofit.dto.hive.MoviesResponse;
import spandroid.dev.network.volley.networking.APIRequest;
import spandroid.dev.network.volley.networking.Connectivity;
import spandroid.dev.network.volley.networking.DialogUtil;
import spandroid.dev.network.volley.networking.RequestCode;
import spandroid.dev.network.volley.networking.VolleyUtil;

public class VolleyMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_volley_main);


    }

    public void getMoreOmnitureDataResponse(String tag) {
        try {
            if (Connectivity.isConnected(this)) {

                APIRequest.Builder<MoviesResponse> builder = new APIRequest.Builder<>(this, Request.Method.GET,
                        MoviesResponse.class,
                        "",
                        new Response.Listener<MoviesResponse>() {
                            @Override
                            public void onResponse(MoviesResponse response) {

                            }
                        }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

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
        }
    }

}
