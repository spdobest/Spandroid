package spandroid.dev.custom_widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by sibaprasad on 20/10/16.
 */
public class TextViewBold extends AppCompatTextView {

    private static Typeface helveticaBoldTypeface;

    public TextViewBold(Context context) {
        super(context);
        init();
    }

    public TextViewBold(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewBold(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            if (helveticaBoldTypeface == null) {
                helveticaBoldTypeface = Typeface.createFromAsset(getContext().getAssets(), "font/HelveticaNeue_BoldExt.otf");
            }
            setTypeface(helveticaBoldTypeface);
        }
    }
}
