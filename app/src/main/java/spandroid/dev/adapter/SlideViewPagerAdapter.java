package spandroid.dev.adapter;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import java.util.List;

import spandroid.dev.R;
import spandroid.dev.dto.ImageModel;


/**
 * Created by Venkatesh on 3/15/16.
 */
public class SlideViewPagerAdapter extends PagerAdapter {

    Context context;
    List<ImageModel> data;
    int last_position = 0;
    LayoutInflater inflater;
    private int pos = 0;

    public SlideViewPagerAdapter(Context context, List<ImageModel> data) {
        this.data = data;
        this.context = context;
        inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return Integer.MAX_VALUE;
//        return data.size();
    }

    /**
     * @return the {@link #getCount()} result of the wrapped adapter
     */
    public int getRealCount() {
        return data.size();
    }


    @Override
    public boolean isViewFromObject(View view, Object object) {
//        return (view == object);
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {

        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.itemview_viewpager_image, container, false);
        ImageView imageView = layout.findViewById(R.id.mImageViewPager);
        Glide.with(context)
                .load(data.get(position % data.size()).getUrl())
                .into(imageView);
        container.addView(layout);

        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openProductList(position % 4);
            }
        });

        if (pos >= data.size() - 1) {
            Log.i("SPM", "instantiateItem: ");
            pos = 0;
        } else
            ++pos;

        last_position = pos;


        return layout;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public void setPosition(int pos) {
        this.pos = pos;
    }

/*
    @Override
    public float getPageWidth(int position) {
        return  super.getPageWidth(position);
    }*/

    private void openProductList(int position) {
        if (position == 0)
            position = 1;
//		Intent intentMen = new Intent( context, ProductListActivity.class  );
//		intentMen.putExtra( Constants.BundleKeys.IMAGE_TYPE, position );
//		context.startActivity( intentMen);
        //(( AppCompatActivity )context).finish();
    }
}
