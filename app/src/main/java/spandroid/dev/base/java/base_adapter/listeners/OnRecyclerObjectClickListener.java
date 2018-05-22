package spandroid.dev.base.java.base_adapter.listeners;

public interface OnRecyclerObjectClickListener<T> extends BaseRecyclerListener {
    /**
     * Item has been clicked.
     *
     * @param item object associated with the clicked item.
     */
    void onItemClicked(T item);
}