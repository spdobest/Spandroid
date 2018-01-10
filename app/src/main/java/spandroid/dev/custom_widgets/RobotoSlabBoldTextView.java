/*
 * Copyright (c) 2015, Craftsvilla Handicrafts Private Limited.
 * Written under contract by First Quadrant Labs Pvt. Ltd.
 */
package spandroid.dev.custom_widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class RobotoSlabBoldTextView extends TextView {

    private static Typeface robotoSlabBoldTypeface;

    public RobotoSlabBoldTextView(Context context) {
        super(context);
        init();
    }

    public RobotoSlabBoldTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RobotoSlabBoldTextView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            if (robotoSlabBoldTypeface == null) {
                robotoSlabBoldTypeface = Typeface.createFromAsset(getContext().getAssets(), "fonts/robotoslab_bold.ttf");
            }
            setTypeface(robotoSlabBoldTypeface);
        }
    }

}
