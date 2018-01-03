package spandroid.dev.common;

import android.util.Log;

/**
 * Created by Sibaprasad on 20/10/16.
 */
public class Debug {

    private static boolean isDegugEnable = true;

    public static void showInfo(String msg){
        if(isDegugEnable)
            Log.i("APP",msg);
    }
    public static void showInfo(String tag, String msg){
        if(isDegugEnable)
            Log.i(tag,msg);
    }
}
