package spandroid.dev.kotlin.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import spandroid.dev.R
import spandroid.dev.kotlin.adapter.viewHolder.*

/**
 * Created by root on 3/24/18.
 */
class CommonRecyclerViewAdapter(private val listObject: List<Any>, private val rowType: Int = -1) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): RecyclerView.ViewHolder {
        lateinit var view: View
        lateinit var holder: RecyclerView.ViewHolder

        when (viewType) {

            ViewHolderManager.ROW_HEADER -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_FOOTER -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_IMAGE -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_IMAGE_WITH_TEXT -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_GRID -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_HORIZONTAL -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_AUDIO -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }
            ViewHolderManager.ROW_VIDEO -> {
                view = LayoutInflater.from(parent!!.context).inflate(R.layout.itemview_kotlin_title, parent, false)
                holder = ViewHolderHeader(view)
            }

        }
        return holder
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder?, position: Int) {
        var rowData = listObject.get(position)
        when (holder!!.itemViewType) {
            ViewHolderManager.ROW_HEADER -> {
                val holderHeader = holder as ViewHolderHeader
                holderHeader.setData(rowData as String)
            }
            ViewHolderManager.ROW_FOOTER -> {
                val holderHeader = holder as ViewHolderHeader
                holderHeader.setData(rowData as String)
            }
            ViewHolderManager.ROW_IMAGE -> {
                val holderImage = holder as ViewHolderImage
                holderImage.setData(rowData as String)
            }
            ViewHolderManager.ROW_IMAGE_WITH_TEXT -> {
                val holderimageText = holder as ViewHolderImageText
                holderimageText.setData(rowData as String)
            }
            ViewHolderManager.ROW_GRID -> {
                val holderGrid = holder as ViewHolderGrid
                holderGrid.setData(rowData as String)
            }
            ViewHolderManager.ROW_HORIZONTAL -> {
                val holderHorozontal = holder as ViewHolderHorizontal
                holderHorozontal.setData(rowData as String)
            }
            ViewHolderManager.ROW_AUDIO -> {
                val holderAudio = holder as ViewHolderAudio
                holderAudio.setData(rowData as String)
            }
            ViewHolderManager.ROW_VIDEO -> {
                val holderVideo = holder as ViewHolderVideo
                holderVideo.setData(rowData as String)
            }

        }
    }

    override fun getItemCount(): Int {
        return listObject.size
    }


}