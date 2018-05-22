package spandroid.dev.base.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import spandroid.dev.base.kotlin.viewHolder.KotlinRecyclerViewBaseViewHolder

/**
 * Created by root on 5/22/18.
 */
class KotlinBaseRecyclerViewAdapter : RecyclerView.Adapter<KotlinRecyclerViewBaseViewHolder>() {


    override fun getItemCount(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: BaseRecyclerViewHolder?, position: Int) {

    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): {
        print("")
    }
}