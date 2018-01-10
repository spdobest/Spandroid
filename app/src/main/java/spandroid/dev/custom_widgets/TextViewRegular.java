package spandroid.dev.custom_widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

/**
 * Created by sibaprasad on 20/10/16.
 */
public class TextViewRegular extends AppCompatTextView {

    private static Typeface helveticaRegularTypeface;

    public TextViewRegular(Context context) {
        super(context);
        init();
    }

    public TextViewRegular(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public TextViewRegular(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        if (!isInEditMode()) {
            if (helveticaRegularTypeface == null) {
                helveticaRegularTypeface = Typeface.createFromAsset(getContext().getAssets(), "font/halvetica.ttf");
            }
            setTypeface(helveticaRegularTypeface);
        }
    }
}
