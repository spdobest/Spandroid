package spandroid.dev.base.java.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import java.util.List;

import spandroid.dev.base.java.viewHolder.RVObservable;
import spandroid.dev.base.java.viewHolder.RVObserver;
import spandroid.dev.base.java.viewHolder.RecyclerViewBaseViewHolder;
import spandroid.dev.base.java.viewHolder.RecyclerViewItemClickListener;

public abstract class RecyclerViewBaseAdapter<T, VH extends RecyclerViewBaseViewHolder> extends
        RecyclerView.Adapter<VH> implements RVObservable {

    protected List<T> items;
    private RecyclerViewItemClickListener listener;
    private RVObserver observer;

    @Override
    public final VH onCreateViewHolder(ViewGroup parent, int viewType) {
        VH vh = onCreateRecyclerViewHolder(parent, viewType);
        notifyListenerAttached();
        return vh;
    }

    @Override
    public final void onBindViewHolder(VH holder, int position) {
        if (items != null) {
            holder.performBind(items.get(position), position);
        }
        onBindRecyclerViewHolder(holder, position);
    }

    /**
     * Functionality of onCreateViewHolder has been moved here. User should override this when using
     * this class
     * @param parent The ViewGroup into which the new View will be added after it is bound to
     *               an adapter mPosition.
     * @param viewType The view type of the new View.
     * @return A new ViewHolder that holds a View of the given view type.
     */
    public abstract VH onCreateRecyclerViewHolder(ViewGroup parent, int viewType);

    /**
     * Functionality of onBindViewHolder has been moved here. User should override this when using
     * this class
     * @param holder The ViewHolder which should be updated to represent the contents of the
     *               item at the given mPosition in the data set.
     * @param position The mPosition of the item within the adapter's data set.
     */
    public abstract void onBindRecyclerViewHolder(VH holder, int position);

    /**
     * Method used to set on item click listener of Recycler view.
     * @param listener An implementation of RecyclerViewItemClickListener
     */
    public void setOnItemClickListener(RecyclerViewItemClickListener listener){
        this.listener = listener;
        notifyListenerAttached();
    }

    /**
     * Used to update adapter's data
     * @param items adapter's data
     */
    public void setDataset(List<T> items) {
        this.items = items;
        notifyDataSetChanged();
    }

    /**
     * Used to register view holder in adapter.
     * @param o view holder implementing observer interface.
     */
    @Override
    public final void registerObserver(RVObserver o) {
        this.observer = o;
    }

    /**
     * Used to remove registered view holder in adapter.
     */
    @Override
    public final void removeObserver() {
        this.observer = null;
    }

    /**
     * Used to notify view holder that on click listener of recycler view has been updated.
     */
    @Override
    public final void notifyListenerAttached(){
        if (observer != null && listener != null) {
            observer.update(listener);
        }
    }
}