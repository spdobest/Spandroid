package spandroid.dev.custom_widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatEditText;
import android.util.AttributeSet;

/**
 * Created by sibaprasad on 20/10/16.
 */
public class SpEdittext extends AppCompatEditText {

    private static Typeface helveticaBoldTypeface;

    public SpEdittext(Context context) {
        super(context);
        init();
    }

    public SpEdittext(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SpEdittext(Context context, AttributeSet attrs, int defStyleAttr) {
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
