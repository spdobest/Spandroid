package spandroid.dev.popupwindow.adapter

import android.content.Context
import android.graphics.Color
import android.graphics.Point
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.support.v7.widget.AppCompatImageView
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.*
import android.widget.GridView
import android.widget.PopupWindow
import android.widget.RelativeLayout
import spandroid.dev.R
import spandroid.dev.adapter.GridAdapterInfoWindow

class PopAdapter(list:ArrayList<String>) : RecyclerView.Adapter<PopViewHolder>(){

    val listData = list

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PopViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.itemview_popup, parent, false)
        return PopViewHolder(view)
    }

    override fun getItemCount(): Int {
        return listData.size
    }

    override fun onBindViewHolder(holder: PopViewHolder, position: Int) {
        holder.buttonA.setOnClickListener {
            showProductInfoWindow(holder.buttonA,holder.buttonA.context)
        }

        holder.buttonB.setOnClickListener {
            showProductInfoWindow(holder.buttonB,holder.buttonB.context)
        }
    }

    private fun showProductInfoWindow(anchor: View,context:Context) {
        val mLinearlayoutInfoPopUp: RelativeLayout
        try {

            // popup window
            val popupWindowProductInfo: PopupWindow

            val listProductInfo = java.util.ArrayList<String>()

            val mImageViewInfoArrowUp: AppCompatImageView
            val mImageViewInfoArrowDown: AppCompatImageView


            val TOTAL_DATA = 6


            for (i in 0..4) {
                listProductInfo.add("SPM $i")
            }


            val inflater = context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val layout = inflater.inflate(R.layout.popup_product_info,
                    null, true)
            mLinearlayoutInfoPopUp = layout.findViewById(R.id.mLinearlayoutInfoPopUp)
            val mGridViewProductInfo = layout.findViewById<GridView>(R.id.mGridViewProductInfo)
            mImageViewInfoArrowUp = layout.findViewById(R.id.mImageViewInfoArrowUp)
            mImageViewInfoArrowDown = layout.findViewById(R.id.mImageViewInfoArrowDown)
            val gridAdapterInfoWindow = GridAdapterInfoWindow(context, listProductInfo)

            mGridViewProductInfo.adapter = gridAdapterInfoWindow

            var xPos: Int
            val yPos: Int
            val rootWidth: Int

            val location = IntArray(2)

            anchor.getLocationOnScreen(location)

            val anchorRect = Rect(location[0], location[1], location[0] + anchor.width, location[1] + anchor.height)

            layout.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)

            val rootHeight = layout.measuredHeight


            rootWidth = layout.measuredWidth

            val mWindowManager = context.getSystemService(Context.WINDOW_SERVICE) as WindowManager

            val display = mWindowManager.defaultDisplay

            val size = Point()
            display.getSize(size)
            val screenHeight = size.y
            val screenWidth = size.x

            if (anchorRect.left + rootWidth > screenWidth) {
                xPos = anchorRect.left - (rootWidth - anchor.width)
                xPos = if (xPos < 0) 0 else xPos
            } else {
                if (anchor.width > rootWidth) {
                    xPos = anchorRect.centerX() - rootWidth / 2
                } else {
                    xPos = anchorRect.left
                }
            }

            val dyTop = anchorRect.top
            val dyBottom = screenHeight - anchorRect.bottom

            //					boolean onTop = ( dyTop > dyBottom ) ? true : false;

            if (dyTop > dyBottom) {

                mImageViewInfoArrowDown.visibility = View.VISIBLE
                mImageViewInfoArrowUp.visibility = View.INVISIBLE

                if (rootHeight > dyTop) {
                    yPos = 15
                    val l = mLinearlayoutInfoPopUp.layoutParams
                    l.height = dyTop - anchor.height
                } else {
                    yPos = anchorRect.top - rootHeight
                }
            } else {

                mImageViewInfoArrowDown.visibility = View.INVISIBLE
                mImageViewInfoArrowUp.visibility = View.VISIBLE

                yPos = anchorRect.bottom

                if (rootHeight > dyBottom) {
                    val l = mLinearlayoutInfoPopUp.layoutParams
                    l.height = dyBottom
                }
            }

            popupWindowProductInfo = PopupWindow(layout, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, false)
            popupWindowProductInfo.isTouchable = true
            popupWindowProductInfo.isFocusable = true
            popupWindowProductInfo.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            popupWindowProductInfo.isOutsideTouchable = true
            popupWindowProductInfo.animationStyle = R.style.popupWindowAnimation


            /*mFrameLayoutFade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindowProductInfo.dismiss();
                }
            });*/
            if (/*listProductInfo != null &&*/ listProductInfo.size > 0) {
                // mFrameLayoutFade.setVisibility(View.VISIBLE);
                popupWindowProductInfo.showAtLocation(anchor, Gravity.NO_GRAVITY, xPos, yPos)
            }


            popupWindowProductInfo.setOnDismissListener {
                //                    mFrameLayoutFade.setVisibility(View.GONE);
                //                    mTextViewInfoPdp.setText("+ INFO");
            }

        } catch (e: Exception) {
            Log.e("TAG", "showProductInfoWindow: Error", e)
        }

    }

    companion object {
        val TAG = "PopAdapter"
    }
}