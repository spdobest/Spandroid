package spandroid.dev.base.kotlin.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View

import spandroid.dev.base.java.viewHolder.RVObservable
import spandroid.dev.base.java.viewHolder.RVObserver
import spandroid.dev.base.java.viewHolder.RecyclerViewItemClickListener


abstract class KotlinRecyclerViewBaseViewHolder<T> protected constructor(itemView: View,
                                                                         private val observable: RVObservable)
    : RecyclerView.ViewHolder(itemView),
        View.OnClickListener,
        View.OnLongClickListener, RVObserver {

    protected abstract var item: T
    var mPosition: Int = 0

    private var listener: RecyclerViewItemClickListener<*>? = null

    init {
        observable.registerObserver(this)
    }

    /**
     * Used to bind items to view holder.
     *
     * @param item     item within the adapter's data set
     * @param position The mPosition of the item within the adapter's data set
     */
    fun performBind(item: T, position: Int) {
        this.item = item
        this.mPosition = position
    }

    /**
     * onClick has been delegated to fragment having recycler view.
     *
     * @param view view which is clicked
     */
    override fun onClick(view: View) {
        // listener!!.onClick(view, item)
    }

    /**
     * onLongClick has been delegated to fragment having recycler view.
     *
     * @param view view which is clicked
     */
    override fun onLongClick(view: View): Boolean {
        // return listener!!.onLongClick(view, item)
        return true
    }

    /**
     * Used to update view holder with a listener listening to all the clicks on recycler view.
     *
     * @param listener An implementation of RecyclerViewItemClickListener
     */
    override fun update(listener: RecyclerViewItemClickListener<*>) {
        this.listener = listener
    }
}