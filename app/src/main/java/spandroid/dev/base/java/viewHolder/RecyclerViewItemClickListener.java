package spandroid.dev.base.java.viewHolder;

import android.view.View;

public interface RecyclerViewItemClickListener<T> {
    void onClick(View view, T item);
    boolean onLongClick(View view, T item);
}