/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.network.volley.networking;

/**
 * Created by Mahesh Nayak on 09-05-2016.
 */
public interface APIResponseListener<T> {

    void onSuccessResponse(T response);

    void onResponseError(String message);
}
