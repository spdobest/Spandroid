package spandroid.dev.launchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;

public class SingleTopActivity extends AppCompatActivity {
    /**
     * *************   SINGLE TOP    *****************
     * <p>
     * It almost act same as Standard
     * That means , The SIngleTop Activity instance could be created as many as we want
     * <p>
     * The only differenec is if there already is an Activity instancewith the same
     * type at the top of Stack in the called Task, there would not be any new activity created,
     * <p>
     * <p>
     * Instead an Intent will be sent to an existing Activity instance through
     * onNewIntent() method
     * <p>
     * In SIngleTop Activity we have to handle incoming Intent in both onCreate and onNewIntent to make
     * it works for all the casses
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_top);
    }
}
