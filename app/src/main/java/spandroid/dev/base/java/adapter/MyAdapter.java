package spandroid.dev.base.java.adapter;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spandroid.dev.base.java.viewHolder.RVObservable;
import spandroid.dev.base.java.viewHolder.RecyclerViewBaseViewHolder;

/**
 * Created by root on 5/22/18.
 */

public class MyAdapter extends RecyclerViewBaseAdapter<List<String>, MyAdapter.MyViewHolder> {


    @Override
    public MyViewHolder onCreateRecyclerViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindRecyclerViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class MyViewHolder extends RecyclerViewBaseViewHolder {
        protected MyViewHolder(View itemView, RVObservable observable) {
            super(itemView, observable);
        }
    }
}
