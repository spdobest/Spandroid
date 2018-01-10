package spandroid.dev.custom_widgets;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * Created by sibaprasad on 20/10/16.
 */

public class SpCompatButton extends AppCompatButton {
    private static Typeface helveticaRegularTypeface;

    public SpCompatButton(Context context) {
        this(context, null);
        init();
    }

    public SpCompatButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
        init();
    }

    public SpCompatButton(Context context, AttributeSet attrs, int defStyleAttr) {
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
