package spandroid.dev.imageLoading;

/**
 * Created by root on 9/19/16.
 */

import android.content.Context;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

import java.util.List;

import spandroid.dev.R;
import spandroid.dev.imageLoading.helper.ImageLoaderHelper;

/**
 * Created by Craftsvilla on 7/26/16 .
 */
public class AdapterImageLoading extends RecyclerView.Adapter<AdapterImageLoading.ViewHolderProduct> {

    public static final int IMAGE_LOADER_GLIDE = 1;
    public static final int IMAGE_LOADER_PICASO = 2;
    public static final int IMAGE_LOADER_UNIVERSAL = 3;
    private static final String TAG = AdapterImageLoading.class.getSimpleName();
    List<String> listImages;
    //image loader
    // interface for click listener
    OnImageClickListener onImageClickListener;
    int imageLoaderType;
    private ImageLoaderHelper imageLoaderHelper;
    private Context context;

    public AdapterImageLoading(Context cctx, List<String> data, OnImageClickListener mOnImageClickListener, int imagerLoader) {
        this.context = cctx;
        this.listImages = data;
        onImageClickListener = mOnImageClickListener;
        this.imageLoaderType = imagerLoader;
        imageLoaderHelper = new ImageLoaderHelper(context);
    }

    @Override
    public ViewHolderProduct onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_imageloading, parent, false);

        return new ViewHolderProduct(itemView);
    }

    @Override
    public void onBindViewHolder(ViewHolderProduct holder, final int position) {

        final String imageUrl = listImages.get(position);
        switch (imageLoaderType) {

            case IMAGE_LOADER_GLIDE:
                Glide.with(context).load("http://goo.gl/gEgYUd").into(holder.imageViewProduct);


                break;
            case IMAGE_LOADER_PICASO:
                Picasso.with(context)
                        .load(imageUrl)
                        .placeholder(R.mipmap.ic_launcher)
                        .error(R.mipmap.ic_launcher)
                        .into(holder.imageViewProduct);
                break;
            case IMAGE_LOADER_UNIVERSAL:
                holder.imageViewProduct.setTag(imageUrl);
                imageLoaderHelper.loadImageCategory(imageUrl, holder.imageViewProduct);
                break;

        }

        holder.imageViewProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onImageClickListener != null) {
                    onImageClickListener.onImageClick(position, imageUrl);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listImages.size();
    }

    public class ViewHolderProduct extends RecyclerView.ViewHolder {
        RelativeLayout relativeLayoutItemSimilarProduct;
        AppCompatTextView textViewProductname;
        AppCompatImageView imageViewProduct;

        public ViewHolderProduct(View v) {
            super(v);
            relativeLayoutItemSimilarProduct = v.findViewById(R.id.mRelativeLayoutItemSimilarProduct);
            this.imageViewProduct = v.findViewById(R.id.imageViewProduct);
        }
    }

}