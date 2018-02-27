package spandroid.dev.recyclerView.loadmore;

/**
 * Created by root on 2/8/18.
 */

import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;

import java.util.List;

import spandroid.dev.R;

public class LoadMoreRecyclerAdapter extends RecyclerView.Adapter<LoadMoreRecyclerAdapter.MyViewHolder> {

    String[] imageArray = {"https://homepages.cae.wisc.edu/~ece533/images/airplane.png",
            "https://homepages.cae.wisc.edu/~ece533/images/arctichare.png",
            "https://homepages.cae.wisc.edu/~ece533/images/baboon.png",
            "https://homepages.cae.wisc.edu/~ece533/images/boat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/cat.png",
            "https://homepages.cae.wisc.edu/~ece533/images/fruits.png",
            "https://homepages.cae.wisc.edu/~ece533/images/frymire.png",
            "https://homepages.cae.wisc.edu/~ece533/images/girl.png",
            "https://homepages.cae.wisc.edu/~ece533/images/monarch.png",
            "https://homepages.cae.wisc.edu/~ece533/images/peppers.png",
            "https://homepages.cae.wisc.edu/~ece533/images/pool.png"
    };
    private List<String> moviesList;

    public LoadMoreRecyclerAdapter(List<String> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_loadmore, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        String movie = moviesList.get(position);

        Glide.with(holder.imageViewLoadMore.getContext())
                .load(imageArray[position % 11])
                .into(holder.imageViewLoadMore);


    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatImageView imageViewLoadMore;

        public MyViewHolder(View view) {
            super(view);
            imageViewLoadMore = view.findViewById(R.id.imageViewLoadMore);
        }
    }
}