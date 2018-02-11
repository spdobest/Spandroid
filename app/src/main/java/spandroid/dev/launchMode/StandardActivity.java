package spandroid.dev.launchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;

public class StandardActivity extends AppCompatActivity {
    /**
     * **************     STANDARD     *******************
     * This kind of activity would be created and placed on TOP of Stack in the same task as
     * one that sent an intent
     * Same Activity with multiple stack will be created
     * <p>
     * <p>
     * if the Activity is open from different Application and
     * the Device is lolipop
     * An intent will sent from different application
     * .New task will be created and the newly created Activity will be placed
     * as Root activity
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standard);
    }
}
