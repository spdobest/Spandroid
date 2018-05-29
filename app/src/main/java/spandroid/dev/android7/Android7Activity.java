package spandroid.dev.android7;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.Html;

import spandroid.dev.R;

public class Android7Activity extends AppCompatActivity {

    // Nought

    private AppCompatTextView tvFeatures;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android7);

        tvFeatures = findViewById(R.id.tvFeatures);

        String noughtFeatures = "*<b>Multi-window Support</b><br><br>" +
                "*<b>Profile-guided JIT/AOT Compilation</b><br><br>" +
                "*<b>Quick Path to App Install</b><br><br>" +
                "*<b>Doze on the Go</b><br><br>" +
                "*<b>Project Svelte: Background Optimizations</b><br><br>" +
                "*<b>Number Blocking</b><br><br>" +
                "*<b>Call Screening</b><br><br>" +
                "*<b>Multi-locale Support, More Languages</b><br><br>" +
                "*<b>New Emojis</b><br><br>" +
                "*<b>WebView - Chrome + WebView, Together</b><br><br>" +
                "*<b>Multiprocess</b><br><br>" +
                "</b><br><br>";

        tvFeatures.setText(Html.fromHtml(noughtFeatures));
    }
}
