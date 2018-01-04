package spandroid.dev.launchMode;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spandroid.dev.R;

public class LaunchModeActivity extends AppCompatActivity {

    // https://inthecheesefactory.com/blog/understand-android-activity-launchmode/en
// https://blog.mindorks.com/android-activity-launchmode-explained-cbc6cf996802

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launch_mode);
    }
}
