package spandroid.dev.adapter;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import java.util.List;

import spandroid.dev.R;


/**
 * Created by root on 8/25/16.
 */
public class GridAdapterInfoWindow extends BaseAdapter {

    private static final String TAG = GridAdapterInfoWindow.class.getSimpleName();
    private static final int NOT_SELECTED = -1;
    List<String> listDataInfoValue;
    Context context;
    LayoutInflater layoutInflater;
    private int selectedPos = NOT_SELECTED;

    public GridAdapterInfoWindow(Context mContext, List<String> listDataInfoValue) {
        this.context = mContext;
        this.listDataInfoValue = listDataInfoValue;

        this.layoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return listDataInfoValue.size();
    }

    @Override
    public Object getItem(int position) {
        return listDataInfoValue.get(position);
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
                convertView = layoutInflater.inflate(R.layout.row_item_product_info_popup, parent, false);

            } catch (Exception e) {
                e.printStackTrace();
            }
            viewHolder = new ViewHolder();
            viewHolder.mTextViewProductInfoPopUp = convertView.findViewById(R.id.mTextViewProductInfoPopUp);
            viewHolder.mLinearLayoutRowInfoRoot = convertView.findViewById(R.id.mLinearLayoutRowInfoRoot);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        /*if(position%2 == 0){
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                viewHolder.mLinearLayoutRowInfoRoot.setBackground(ContextCompat.getDrawable(context,R.drawable.boarder_right));
            }
            else
                viewHolder.mLinearLayoutRowInfoRoot.setBackgroundDrawable(ContextCompat.getDrawable(context,R.drawable.boarder_right));
        }
        else{
                viewHolder.mLinearLayoutRowInfoRoot.setBackgroundColor(ContextCompat.getColor(context,R.color.white));

        }*/

        if (listDataInfoValue.get(position).length() > 0)
            viewHolder.mTextViewProductInfoPopUp.setText("• " + listDataInfoValue.get(position));
        else
            viewHolder.mTextViewProductInfoPopUp.setText("");

        return convertView;
    }

    static class ViewHolder {
        AppCompatTextView mTextViewProductInfoPopUp;
        LinearLayout mLinearLayoutRowInfoRoot;
    }
}
