package spandroid.dev.others;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;
import android.widget.TextView;

import spandroid.dev.R;
import spandroid.dev.custom_widgets.JustifiedTextView;

/**
 * Created by Venkatesh on 3/17/16.
 */
public class TextAlignActivity extends AppCompatActivity {
    JustifiedTextView textView;

    TextView tvAl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_alignment);

/*        tvAl = (TextView)findViewById(R.id.tvAL);

        String ss = "This is good solution for views that won't require memory wise use, for example its not good idea using a webview(this) inside listview it will consume a lot of memory and your app will response a litle slow than using textview.";

        textView = (JustifiedTextView)findViewById(R.id.tvAlign);
        textView.setText(ss + "   " + ss + "          " + ss);
        textView.setTextColor(Color.BLACK);
        textView.setTextSize(20);

        tvAl.setText(ss + "   " + ss );*/

        String htmlText = "<html><body style=\"text-align:justify\"> %s </body></Html>";
        String myData = " <p><b>This text is bold</b>.</p> Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView. \n Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView. \n Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView.       Hello World! This tutorial is to show demo of displaying text with justify alignment in WebView. <h2>HTML <mark>Marked</mark> Formatting</h2> ";

        String myData1 = myData + myData + myData + myData;
        WebView webView = findViewById(R.id.webview);
        webView.loadData(String.format(htmlText, myData1), "text/html", "utf-8");

    }
}
