/*
 * Copyright © 2016, Craftsvilla.com
 *  Written under contract by Robosoft Technologies Pvt. Ltd.
 */

package spandroid.dev.network.volley.networking;

import android.content.Context;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.util.LruCache;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import java.util.Iterator;
import java.util.Map;

import spandroid.dev.BuildConfig;

/**
 * Created by Mahesh Nayak on 04-02-2016.
 */
public class VolleyUtil {
    private static final String TAG = "VolleyUtil";
    private static VolleyUtil sInstance;
    private RequestQueue mRequestQueue;
    private ImageLoader mImageLoader;

    private VolleyUtil(final Context context) {
        mRequestQueue = Volley.newRequestQueue(context.getApplicationContext());

        mImageLoader = new ImageLoader(mRequestQueue,
                new ImageLoader.ImageCache() {
                    private final LruCache<String, Bitmap>
                            cache = new LruCache<String, Bitmap>(20);

                    @Override
                    public Bitmap getBitmap(String url) {
                        return cache.get(url);
                    }

                    @Override
                    public void putBitmap(String url, Bitmap bitmap) {
                        cache.put(url, bitmap);
                    }
                });


    }

    private VolleyUtil() {
    }

    public static synchronized VolleyUtil getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new VolleyUtil(context);
        }
        return sInstance;
    }

    public <T> void addToRequestQueue(final Request<T> req) {


        mRequestQueue.add(req);
        if (BuildConfig.DEBUG) {
            mRequestQueue.addRequestFinishedListener(new RequestQueue.RequestFinishedListener<Object>() {
                @Override
                public void onRequestFinished(Request<Object> request) {
                }
            });
        }
    }

    public void logHashMap(Request request) {
        try {
            Log.d(TAG, "==================Request Header===================");
            Map<String, String> map = request.getHeaders();
            Iterator<String> iterator = map.keySet().iterator();
            while (iterator.hasNext()) {
                String key = iterator.next();
                Log.d(TAG, key + " -> " + map.get(key));

            }
            Log.d(TAG, "=======================Body========================");

        } catch (AuthFailureError authFailureError) {
            Log.e(TAG, authFailureError.toString());
        }
    }

    public void cancelRequest(String tag) {
        if (!TextUtils.isEmpty(tag)) {
            mRequestQueue.cancelAll(tag);
        }
    }

    public ImageLoader getImageLoader() {
        return mImageLoader;
    }


}
