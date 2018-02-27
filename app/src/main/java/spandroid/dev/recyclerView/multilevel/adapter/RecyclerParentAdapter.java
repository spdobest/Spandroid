package spandroid.dev.recyclerView.multilevel.adapter;

/**
 * Created by root on 2/8/18.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import butterknife.ButterKnife;
import spandroid.dev.R;
import spandroid.dev.recyclerView.multilevel.OnChildSelectListener;
import spandroid.dev.recyclerView.multilevel.model.ChildModel;
import spandroid.dev.recyclerView.multilevel.model.ParentModel;

public class RecyclerParentAdapter extends RecyclerView.Adapter<RecyclerParentAdapter.MyViewHolder> {

    private static final String TAG = "RecyclerParentAdapter";

    private List<ParentModel> parentModelList;
    private OnChildSelectListener onChildSelectListener;


    public RecyclerParentAdapter(List<ParentModel> moviesList, OnChildSelectListener mOnChildSelectListener) {
        this.parentModelList = moviesList;
        this.onChildSelectListener = mOnChildSelectListener;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_multilevelrecycler_parent, parent, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        ParentModel movie = parentModelList.get(position);
        holder.tvParentTitle.setText(movie.getTitle());
        setupRecyclerView(holder.recyclerViewParent.getContext(), holder.recyclerViewParent, movie.getListChild(), position);
        if (movie.isChecked()) {
            holder.tvParentTitle.setTextColor(ContextCompat.getColor(holder.tvParentTitle.getContext(),
                    R.color.blue));
        } else {
            holder.tvParentTitle.setTextColor(ContextCompat.getColor(holder.tvParentTitle.getContext(),
                    R.color.black));
        }
    }

    @Override
    public int getItemCount() {
        return parentModelList.size();
    }

    private void setupRecyclerView(Context context, RecyclerView recyclerView, final List<ChildModel> listChilds, int parentPosition) {
        recyclerView.setLayoutManager(new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false));
        recyclerView.setAdapter(new RecyclerChildAdapter(listChilds, onChildSelectListener, parentPosition));
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        AppCompatTextView tvParentTitle;
        RecyclerView recyclerViewParent;

        public MyViewHolder(View view) {
            super(view);
            tvParentTitle = view.findViewById(R.id.tvParentTitle);
            recyclerViewParent = view.findViewById(R.id.recyclerViewParent);
            ButterKnife.bind(view);
        }
    }
}