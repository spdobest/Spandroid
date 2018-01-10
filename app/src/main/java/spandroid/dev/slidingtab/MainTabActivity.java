package spandroid.dev.slidingtab;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;


/**
 * Created by Venkatesh on 3/31/16.
 */
public class MainTabActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sliding_tab);

        setUpFragment();
    }

    void setUpFragment() {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        SlidingFragment fragment = new SlidingFragment();
        transaction.replace(R.id.sample_content_fragment, fragment);
        transaction.commit();
    }
}
