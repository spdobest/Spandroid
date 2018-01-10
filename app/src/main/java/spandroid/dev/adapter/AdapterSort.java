package spandroid.dev.adapter;

/**
 * Created by Venkatesh on 6/20/16.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatTextView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.List;

import spandroid.dev.R;

/**
 * Created by Venkatesh on 6/8/16.
 */
public class AdapterSort extends BaseAdapter {

    private static final String TAG = AdapterSort.class.getSimpleName();
    private static final int NOT_SELECTED = -1;
    List<String> listData;
    Context context;
    LayoutInflater layoutInflater;
    private int selectedPos = NOT_SELECTED;

    public AdapterSort(Context mContext, List<String> listData) {
        this.context = mContext;
        this.listData = listData;
        this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return listData.size();
       /* return 6;*/
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder viewHolder;

        if (convertView == null) {
            try {
                convertView = layoutInflater.inflate(R.layout.itemview_imageslider, parent, false);

            } catch (Exception e) {
                e.printStackTrace();
            }
            viewHolder = new ViewHolder();
//            viewHolder.tvFilterName = (AppCompatTextView) convertView.findViewById(R.id.textviewSortItem);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        //new line added
        if (position == selectedPos) {
            Log.i(TAG, "getView: text color true");
            // your color for selected item
            viewHolder.tvFilterName.setTextColor(ContextCompat.getColor(context, R.color.colorPrimaryDark));
//            viewHolder.tvFilterName.setTypeface(null, Typeface.BOLD);
        } else {
            Log.i(TAG, "getView: text color false");
            // your color for non-selected item
            viewHolder.tvFilterName.setTextColor(ContextCompat.getColor(context, R.color.black));

        }
        //new line added end

        viewHolder.tvFilterName.setText(listData.get(position));

        return convertView;
    }

    //new method added
    public void setSelectedRow(int selectedPosition) {
        this.selectedPos = selectedPosition;
        notifyDataSetChanged();
    }

    static class ViewHolder {
        AppCompatTextView tvFilterName;
    }
}
