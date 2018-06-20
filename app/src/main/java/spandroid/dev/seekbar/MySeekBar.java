package spandroid.dev.seekbar;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.AppCompatSeekBar;
import android.util.AttributeSet;

public class MySeekBar extends AppCompatSeekBar {

public MySeekBar(Context context, AttributeSet attrs) {
super(context, attrs);
// TODO Auto-generated constructor stub
}

Drawable mThumb;

@Override
public void setThumb(Drawable thumb) {
super.setThumb(thumb);
mThumb = thumb;
}

public Drawable getSeekBarThumb() {
return mThumb;
}
}