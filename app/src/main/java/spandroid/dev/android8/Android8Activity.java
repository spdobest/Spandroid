package spandroid.dev.android8;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;

import spandroid.dev.R;

public class Android8Activity extends AppCompatActivity {


    // Nought

    private AppCompatTextView tvFeatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android7);

        tvFeatures = findViewById(R.id.tvFeatures);

        String noughtFeatures = "*<b> </b><br><br>" +
                "*<b>Picture-in-Picture mode </b> - for Multi window videos <br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "*<b> </b><br><br>" +
                "</b><br><br>";

        tvFeatures.setText(Html.fromHtml(noughtFeatures));
    }
}
