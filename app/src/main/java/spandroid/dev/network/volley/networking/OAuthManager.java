/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.network.volley.networking;

import android.app.ProgressDialog;
import android.content.Context;
import android.util.Log;

import java.util.Map;

import spandroid.dev.network.volley.VolleyConstants;
import spandroid.dev.network.volley.VolleyPreferenceManager;


/**
 * Created by Ravindra N on 22/2/16
 */
public class OAuthManager {

    public static final String TAG = "OAuth";
    public static final String URL_QUERY_PARAM_SEPARATOR = "?";
    private static OAuthManager sInstance;
    //   CustomProgressDialog customProgressDialog;
    ProgressDialog progressDialog;

    private OAuthManager() {
    }

    public static synchronized OAuthManager getInstance() {
        if (sInstance == null)
            sInstance = new OAuthManager();
        return sInstance;
    }

    public void getGuestSession(final Context ctx, final RefreshTokenCallback callback) {
        // RoboGuice.getInjector(ctx).injectMembers(this);

        /*mLoginInterator.guestSession(ctx, new APIResponseListener<GuestResponseDTO>() {
            @Override
            public void onSuccessResponse(GuestResponseDTO response) {
                if (response == null) {
                    return;
                }
                if (response.status == 1) {
                    //save session id
                    VolleyPreferenceManager.getInstance(ctx).setGuestId(response.data.sessionId);
                    if (callback != null)
                        callback.onSuccess();
                } else {
                    if (callback != null)
                        callback.onError();
                }
            }

            @Override
            public void onResponseError(String message) {

            }
        }, VolleyConstants.EMPTY_TEXT);*/
    }

    /* public boolean handleServiceResponse(final Context app, NetworkResponse response, final Request<?> request) {
         Log.i(TAG, "handleServiceResponse: IN Outh Manager");
         boolean shouldPropogateError = false;
         if (response == null) {
             Log.i(TAG, "handleServiceResponse:InHandleDeliveryErrorTrue");
             shouldPropogateError = true;
         } else {
             if (response.statusCode == HttpsURLConnection.HTTP_FORBIDDEN) {  //HTTP_UNAUTHORIZED
                 Log.w(TAG, "error response unauthorized");
                 shouldPropogateError = true;
                 if (LoginUtil.isUserLoggedIn(app)) {
                     //Reset customerid and token
                     VolleyPreferenceManager VolleyPreferenceManager = spandroid.dev.network.volley.VolleyPreferenceManager.getInstance(app);
                     spandroid.dev.network.volley.VolleyPreferenceManager.setToken(VolleyConstants.EMPTY_TEXT);
                     spandroid.dev.network.volley.VolleyPreferenceManager.setCustomerId(VolleyConstants.EMPTY_TEXT);
                     spandroid.dev.network.volley.VolleyPreferenceManager.setCustomerCartCount(0);
                     splashActivityInteractor = new SplashActivityInteractor();
                     //   customProgressDialog=CustomProgressDialog.getmInstance(app);
                     progressDialog = new ProgressDialog(app);
                     //   customProgressDialog.showDialog();

                     if (progressDialog != null) {
                         progressDialog.setMessage("Loading");
                         progressDialog.setIndeterminate(false);
                         progressDialog.setCancelable(false);
                         progressDialog.show();
                     }
                     splashActivityInteractor.getSessionExpire(app, new APIResponseListener<SessionParent>() {
                         @Override
                         public void onSuccessResponse(SessionParent response) {
                             //   customProgressDialog.cancelDialog();
                             if (progressDialog != null) {
                                 if (progressDialog.isShowing())
                                     progressDialog.cancel();
                             }
                             if (response != null && response.sessionData != null) {
                                 if (response.status == 1) {
                                     spandroid.dev.network.volley.VolleyPreferenceManager.getInstance(app).setGuestId(response.sessionData.sessionId);
                                     redirectToLoginPage(app);
                                 }
                             }
                         }

                         @Override
                         public void onResponseError(String message) {
                             Log.i(TAG, "onResponseError: IN Oauth");
                         }
                     });

                 } else {
                     getGuestSession(app, new RefreshTokenCallback() {
                         @Override
                         public void onUnAuthorized() {
                             //Log.d(TAG, "redirecting to login page as refresh token invalid");
                             redirectToLoginPage(app);
                         }

                         @Override
                         public void onSuccess() {
                             Log.d(TAG, "retrying request after refreshing the access token");
                             try {
                                 // update the auth_token before retrying..
                                 setAuthToken(app, request.getHeaders(), request.getUrl());
                             } catch (AuthFailureError e) {
                                 e.printStackTrace();
                             }
                             VolleyUtil.getInstance(app).addToRequestQueue(request);
                         }

                         @Override
                         public void onError() {
                         }
                     });
                 }
             } else if (response.statusCode == HttpsURLConnection.HTTP_UNAUTHORIZED) {
                 Log.d(TAG, "redirecting to login page as user account expired");
               //  LoginManager.getInstance(app).clearLocalDataPostLogout();
                 // redirectToSplashScreen(SpandroidApplication.getInstance().getScreenCurrent());

             } else {
                 shouldPropogateError = true;
             }
         }
         return shouldPropogateError;
     }
 */
    private void redirectToSplashScreen(int currentScreen) {

    }

    public void setAuthToken(Context app, Map<String, String> headers, String url) {
        url = sanitizeQueryParams(url);
        headers.put(VolleyConstants.HeaderKeys.X_SESSION, VolleyPreferenceManager.getInstance(app).getGuestId());
        Log.v(TAG, String.format("setAuthToken url:%s \n headers:%s", url, headers));
    }

    protected String sanitizeQueryParams(String url) {
        if (url.contains(URL_QUERY_PARAM_SEPARATOR))
            url = url.substring(0, url.indexOf(URL_QUERY_PARAM_SEPARATOR));
        return url;
    }

    protected void redirectToLoginPage(Context app) {
        Log.i(TAG, "redirectToLoginPage: ");
//        LogInViewDialogFragment logInViewDialogFragment = new LogInViewDialogFragment();
//        logInViewDialogFragment.show(((AppCompatActivity) app).getSupportFragmentManager(), LogInViewDialogFragment.TAG);
    }


    public interface RefreshTokenCallback {
        void onSuccess();

        void onError();

        void onUnAuthorized();
    }

}
