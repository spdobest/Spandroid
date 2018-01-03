package spandroid.dev.designPartern.observer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import spandroid.dev.R;

public class ObservableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_observable);
    }
}
