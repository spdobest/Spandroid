package spandroid.dev.base;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spandroid.dev.R;
import spandroid.dev.base.kotlin.KotlinBaseActivity;

public class BaseChildActivity extends KotlinBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayout(R.layout.activity_base_child);
        initDrawer();

       // setContentView(R.layout.activity_base_child);
    }
}
