package spandroid.dev.popupwindow

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.GridView
import android.widget.PopupWindow
import android.widget.RelativeLayout
import spandroid.dev.R
import kotlinx.android.synthetic.main.activity_pop_window_list.*
import spandroid.dev.adapter.GridAdapterInfoWindow
import spandroid.dev.popupwindow.adapter.PopAdapter
import java.util.ArrayList

class PopWindowListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pop_window_list)

        recyclerViewItems.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)

        var list = ArrayList<String>()
        list.add("Siba")
        list.add("Siba")
        list.add("Siba")
        list.add("Siba")

        list.add("Siba")
        list.add("Siba")
        list.add("Siba")
        list.add("Siba")

        list.add("Siba")
        list.add("Siba")
        list.add("Siba")
        list.add("Siba")

        var popadapter : PopAdapter = PopAdapter(list)
        recyclerViewItems.adapter = popadapter

    }




}
