package spandroid.dev.seekbar;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSeekBar;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import spandroid.dev.R;

public class SeekbarActivity extends AppCompatActivity {

    private MySeekBar bar;
    private TextView textView;
    private LinearLayout relativeLayoutSeekbarRoot;
    private int oldLocation = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_seekbar);
        relativeLayoutSeekbarRoot = findViewById(R.id.relativeLayoutSeekbarRoot);
        bar = (MySeekBar) findViewById(R.id.seekbar);
        textView = (TextView) findViewById(R.id.tvRange);

        bar.incrementProgressBy(1);
        bar.setMax(50);
        bar.setProgress(5);

        bar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                LinearLayout.LayoutParams p = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.WRAP_CONTENT,
                        LinearLayout.LayoutParams.WRAP_CONTENT);

               // p.addRule(RelativeLayout.BELOW, seekBar.getId());
                Rect thumbRect =bar.getSeekBarThumb().getBounds();
                p.setMargins(
                        thumbRect.centerX()-19,0, 0, 0);
                textView.setLayoutParams(p);
                textView.setText((float)seekBar.getProgress()/2 +"");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}