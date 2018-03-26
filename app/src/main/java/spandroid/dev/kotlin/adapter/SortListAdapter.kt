package spandroid.dev.kotlin.adapter

import android.content.Context
import android.graphics.Typeface
import android.support.v4.content.ContextCompat
import android.support.v7.widget.AppCompatTextView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.LinearLayout
import spandroid.dev.R

class SortListAdapter(internal var context: Context, internal var listSortNames: List<String>) : BaseAdapter() {
    internal var layoutInflater: LayoutInflater
    private var selectedPos = NOT_SELECTED

    init {
        this.layoutInflater = context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
    }


    override fun getCount(): Int {
        return listSortNames.size
    }

    override fun getItem(position: Int): Any {
        return listSortNames[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        var convertView = convertView
        val viewHolder: SortListAdapter.ViewHolder

        if (convertView == null) {
            try {
                convertView = layoutInflater.inflate(R.layout.itemview_sortlist, parent, false)

            } catch (e: Exception) {
                e.printStackTrace()
            }

            viewHolder = SortListAdapter.ViewHolder()
            viewHolder.textViewNameSortItem = convertView!!.findViewById(R.id.textViewNameSortItem) as AppCompatTextView
            viewHolder.linearLayoutRootSortItem = convertView.findViewById(R.id.linearLayoutRootSortItem) as LinearLayout
            convertView.tag = viewHolder
        } else {
            viewHolder = convertView.tag as SortListAdapter.ViewHolder
        }

        //new line added
        if (position == selectedPos) {
            Log.i(TAG, "getView: text color true")
            viewHolder.textViewNameSortItem!!.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark))
            //	viewHolder.linearLayoutRootSortItem.setBackgroundColor( ContextCompat.getColor(context,R.color.color_D3D3D3) );
            viewHolder.textViewNameSortItem!!.setTypeface(null, Typeface.BOLD)
            // your color for selected item
        } else {
            Log.i(TAG, "getView: text color false")
            viewHolder.textViewNameSortItem!!.setTextColor(ContextCompat.getColor(context, R.color.secondary_text))
            //	viewHolder.linearLayoutRootSortItem.setBackgroundColor( ContextCompat.getColor(context,R.color.white) );
            viewHolder.textViewNameSortItem!!.setTypeface(null, Typeface.NORMAL)
        }
        //new line added end


        viewHolder.textViewNameSortItem!!.text = listSortNames[position]
        return convertView
    }

    internal class ViewHolder {

        var linearLayoutRootSortItem: LinearLayout? = null
        var textViewNameSortItem: AppCompatTextView? = null
    }

    //new method added
    fun setSelectedRow(selectedPosition: Int) {
        this.selectedPos = selectedPosition
        notifyDataSetChanged()
    }

    companion object {

        private val TAG = SortListAdapter::class.java.simpleName

        private val NOT_SELECTED = -1
    }
}