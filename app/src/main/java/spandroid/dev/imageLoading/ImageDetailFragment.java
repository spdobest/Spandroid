/*
 * Copyright (C) 2012 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package spandroid.dev.imageLoading;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import spandroid.dev.R;
import spandroid.dev.imageLoading.helper.ImageLoaderHelper;
import spandroid.dev.imageLoading.imageUtil.ImageFetcher;
import spandroid.dev.imageLoading.imageUtil.ImageWorker;
import spandroid.dev.imageLoading.imageUtil.Utils;


/**
 * This fragment will populate the children of the ViewPager from {@link ImageDetailActivity}.
 */
public class ImageDetailFragment extends Fragment implements ImageWorker.OnImageLoadedListener, OnClickListener {
    private static final String IMAGE_DATA_EXTRA = "extra_image_data";
    AppCompatImageView imageViewWrap;
    AppCompatButton btnCenterCrop, btnCenterInside, btnFitCenter, btnfitXy;
    AppCompatButton btnUniversal, btnGLide, btnPicaso;
    ImageLoaderHelper imageLoaderHelper;
    private String mImageUrl;
    private AppCompatImageView mImageView;
    private ProgressBar mProgressBar;
    private ImageFetcher mImageFetcher;

    /**
     * Empty constructor as per the Fragment documentation
     */
    public ImageDetailFragment() {
    }

    /**
     * Factory method to generate a new instance of the fragment given an image number.
     *
     * @param imageUrl The image url to load
     * @return A new instance of ImageDetailFragment with imageNum extras
     */
    public static ImageDetailFragment newInstance(String imageUrl) {
        final ImageDetailFragment f = new ImageDetailFragment();

        final Bundle args = new Bundle();
        args.putString(IMAGE_DATA_EXTRA, imageUrl);
        f.setArguments(args);

        return f;
    }

    /**
     * Populate image using a url from extras, use the convenience factory method
     * {@link ImageDetailFragment#newInstance(String)} to create this fragment.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mImageUrl = getArguments() != null ? getArguments().getString(IMAGE_DATA_EXTRA) : null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate and locate the main ImageView
        final View v = inflater.inflate(R.layout.image_detail_fragment, container, false);
        mImageView = v.findViewById(R.id.imageView);
        imageViewWrap = v.findViewById(R.id.imageViewWrap);
        mProgressBar = v.findViewById(R.id.progressbar);

        btnCenterCrop = v.findViewById(R.id.btnCenterCrop);
        btnCenterInside = v.findViewById(R.id.btnCenterInside);
        btnFitCenter = v.findViewById(R.id.btnFitCenter);
        btnfitXy = v.findViewById(R.id.btnfitXy);

        btnPicaso = v.findViewById(R.id.btnPicaso);
        btnGLide = v.findViewById(R.id.btnGLide);
        btnUniversal = v.findViewById(R.id.btnUniversal);

        btnCenterCrop.setOnClickListener(this);
        btnCenterInside.setOnClickListener(this);
        btnFitCenter.setOnClickListener(this);
        btnfitXy.setOnClickListener(this);

        btnPicaso.setOnClickListener(this);
        btnGLide.setOnClickListener(this);
        btnUniversal.setOnClickListener(this);


        return v;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCenterCrop:
                mImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                break;
            case R.id.btnCenterInside:
                mImageView.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                break;
            case R.id.btnFitCenter:
                mImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                break;
            case R.id.btnfitXy:
                mImageView.setScaleType(ImageView.ScaleType.FIT_XY);
                break;

            case R.id.btnPicaso:
                loadPicasoImage();
                break;
            case R.id.btnGLide:
                loadGlideImage();
                break;
            case R.id.btnUniversal:
                loadUniversalImage();
                break;
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        // Use the parent activity to load the image asynchronously into the ImageView (so a single
        // cache can be used over all pages in the ViewPager
        if (ImageDetailActivity.class.isInstance(getActivity())) {
            mImageFetcher = ((ImageDetailActivity) getActivity()).getImageFetcher();
            mImageFetcher.loadImage(mImageUrl, mImageView, this);

            imageLoaderHelper = new ImageLoaderHelper(getActivity());


            Picasso.with(getActivity())
                    .load(mImageUrl)
                    .placeholder(R.mipmap.ic_launcher)
                    .error(R.mipmap.ic_launcher)
                    .into(mImageView);

        }

        // Pass clicks on the ImageView to the parent activity to handle
        if (OnClickListener.class.isInstance(getActivity()) && Utils.hasHoneycomb()) {
            mImageView.setOnClickListener((OnClickListener) getActivity());
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mImageView != null) {
            // Cancel any pending image work
            ImageWorker.cancelWork(mImageView);
            mImageView.setImageDrawable(null);
        }
    }

    @Override
    public void onImageLoaded(boolean success) {
        // Set loading spinner to gone once image has loaded. Cloud also show
        // an error view here if needed.
        mProgressBar.setVisibility(View.GONE);
    }

    private void loadGlideImage() {
        Glide.with(getActivity())
                .load(mImageUrl)
                .into(mImageView);

        Glide.with(getActivity())
                .load(mImageUrl)
                .into(imageViewWrap);
    }

    private void loadPicasoImage() {
        Picasso.with(getActivity())
                .load(mImageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(mImageView);
        Picasso.with(getActivity())
                .load(mImageUrl)
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_launcher)
                .into(imageViewWrap);
    }

    private void loadUniversalImage() {
        imageLoaderHelper.loadImageCategory(mImageUrl, mImageView);
        imageLoaderHelper.loadImageCategory(mImageUrl, imageViewWrap);
    }


}
