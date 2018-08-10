package spandroid.dev.security.base64Encryption;

import android.util.Base64;

/**
 * Created by root on 8/10/18.
 */

public class Base64Utils {
    public static String encryptData(String data){
        byte[] dataArray = data.getBytes();
        return Base64.encodeToString(dataArray, Base64.DEFAULT);
    }

    public static String decryptData(String data){
        byte[] dataArray = data.getBytes();
        return Base64.encodeToString(dataArray, Base64.DEFAULT);
    }
}
