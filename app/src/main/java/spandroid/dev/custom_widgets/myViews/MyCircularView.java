package spandroid.dev.custom_widgets.myViews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.support.v4.content.ContextCompat;
import android.util.AttributeSet;
import android.view.View;

import spandroid.dev.R;

/**
 * Created by root on 7/20/18.
 */

public class MyCircularView extends View {

    private static final String TAG = "MyCircularView";

    private Paint paint;

    public MyCircularView(Context context) {
        super(context);
    }

    public MyCircularView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);



    }

    public MyCircularView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyCircularView(Context context, @Nullable AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public void draw(Canvas canvas) {
        super.draw(canvas);

        paint = new Paint();
        paint.setStyle(Paint.Style.FILL_AND_STROKE);
        paint.setAntiAlias(true);
     //   paint.setColor(ContextCompat.getColor(context, R.color.green));

        int middleX = this.getMeasuredHeight()/2;
        int middleY = this.getMeasuredWidth()/2;
        int radious = 20;

    }


}
