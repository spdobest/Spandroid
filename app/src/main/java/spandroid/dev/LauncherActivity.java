package spandroid.dev;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.popupwindow.PopupWIndowActivity;

public class LauncherActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        startActivity(new Intent(LauncherActivity.this, PopupWIndowActivity.class));

    }
}
