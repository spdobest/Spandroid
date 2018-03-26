package spandroid.dev.kotlin.adapter.viewHolder

import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.itemview_kotlin_title.*

/**
 * Created by root on 3/24/18.
 */
class ViewHolderHorizontal(override val containerView: View?) :
        RecyclerView.ViewHolder(containerView),
        LayoutContainer {
    fun setData(data: String) {
        textViewTitle?.text = data
    }
}