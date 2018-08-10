package spandroid.dev.security.facebookConcealEncryption;

import android.security.KeyChain;
import android.security.KeyChainException;
import android.util.Base64;

import com.facebook.crypto.CryptoConfig;
import com.facebook.crypto.Entity;
import com.facebook.crypto.exception.CryptoInitializationException;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * Created by root on 8/10/18.
 */

public class FacebookCOncealUtils {

   /* KeyChain keyChain = new SharedPrefsBackedKeyChain(context, CryptoConfig.KEY_256);
    Cricrypto = AndroidConceal.get().createDefaultCrypto(keyChain);

    public static String encrypt(String key, String value) throws KeyChainException, CryptoInitializationException, IOException {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        OutputStream cryptoStream = crypto.getCipherOutputStream(bout, Entity.create(key));
        cryptoStream.write(value.getBytes("UTF-8"));
        cryptoStream.close();
        String result = Base64.encodeToString(bout.toByteArray(), Base64.DEFAULT);
        bout.close();
        return result;
    }

    public static String decrypt(String key, String value) throws KeyChainException, CryptoInitializationException, IOException {
        ByteArrayInputStream bin = new ByteArrayInputStream(Base64.decode(value, Base64.DEFAULT));
        InputStream cryptoStream = crypto.getCipherInputStream(bin, Entity.create(key));
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        int read = 0;
        byte[] buffer = new byte[1024];
        while ((read = cryptoStream.read(buffer)) != -1) {
            bout.write(buffer, 0, read);
        }
        cryptoStream.close();
        String result = new String(bout.toByteArray(), "UTF-8");
        bin.close();
        bout.close();
        return result;
    }*/
}
