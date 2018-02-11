package spandroid.dev.animation;

import android.animation.Animator;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewAnimationUtils;

import spandroid.dev.R;

public class CircularReavelAnimActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "CircularReavelAnimActiv";

    FloatingActionButton mFab;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circular_reavel_anim);

        mFab = findViewById(R.id.mFab);
        mFab.setOnClickListener(this);
    }


    /*
  create a new circular reaveal on the give view. This view is initially invisible. In this case the view covers full screen
*/
    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void createCircularReveal(final View view) {

        // to get the center of FAB
        int centerX = (int) mFab.getX() + mFab.getWidth() / 2;
        int centerY = (int) mFab.getY();
        float finalRadius = (float) Math.hypot(view.getWidth(), view.getHeight());
        // starts the effect at centerX, center Y and covers final radius
        Animator revealAnimator = ViewAnimationUtils.createCircularReveal(view,
                centerX, centerY, 0, finalRadius);
        view.setVisibility(View.VISIBLE);
        revealAnimator.start();

    }

/*
    hides the circular view
*/

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    private void hideCircularReveal(final View myView) {

        // get the center for the clipping circle
        int cx = (int) mFab.getX() + mFab.getWidth() / 2;
        int cy = (int) mFab.getY();


        // get the initial radius for the clipping circle
        float initialRadius = (float) Math.hypot(myView.getWidth(), myView.getHeight());

        // create the animation (the final radius is zero)
        Animator anim =
                ViewAnimationUtils.createCircularReveal(myView, cx, cy, initialRadius, 0);

        // make the view invisible when the animation is done
        anim.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                myView.setVisibility(View.INVISIBLE);

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
        // start the animation
        anim.start();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mFab:
                createCircularReveal(mFab);
                break;
        }
    }
}
