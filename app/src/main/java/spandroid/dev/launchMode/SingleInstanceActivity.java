package spandroid.dev.launchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;

public class SingleInstanceActivity extends AppCompatActivity {

    /**
     * *******       SINGLEINSTANCE        *************
     * THis Mode is quite close to singleTask
     * Only SIngle Instance of Activity could be existed in the system
     * <p>
     * THe Difference is Task hold this Activity could have only one Activity, the SingleInstance One
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_single_instance);
    }
}
