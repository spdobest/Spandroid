package spandroid.dev.security;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * Created by root on 8/10/18.
 */

public class FileENcryptionUtils {

    byte[] key, iv;

    private static byte[] getKey() {
        KeyGenerator keyGen;

        byte[] dataKey = null;

        try {
            // Generate 256-bit key
            keyGen = KeyGenerator.getInstance("AES");
            keyGen.init(256);
            SecretKey secretKey = keyGen.generateKey();
            dataKey = secretKey.getEncoded();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return dataKey;
    }

    private static byte[] getIV() {
        SecureRandom random = new SecureRandom();
        byte[] iv = random.generateSeed(16);
        return iv;
    }

    public void encryptFile() {

        Bitmap bitmap = BitmapFactory.decodeFile(Environment.getExternalStorageDirectory() + "/img.png");

        // Write image data to ByteArrayOutputStream
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
        // Encrypt and save the image
        saveFile(encrypt(key, baos.toByteArray()), "enimg.png");
    }

    public void decryptFile() {
        try {
            // Create FileInputStream to read from the encrypted image file
            FileInputStream fis = new FileInputStream(Environment.getExternalStorageDirectory() + "/enimg.png");
            // Save the decrypted image
            saveFile(decrypt(key, fis), "deimg.png");
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    public void saveFile(byte[] data, String outFileName) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + outFileName);
            fos.write(data);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();

            }
        }
    }

    private byte[] encrypt(byte[] skey, byte[] data) {

        SecretKeySpec skeySpec = new SecretKeySpec(skey, "AES");

        Cipher cipher;

        byte[] encrypted = null;

        try {
            // Get Cipher instance for AES algorithm
            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            // Initialize cipher
            cipher.init(Cipher.ENCRYPT_MODE, skeySpec, new IvParameterSpec(iv));
            // Encrypt the image byte data
            encrypted = cipher.doFinal(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return encrypted;
    }

    private byte[] decrypt(byte[] skey, FileInputStream fis) {

        SecretKeySpec skeySpec = new SecretKeySpec(skey, "AES");

        Cipher cipher;

        byte[] decryptedData = null;

        CipherInputStream cis = null;

        try {

            cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");

            cipher.init(Cipher.DECRYPT_MODE, skeySpec, new IvParameterSpec(iv));

            // Create CipherInputStream to read and decrypt the image data

            cis = new CipherInputStream(fis, cipher);
            // Write encrypted image data to ByteArrayOutputStream
            ByteArrayOutputStream buffer = new ByteArrayOutputStream();

            byte[] data = new byte[2048];

            while ((cis.read(data)) != -1) {
                buffer.write(data);
            }
            buffer.flush();
            decryptedData = buffer.toByteArray();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {

            try {
                fis.close();
                cis.close();

            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return decryptedData;
    }
}
