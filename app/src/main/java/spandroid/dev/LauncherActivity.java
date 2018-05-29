package spandroid.dev;

import android.content.Intent;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.graphics.drawable.Icon;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;

import java.util.Arrays;

import spandroid.dev.popupwindow.PopupWIndowActivity;
import spandroid.dev.utils.OsVersionUtility;

public class LauncherActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_launcher);

        startActivity(new Intent(LauncherActivity.this, PopupWIndowActivity.class));


        if (OsVersionUtility.Companion.isNought()) {
            ShortcutManager shortcutManager = getSystemService(ShortcutManager.class);

            ShortcutInfo shortcut = new ShortcutInfo.Builder(this, "id1")
                    .setShortLabel("Web site")
                    .setLongLabel("Open the web site")
                    .setIcon(Icon.createWithResource(this, R.drawable.arrow_left))
                    .setIntent(new Intent(Intent.ACTION_VIEW,
                            Uri.parse("https://www.mysite.example.com/")))
                    .build();

            shortcutManager.setDynamicShortcuts(Arrays.asList(shortcut));
        }
    }
}
