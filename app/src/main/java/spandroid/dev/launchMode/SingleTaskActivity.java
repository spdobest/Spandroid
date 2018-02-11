package spandroid.dev.launchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;

public class SingleTaskActivity extends AppCompatActivity {
    /**
     * **********       SINGLE TASK   ********************
     * <p>
     * THis is quite different from singleTop and Standard
     * <p>
     * An Activity with singleTask LcunchMode is allowed to have only once instance int the system
     * <p>
     * If there is already a activity instance the whole task hold the instance would be moved to top
     * while intent would be delevered through onNewIntent() method
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_task);
    }
}
