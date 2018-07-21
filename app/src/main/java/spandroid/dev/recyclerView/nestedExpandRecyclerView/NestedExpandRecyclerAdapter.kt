package spandroid.dev.recyclerView.nestedExpandRecyclerView

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.TextureView
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import spandroid.dev.R
import kotlinx.android.synthetic.main.itemview_nested_recycler_radio.view.*
/**
 * Created by root on 6/19/18.
 */
class NestedExpandRecyclerAdapter(internal var listModel: List<NestedRecyclerModel>) : RecyclerView.Adapter<NestedExpandRecyclerAdapter.MyViewHolder>() {
    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getItemCount(): Int {
        return listModel!!.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_nested_recycler_radio, parent, false)
        return MyViewHolder(view)
    }


    class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        var textViewTitle:TextView = view.textViewTitle
        var radioGroup:RadioGroup = view.radioGroup
        var radio1:RadioButton = view.radio1
        var radio2:RadioButton = view.radio2
        var radio3:RadioButton = view.radio3
    }

}