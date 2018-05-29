package spandroid.dev.android8;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
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

        // https://developer.android.com/about/versions/oreo/android-8.0

        String noughtFeatures = "*<b> </b><br><br>" +
                "*<b>Picture-in-Picture mode </b> - for Multi window videos <br><br>" +
                "*<b>Notifications </b><br><br>" +
                "*<b>Autofill framework </b><br><br>" +
                "*<b>Downloadable fonts </b><br><br>" +
                "*<b>Fonts in XML </b><br><br>" +
                "*<b>Autosizing TextView </b><br><br>" +
                "*<b>Adaptive icons </b><br><br>" +
                "*<b>Color management </b><br><br>" +
                "*<b>WebView APIs</b><br><br>" +
                "*<b>Pinning shortcuts and widgets </b><br><br>" +
                "*<b>Maximum screen aspect ratio </b><br><br>" +
                "*<b>Multi-display support </b><br><br>" +
                "*<b> </b><br><br>" +
                "</b><br><br>";

        tvFeatures.setText(Html.fromHtml(noughtFeatures));
    }
}
