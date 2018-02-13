package spandroid.dev.animatedVectorDrawable;

import android.app.Activity;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import spandroid.dev.R;

public abstract class AnimatedImageActivity extends Activity {
    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        imageView = findViewById(R.id.image);
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animate();
            }
        });
    }

    private void animate() {
        Drawable drawable = imageView.getDrawable();
        if (drawable instanceof Animatable) {
            ((Animatable) drawable).start();
        }
    }

    protected abstract int getLayoutId();
}