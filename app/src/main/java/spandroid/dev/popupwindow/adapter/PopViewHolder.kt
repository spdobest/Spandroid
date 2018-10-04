package spandroid.dev.popupwindow.adapter

import android.support.v7.widget.AppCompatButton
import android.support.v7.widget.RecyclerView
import android.view.View
import kotlinx.android.synthetic.main.itemview_popup.view.*
import spandroid.dev.R

class PopViewHolder(view:View) : RecyclerView.ViewHolder(view){
    var buttonA: AppCompatButton = view?.findViewById(R.id.buttonA)
    var buttonB: AppCompatButton = view?.findViewById(R.id.buttonB)
}