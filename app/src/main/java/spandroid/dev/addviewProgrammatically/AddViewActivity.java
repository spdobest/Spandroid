package spandroid.dev.addViewProgrammatically;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;

import spandroid.dev.R;

public class AddViewActivity extends AppCompatActivity {

    LinearLayout llRoot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);

        llRoot = findViewById(R.id.llRoot);



    }
}
