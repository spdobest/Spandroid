package spandroid.dev.network.retrofit.retrofit_auth;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import spandroid.dev.BuildConfig;
import spandroid.dev.R;

import static spandroid.dev.network.retrofit.retrofit_auth.RetroAUthCOnstants.API_OAUTH_CLIENTID;
import static spandroid.dev.network.retrofit.retrofit_auth.RetroAUthCOnstants.API_OAUTH_CLIENTSECRET;
import static spandroid.dev.network.retrofit.retrofit_auth.RetroAUthCOnstants.API_OAUTH_REDIRECT;

public class RetrofitAuthActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retrofit_auth);
    }

    private void hitAPI() {
        Uri uri = getIntent().getData();
        if (uri != null && uri.toString().startsWith(API_OAUTH_REDIRECT)) {
            String code = uri.getQueryParameter("code");
            if (code != null) {
                // TODO We can probably do something with this code! Show the user that we are logging them in

                final SharedPreferences prefs = this.getSharedPreferences(
                        BuildConfig.APPLICATION_ID, Context.MODE_PRIVATE);

                APIClientAuth client = AuthServiceGenerator.createService(APIClientAuth.class);
                Call<AccessToken> call = client.getNewAccessToken(code, API_OAUTH_CLIENTID,
                        API_OAUTH_CLIENTSECRET, API_OAUTH_REDIRECT,
                        "authorization_code");
                call.enqueue(new Callback<AccessToken>() {
                    @Override
                    public void onResponse(Call<AccessToken> call, Response<AccessToken> response) {
                        int statusCode = response.code();
                        if (statusCode == 200) {
                            AccessToken token = response.body();
                            prefs.edit().putBoolean("oauth.loggedin", true).apply();
                            prefs.edit().putString("oauth.accesstoken", token.getAccessToken()).apply();
                            prefs.edit().putString("oauth.refreshtoken", token.getRefreshToken()).apply();
                            prefs.edit().putString("oauth.tokentype", token.getTokenType()).apply();

                            // TODO Show the user they are logged in
                        } else {
                            // TODO Handle errors on a failed response
                        }
                    }

                    @Override
                    public void onFailure(Call<AccessToken> call, Throwable t) {
                        // TODO Handle failure
                    }
                });
            } else {
                // TODO Handle a missing code in the redirect URI
            }
        }
    }
}
