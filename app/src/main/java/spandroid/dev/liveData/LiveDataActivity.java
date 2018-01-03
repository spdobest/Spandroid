package spandroid.dev.liveData;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;

public class LiveDataActivity extends AppCompatActivity {
    private static final String TAG = "LiveDataActivity";

    //https://code.tutsplus.com/tutorials/android-architecture-component-livedata--cms-29317
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
    }
}