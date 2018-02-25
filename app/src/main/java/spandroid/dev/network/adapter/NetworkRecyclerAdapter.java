package spandroid.dev.network.adapter;

/**
 * Created by root on 2/8/18.
 */

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import spandroid.dev.R;
import spandroid.dev.network.retrofit.dto.hive.Movie;

public class NetworkRecyclerAdapter extends RecyclerView.Adapter<NetworkRecyclerAdapter.MovieViewHolder> {

    private List<Movie> movies;
    private int rowLayout;
    private Context context;


    public NetworkRecyclerAdapter(List<Movie> movies, Context context) {
        this.movies = movies;
        this.context = context;
    }

    @Override
    public NetworkRecyclerAdapter.MovieViewHolder onCreateViewHolder(ViewGroup parent,
                                                                     int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemview_network, parent, false);
        return new MovieViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MovieViewHolder holder, final int position) {
        holder.movieTitle.setText(movies.get(position).getTitle());
        holder.data.setText(movies.get(position).getReleaseDate());
        holder.movieDescription.setText(movies.get(position).getOverview());
        holder.rating.setText(movies.get(position).getVoteAverage().toString());
    }

    @Override
    public int getItemCount() {
        return movies.size();
    }

    public static class MovieViewHolder extends RecyclerView.ViewHolder {
        LinearLayout moviesLayout;
        TextView movieTitle;
        TextView data;
        TextView movieDescription;
        TextView rating;


        public MovieViewHolder(View v) {
            super(v);
            moviesLayout = v.findViewById(R.id.movies_layout);
            movieTitle = v.findViewById(R.id.title);
            data = v.findViewById(R.id.subtitle);
            movieDescription = v.findViewById(R.id.description);
            rating = v.findViewById(R.id.rating);
        }
    }
}