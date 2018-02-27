package spandroid.dev.recyclerView.multilevel.adapter;

/**
 * Created by root on 2/8/18.
 */

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import spandroid.dev.R;
import spandroid.dev.recyclerView.multilevel.OnChildSelectListener;
import spandroid.dev.recyclerView.multilevel.model.ChildModel;

public class RecyclerChildAdapter extends RecyclerView.Adapter<RecyclerChildAdapter.MyViewHolder> {
    private static final String TAG = "RecyclerChildAdapter";

    private List<ChildModel> childList;
    private OnChildSelectListener onChildSelectListener;
    private int parentPosition;

    public RecyclerChildAdapter(List<ChildModel> childList, OnChildSelectListener mOnChildSelectListener, int parentPosition) {
        this.childList = childList;
        this.onChildSelectListener = mOnChildSelectListener;
        this.parentPosition = parentPosition;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        final View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.itemview_multilevelrecycler_child, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        final ChildModel childModel = childList.get(position);


        holder.tvParentChild.setText(childModel.getTitle());
        setImageAndTextSelector(holder.imageViewChild.getContext(),
                childModel, holder.imageViewChild, holder.tvParentChild
        );

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               /* setImageAndTextSelector(holder.imageViewChild.getContext(),
                        childModel,holder.imageViewChild,holder.tvParentChild
                );*/
                if (onChildSelectListener != null) {
                    onChildSelectListener.onChildSelect(position, childModel, parentPosition);
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return childList.size();
    }

    private void setImageAndTextSelector(Context context,
                                         ChildModel childModel,
                                         AppCompatImageView appCompatImageView,
                                         AppCompatTextView tv) {

        appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context, android.R.drawable.ic_menu_camera));


        if (!!childModel.isChecked()) {
            appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                    R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
            tv.setTextColor(ContextCompat.getColor(context, R.color.blue));
        } else {
            appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                    R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
            tv.setTextColor(ContextCompat.getColor(context, R.color.black));
        }


        /*switch (childModel.getImageType()){
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE1 :
                    if(!!childModel.isChecked()){
                        appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                                R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                    }
                    else{
                        appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                                R.color.black), android.graphics.PorterDuff.Mode.MULTIPLY);
                    }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE2 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE3 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE4 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE5 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE6 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE7 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE8 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE9 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE10 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
            case MultiLevelRecyclerViewActivity.MyConstants.TYPE11 :
                if(!childModel.isChecked()){
                    appCompatImageView.setImageDrawable(ContextCompat.getDrawable(context,android.R.drawable.ic_menu_camera));
                }
                else{
                    appCompatImageView.setColorFilter(ContextCompat.getColor(context,
                            R.color.blue), android.graphics.PorterDuff.Mode.MULTIPLY);
                }
                break;
        }*/
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // @BindView(R.id.imageViewChild)
        AppCompatImageView imageViewChild;
        //  @BindView(R.id.tvParentChild)
        AppCompatTextView tvParentChild;

        public MyViewHolder(View view) {
            super(view);
            imageViewChild = view.findViewById(R.id.imageViewChild);
            tvParentChild = view.findViewById(R.id.tvParentChild);
//            ButterKnife.bind(view);
        }
    }
}