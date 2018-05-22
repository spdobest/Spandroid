package spandroid.dev.base.java.base_adapter.listeners;

public interface OnRecyclerClickListener extends BaseRecyclerListener {
    /**
     * RecyclerView item has been clicked
     *
     * @param id item id
     */
    void onItemClicked(long id);
}