package spandroid.dev.imageLoading.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v7.widget.AppCompatImageView;
import android.view.View;
import android.widget.ImageView;

import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.imageaware.ImageViewAware;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;
import com.nostra13.universalimageloader.core.listener.ImageLoadingProgressListener;

import spandroid.dev.app.SpandroidApplication;

/**
 * Created by craftsvilla on 8/11/16.
 */

public class ImageLoaderHelper {

    private static final String TAG = "ImageLoaderHelper";
    Context context;
    ImageViewAware imageAware;

    public ImageLoaderHelper(Context context) {
        this.context = context;


    }

    public void loadImage(String imgUrl, final AppCompatImageView imageView) {
        imageAware = new ImageViewAware(imageView, false);

        SpandroidApplication.getImageLoader().displayImage(imgUrl, imageAware, null, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {

            }
        });
    }

    public void loadImageCategory(String imgUrl, final AppCompatImageView imageView) {
        imageAware = new ImageViewAware(imageView, false);

        SpandroidApplication.getImageLoader().displayImage(imgUrl, imageAware, null, new ImageLoadingListener() {
            @Override
            public void onLoadingStarted(String imageUri, View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }

            @Override
            public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }

            @Override
            public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
            }

            @Override
            public void onLoadingCancelled(String imageUri, View view) {
                imageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
            }
        }, new ImageLoadingProgressListener() {
            @Override
            public void onProgressUpdate(String imageUri, View view, int current, int total) {

            }
        });
    }

}
