package spandroid.dev.popupwindow;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatImageView;
import android.util.Log;
import android.view.Display;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.GridView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import spandroid.dev.R;
import spandroid.dev.adapter.GridAdapterInfoWindow;

public class PopupWIndowActivity extends AppCompatActivity implements View.OnClickListener {

    AppCompatButton btn1, btn2, btn3, btn4, btn5, btn6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_window2);


        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        btn5 = findViewById(R.id.btn5);
        btn6 = findViewById(R.id.btn6);

        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);

    }


    private void showProductInfoWindow(View anchor) {
        RelativeLayout mLinearlayoutInfoPopUp;
        try {

            // popup window
            final PopupWindow popupWindowProductInfo;

            List<String> listProductInfo = new ArrayList<>();

            AppCompatImageView mImageViewInfoArrowUp;
            AppCompatImageView mImageViewInfoArrowDown;


            int TOTAL_DATA = 6;


            for (int i = 0; i < 5; i++) {
                listProductInfo.add("SPM " + i);
            }


            LayoutInflater inflater = (LayoutInflater) PopupWIndowActivity.this
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            View layout = inflater.inflate(R.layout.popup_product_info,
                    null, true);
            mLinearlayoutInfoPopUp = layout.findViewById(R.id.mLinearlayoutInfoPopUp);
            GridView mGridViewProductInfo = layout.findViewById(R.id.mGridViewProductInfo);
            mImageViewInfoArrowUp = layout.findViewById(R.id.mImageViewInfoArrowUp);
            mImageViewInfoArrowDown = layout.findViewById(R.id.mImageViewInfoArrowDown);
            GridAdapterInfoWindow gridAdapterInfoWindow = new GridAdapterInfoWindow(this, listProductInfo);

            mGridViewProductInfo.setAdapter(gridAdapterInfoWindow);

            int xPos, yPos;
            int rootWidth;

            int[] location = new int[2];

            anchor.getLocationOnScreen(location);

            Rect anchorRect = new Rect(location[0], location[1], location[0] + anchor.getWidth(), location[1] + anchor.getHeight());

            layout.measure(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);

            int rootHeight = layout.getMeasuredHeight();


            rootWidth = layout.getMeasuredWidth();

            WindowManager mWindowManager = (WindowManager) getSystemService(WINDOW_SERVICE);

            Display display = mWindowManager.getDefaultDisplay();

            Point size = new Point();
            display.getSize(size);
            int screenHeight = size.y;
            int screenWidth = size.x;

            if ((anchorRect.left + rootWidth) > screenWidth) {
                xPos = anchorRect.left - (rootWidth - anchor.getWidth());
                xPos = (xPos < 0) ? 0 : xPos;
            } else {
                if (anchor.getWidth() > rootWidth) {
                    xPos = anchorRect.centerX() - (rootWidth / 2);
                } else {
                    xPos = anchorRect.left;
                }
            }

            int dyTop = anchorRect.top;
            int dyBottom = screenHeight - anchorRect.bottom;

//					boolean onTop = ( dyTop > dyBottom ) ? true : false;

            if (dyTop > dyBottom) {

                mImageViewInfoArrowDown.setVisibility(View.VISIBLE);
                mImageViewInfoArrowUp.setVisibility(View.INVISIBLE);

                if (rootHeight > dyTop) {
                    yPos = 15;
                    ViewGroup.LayoutParams l = mLinearlayoutInfoPopUp.getLayoutParams();
                    l.height = dyTop - anchor.getHeight();
                } else {
                    yPos = anchorRect.top - rootHeight;
                }
            } else {

                mImageViewInfoArrowDown.setVisibility(View.INVISIBLE);
                mImageViewInfoArrowUp.setVisibility(View.VISIBLE);

                yPos = anchorRect.bottom;

                if (rootHeight > dyBottom) {
                    ViewGroup.LayoutParams l = mLinearlayoutInfoPopUp.getLayoutParams();
                    l.height = dyBottom;
                }
            }

            popupWindowProductInfo = new PopupWindow(layout, WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT, false);
            popupWindowProductInfo.setTouchable(true);
            popupWindowProductInfo.setFocusable(true);
            popupWindowProductInfo.setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
            popupWindowProductInfo.setOutsideTouchable(true);
            popupWindowProductInfo.setAnimationStyle(R.style.popupWindowAnimation);


            /*mFrameLayoutFade.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    popupWindowProductInfo.dismiss();
                }
            });*/
            if (/*listProductInfo != null &&*/ listProductInfo.size() > 0) {
                // mFrameLayoutFade.setVisibility(View.VISIBLE);
                popupWindowProductInfo.showAtLocation(anchor, Gravity.NO_GRAVITY, xPos, yPos);
            }


            popupWindowProductInfo.setOnDismissListener(new PopupWindow.OnDismissListener() {
                @Override
                public void onDismiss() {
//                    mFrameLayoutFade.setVisibility(View.GONE);
//                    mTextViewInfoPdp.setText("+ INFO");
                }
            });

        } catch (Exception e) {
            Log.e("TAG", "showProductInfoWindow: Error", e);
        }
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn1:
                showProductInfoWindow(btn1);
                break;
            case R.id.btn2:
                showProductInfoWindow(btn2);
                break;
            case R.id.btn3:
                showProductInfoWindow(btn3);
                break;
            case R.id.btn4:
                showProductInfoWindow(btn4);
                break;
            case R.id.btn5:
                showProductInfoWindow(btn5);
                break;
            case R.id.btn6:
                showProductInfoWindow(btn6);
                break;

        }
    }
}
