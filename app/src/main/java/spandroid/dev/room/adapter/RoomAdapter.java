package spandroid.dev.room.adapter;

/**
 * Created by root on 2/8/18.
 */

import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import spandroid.dev.R;
import spandroid.dev.room.ColorsHelper;
import spandroid.dev.room.controller.OnUserSelectListener;
import spandroid.dev.room.dto.User;

public class RoomAdapter extends RecyclerView.Adapter<RoomAdapter.MyViewHolder> {

    int checkedPosition = -1;
    OnUserSelectListener onUserSelectListener;
    private List<User> moviesList;
    private ArrayList<Integer> colors = new ArrayList<>();


    public RoomAdapter(List<User> moviesList, OnUserSelectListener mOnUserSelectListener) {
        this.moviesList = moviesList;
        this.onUserSelectListener = mOnUserSelectListener;
        colors.addAll(ColorsHelper.COLORS);

    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_room, parent, false);
        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                notifyDataSetChanged();
                onUserSelectListener.onViewANimate(view);
            }
        });
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        User movie = moviesList.get(position);

        holder.radioItem.setText(movie.getFirstName());
        int color = colors.get(position);
        //   holder.itemView.setBackgroundColor(color);
        if (checkedPosition == position) {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.radioItem.getContext(), R.color.tab_text_color));
        } else {
            holder.itemView.setBackgroundColor(ContextCompat.getColor(holder.radioItem.getContext(), R.color.white));
        }

        holder.radioItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkedPosition = position;
                notifyDataSetChanged();
                onUserSelectListener.onUserSelect(position, holder.itemView);
            }
        });

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public AppCompatTextView radioItem;

        public MyViewHolder(View view) {
            super(view);
            radioItem = view.findViewById(R.id.tvItemView);
        }
    }
}