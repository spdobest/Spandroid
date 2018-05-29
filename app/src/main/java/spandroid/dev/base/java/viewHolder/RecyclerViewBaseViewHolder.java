package spandroid.dev.base.java.viewHolder;

import android.support.v7.widget.RecyclerView;
import android.view.View;


public abstract class RecyclerViewBaseViewHolder<T> extends RecyclerView.ViewHolder
        implements View.OnClickListener,
        View.OnLongClickListener, RVObserver {

    protected T item;
    protected int position;
    private RecyclerViewItemClickListener listener;
    private RVObservable observable;

    protected RecyclerViewBaseViewHolder(View itemView, RVObservable observable) {
        super(itemView);
        this.observable = observable;
        observable.registerObserver(this);
    }

    /**
     * Used to bind items to view holder.
     *
     * @param item     item within the adapter's data set
     * @param position The mPosition of the item within the adapter's data set
     */
    public final void performBind(T item, int position) {
        this.item = item;
        this.position = position;
    }

    /**
     * onClick has been delegated to fragment having recycler view.
     *
     * @param view view which is clicked
     */
    @Override
    public final void onClick(View view) {
        if (listener != null) {
            listener.onClick(view, item);
        }
    }

    /**
     * onLongClick has been delegated to fragment having recycler view.
     *
     * @param view view which is clicked
     */
    @Override
    public final boolean onLongClick(View view) {
        return listener != null && listener.onLongClick(view, item);
    }

    /**
     * Used to update view holder with a listener listening to all the clicks on recycler view.
     *
     * @param listener An implementation of RecyclerViewItemClickListener
     */
    @Override
    public final void update(RecyclerViewItemClickListener listener) {
        this.listener = listener;
    }
}