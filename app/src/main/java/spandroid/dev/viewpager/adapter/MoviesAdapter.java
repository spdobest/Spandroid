package spandroid.dev.viewpager.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import spandroid.dev.R;

/**
 * Created by sibaprasad on 28/11/16.
 */

public class MoviesAdapter extends RecyclerView.Adapter<MoviesAdapter.CartViewHolder> {
    private static final String TAG = "WishlistAdapter";
    Context context;
    List<String> listData;


    public MoviesAdapter(Context cctx, List<String> listData) {
        this.context = cctx;
        this.listData = listData;
    }

    @Override
    public CartViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_row, parent, false);

        return new CartViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(CartViewHolder holder, int position) {
        holder.tvTitle.setText(listData.get(position));
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    public class CartViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.delete_icon1)
        ImageView deleteIcon1;
        @BindView(R.id.view_Addbackground)
        RelativeLayout viewAddbackground;
        @BindView(R.id.delete_icon)
        ImageView deleteIcon;
        @BindView(R.id.view_background)
        RelativeLayout viewBackground;
        @BindView(R.id.thumbnail)
        ImageView thumbnail;
        @BindView(R.id.tvTitle)
        AppCompatTextView tvTitle;
        @BindView(R.id.btnDelete)
        AppCompatButton btnDelete;
        @BindView(R.id.view_foreground)
        RelativeLayout viewForeground;

        public CartViewHolder(View view) {
            super(view);
            ButterKnife.bind(view);
        }
    }
}
