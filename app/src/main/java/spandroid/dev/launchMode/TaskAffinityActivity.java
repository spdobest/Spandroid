package spandroid.dev.launchMode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import spandroid.dev.R;

public class TaskAffinityActivity extends AppCompatActivity {

    /**
     * **********      TASK AFFINITY   *************
     * <p>
     * THis type of lunch mode, another Process will be created with another Stack in System Tray
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_affinity);
    }
}
