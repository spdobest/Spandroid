package spandroid.dev.common;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.location.LocationManager;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.StatFs;
import android.provider.MediaStore;
import android.support.design.widget.Snackbar;
import android.text.format.Formatter;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.view.WindowManager;


import org.json.JSONObject;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import spandroid.dev.R;

/**
 * Created by Sibaprasad on 20/10/16.
 */

public class Utility {

    public static String getTag(Object obj){
        return obj.getClass().getSimpleName();
    }

    public static void showSnackBarMessage(View view, String message){
        Snackbar snackbar = Snackbar.make(view,message, Snackbar.LENGTH_LONG);
        snackbar.getView().setBackgroundColor(Color.parseColor("#F28322"));
        snackbar.setActionTextColor(Color.WHITE);
        snackbar.show();
    }
    private static final int BUFFER = 80000;

    static InputStream is = null;
    static JSONObject jObj = null;
    static String json = "";

    private static final Pattern WEB_URL_PATTERN = Patterns.WEB_URL;
    public static int responsecode;
    public static Boolean nullJson = false;
    private static final Pattern PHONE_PATTERN = Patterns.PHONE;

    /*****************************IS INTERNET AVAILABLE***************************************/

    public static boolean isInternetAvailable(Context context) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager)context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }
    /*****************************IS EMAIL ID VALID***************************************/
    public static boolean isEmailValid(String email) {
        boolean isValid = false;

        String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
        CharSequence inputStr = email;

        Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(inputStr);
        if (matcher.matches()) {
            isValid = true;
        }
        return isValid;
    }
    /*****************************IS GPS AVAILABLE***************************************/
    public static void isGPSEnable(Context context){
        LocationManager lm = null;
        boolean gps_enabled = false,network_enabled = false;
        if(lm==null)
            lm = (LocationManager) context.getSystemService(Context.LOCATION_SERVICE);
        try{
            gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
        }catch(Exception ex){}
        try{
            network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
        }catch(Exception ex){}

        if(!gps_enabled && !network_enabled){
            AlertDialog.Builder dialog = new AlertDialog.Builder(context);
            dialog.setMessage(/*context.getResources().getString(R.string.gps_network_not_enabled)*/"");
            dialog.setPositiveButton(/*context.getResources().getString(R.string.open_location_settings)*/"Yes", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // do the task
                }
            });
            dialog.setNegativeButton(/*context.getString(R.string.Cancel)*/"No", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface paramDialogInterface, int paramInt) {
                    // do the task
                }
            });
            dialog.show();
        }
    }
    /*****************************IS MOBILE NUMBER VALID***************************************/
    public static boolean isMobileValid(String mobileno){

        if(mobileno.length()==10 && mobileno.substring(0,2).contains("7") && mobileno.substring(0,2).contains("8") && mobileno.substring(0,2).contains("9"))
            return true;
        else
            return false;
    }
    /*****************************IS WEB URL VALID***************************************/
    public static boolean isValidUrl(String url) {

        return WEB_URL_PATTERN.matcher(url).matches();
    }
    /*****************************IS PHONE VALID***************************************/
    public static boolean isValidPhone(String phone) {

        return PHONE_PATTERN.matcher(phone).matches();
    }
    /*****************************IS FILE EXIST***************************************/
    public static boolean isFileExist(String filePath){
        boolean exist = false;
        File file = new File(filePath);
        if(file.exists())
            exist = true;
        else
            exist = false;

        return exist;
    }
    /*****************************CONVERT BYTE ARRAY TO BITMAP***************************************/
    public Bitmap ByteArrayToBitmap(byte[] byteArray) {

        ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(
                byteArray);
        Bitmap bitmap = BitmapFactory.decodeStream(arrayInputStream);
        Bitmap bitmapScaled = Bitmap.createScaledBitmap(bitmap, 100, 80, true);
        final BitmapFactory.Options options = new BitmapFactory.Options();
        // Bitmap bitmap123 = BitmapFactory.decodeByteArray(byteArray, 0,
        // byteArray.length);

        return bitmapScaled;
    }
    /*****************************CONVERT PATH TO BYTE ARRAY***************************************/
//get the image in byte
    public byte[] getImageInByte(String path) {
        File imagefile = new File(path);
        FileInputStream fis = null;
        try {
            fis = new FileInputStream(imagefile);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("length is " + imagefile.length());
        byte[] bFile = new byte[(int) imagefile.length()];
        Bitmap bm = BitmapFactory.decodeStream(fis);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bm.compress(Bitmap.CompressFormat.JPEG, 80, baos);
        byte[] b = baos.toByteArray();
        return b;
    }
    /*****************************SCALLED BITMAP IMAGE***************************************/
    public static Bitmap scaleDown(Bitmap realImage, float maxImageSize,
                                   boolean filter) {
        float ratio = Math.min(
                (float) maxImageSize / realImage.getWidth(),
                (float) maxImageSize / realImage.getHeight());
        int width = Math.round((float) ratio * realImage.getWidth());
        int height = Math.round((float) ratio * realImage.getHeight());

        Bitmap newBitmap = Bitmap.createScaledBitmap(realImage, width,
                height, filter);
        return newBitmap;
    }

    /*****************************SCALLED BITMAP IMAGE ANOTHER WAY***************************************/
    public static Bitmap scaleDown(Bitmap yourBitmap, int newWidth, int newHeight) {
        Bitmap resized = Bitmap.createScaledBitmap(yourBitmap, newWidth, newHeight, true);
        return resized;
    }
    /***************************get real path from image URI ****************************/
    public static String getPath(Context context, Uri uri)
    {
        Cursor cursor = context.getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }
    /************CALCULATE THE IMAGE SAMPLE SIZE to scale***********/
    public static int calculateInSampleSize(
            BitmapFactory.Options options, int reqWidth, int reqHeight) {
        // Raw height and width of image
        final int height = options.outHeight;
        final int width = options.outWidth;
        int inSampleSize = 2;

        if (height > reqHeight || width > reqWidth) {
            if (width > height) {
                inSampleSize = Math.round((float)height / (float)reqHeight);
            } else {
                inSampleSize = Math.round((float)width / (float)reqWidth);
            }
        }
        return inSampleSize;
    }
    /***************GET BITMAP FROM IMAHE URI *********************/
    public static Bitmap getBitMapFromUri(Context context, Uri uri){
        Bitmap bmp = null;
        try {
            bmp = BitmapFactory.decodeStream(context.getContentResolver().openInputStream(uri));
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return bmp;
    }
    /**********************GET BITMAP IMAGE FROM URL *************************/
    public static Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    /*****************************SAVE IMAGE URL TO SD CARD ************************/
    public static String saveImageToSdcard(Context context, String image_url){

        String imagepath = Environment.getExternalStorageDirectory()+"/"+"localFileName.jpg";

        URL wallpaperURL;
        try {
            wallpaperURL = new URL(image_url);
            URLConnection connection = wallpaperURL.openConnection();
            InputStream inputStream = new BufferedInputStream(wallpaperURL.openStream(), 10240);

            File cacheFile = new File(Environment.getExternalStorageDirectory(), "localFileName.jpg");

            FileOutputStream outputStream = new FileOutputStream(cacheFile);

            byte buffer[] = new byte[1024];

            int dataSize;

            int loadedSize = 0;

            while ((dataSize = inputStream.read(buffer)) != -1) {
                loadedSize += dataSize;
                outputStream.write(buffer, 0, dataSize);
            }
            outputStream.close();

        } catch (MalformedURLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return imagepath;
    }
    /****************************DOWNLOAD FILE FROM SERVER URL ****************************/
    public static void getFileFromUrl(Context context, String file_url){
        try {
            //set the download URL, a url that points to a file on the internet
            //this is the file to be downloaded
            URL url = new URL(file_url);

            //create the new connection
            HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();

            //set up some things on the connection
            urlConnection.setRequestMethod("GET");
            urlConnection.setDoOutput(true);

            //and connect!
            urlConnection.connect();

            //set the path where we want to save the file
            //in this case, going to save it on the root directory of the
            //sd card.
            File SDCardRoot = Environment.getExternalStorageDirectory();
            //create a new file, specifying the path, and the filename
            //which we want to save the file as.
            File file = new File(SDCardRoot,"somefile.ext");

            //this will be used to write the downloaded data into the file we created
            FileOutputStream fileOutput = new FileOutputStream(file);

            //this will be used in reading the data from the internet
            InputStream inputStream = urlConnection.getInputStream();

            //this is the total size of the file
            int totalSize = urlConnection.getContentLength();
            //variable to store total downloaded bytes
            int downloadedSize = 0;

            //create a buffer...
            byte[] buffer = new byte[1024];
            int bufferLength = 0; //used to store a temporary size of the buffer

            //now, read through the input buffer and write the contents to the file
            while ( (bufferLength = inputStream.read(buffer)) > 0 ) {
                //add the data in the buffer to the file in the file output stream (the file on the sd card
                fileOutput.write(buffer, 0, bufferLength);
                //add up the size so we know how much is downloaded
                downloadedSize += bufferLength;
                //this is where you would do something to report the prgress, like this maybe
//		                updateProgress(downloadedSize, totalSize);

            }
            //close the output stream when done
            fileOutput.close();

            //catch some possible errors...
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    /*****************************GET SCREEN TYPE***************************************/
    public static String getScreenType(Activity context){

        String screenType = "";

        DisplayMetrics dm = new DisplayMetrics();
        context.getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels; //320 dip
        int height = dm.heightPixels; //533 dip

        int widthPix = (int) Math.ceil(dm.widthPixels * (dm.densityDpi / 160.0));
        if(widthPix == 320)
            screenType = "small";
        else if(widthPix == 480)
            screenType = "normal";
        else if(widthPix == 800)
            screenType = "large";
        else if(widthPix == 1000)
            screenType = "xlarge";

        return screenType;
    }
    /*****************************GET THE DEVICE VERSION***************************************/
    public static int getDeviceVersion(){
        int currentapiVersion = Build.VERSION.SDK_INT;

        return currentapiVersion;
    }
    /*****************************OPEN YOUR PUBLISHED APP IN PLAYSTORE***************************************/
    public static void openApplicationInPlaystore(Context context){
        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
        try {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            context.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }
    /*****************************GET UR PUBLISHED APP URL***************************************/
    public static String getPlaystoreUrl(Context context){

        String playstore_url = "";

        final String appPackageName = context.getPackageName(); // getPackageName() from Context or Activity object
        playstore_url =  "market://details?id="+ appPackageName;

        return playstore_url;
    }
    /*****************************GET APPLICATION VERSION ***************************************/
    public static String getApplicationVersion(Context context){
        String version = "";
        PackageInfo pInfo;
        try {
            pInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
            version = pInfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return version;
    }
    /*****************************ENSRIPT AND DECRIPT ***************************************/
/*  public class AESCrypt {

	  private final Cipher cipher;
	  private final SecretKeySpec key;
	  private AlgorithmParameterSpec spec;


	  public AESCrypt(String password) throws Exception
	  {
	      // hash password with SHA-256 and crop the output to 128-bit for key
	      MessageDigest digest = MessageDigest.getInstance("SHA-256");
	      digest.update(password.getBytes("UTF-8"));
	      byte[] keyBytes = new byte[32];
	      System.arraycopy(digest.digest(), 0, keyBytes, 0, keyBytes.length);

	      cipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
	      key = new SecretKeySpec(keyBytes, "AES");
	      spec = getIV();
	  }

	  public AlgorithmParameterSpec getIV()
	  {
	      byte[] iv = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, };
	      IvParameterSpec ivParameterSpec;
	      ivParameterSpec = new IvParameterSpec(iv);

	      return ivParameterSpec;
	  }

	  public String encrypt(String plainText) throws Exception
	  {
	      cipher.init(Cipher.ENCRYPT_MODE, key, spec);
	      byte[] encrypted = cipher.doFinal(plainText.getBytes("UTF-8"));
	      String encryptedText = new String(Base64.encode(encrypted, Base64.DEFAULT), "UTF-8");

	      return encryptedText;
	  }

	  public String decrypt(String cryptedText) throws Exception
	  {
	      cipher.init(Cipher.DECRYPT_MODE, key, spec);
	      byte[] bytes = Base64.decode(cryptedText, Base64.DEFAULT);
	      byte[] decrypted = cipher.doFinal(bytes);
	      String decryptedText = new String(decrypted, "UTF-8");

	      return decryptedText;
	  }}*/

    public static void showAlertDialog(Context context, String Title, String Message){
        final AlertDialog alertDialog = new AlertDialog.Builder(
                context).create();

// Setting Dialog Title
        alertDialog.setTitle(Title);

// Setting Dialog Message
        alertDialog.setMessage(Message);

// Setting Icon to Dialog
        alertDialog.setIcon( R.mipmap.ic_launcher);

// Setting OK Button
        alertDialog.setButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int which) {
                alertDialog.cancel();
            }
        });

// Showing Alert Message
        alertDialog.show();
    }
    public static String convertMilliSecondToTime(long milli){
        String tim = "";
        tim =   String.format("%02d:%02d:%02d",
                TimeUnit.MILLISECONDS.toHours(milli),
                TimeUnit.MILLISECONDS.toMinutes(milli) -
                        TimeUnit.HOURS.toMinutes(TimeUnit.MILLISECONDS.toHours(milli)), // The change is in this line
                TimeUnit.MILLISECONDS.toSeconds(milli) -
                        TimeUnit.MINUTES.toSeconds(TimeUnit.MILLISECONDS.toMinutes(milli)));

        return tim;
    }

    /**
     *
     * @param is
     * @return String
     */
    public static String convertStreamToString(InputStream is) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(is));
        StringBuilder sb = new StringBuilder();

        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return sb.toString();
    }
    /******************************** UNZIP THE ZIPP FILE*******************/
    public static void zip(String[] _files, String zipFileName) {
        try {
            BufferedInputStream origin = null;
            FileOutputStream dest = new FileOutputStream(zipFileName);
            ZipOutputStream out = new ZipOutputStream(new BufferedOutputStream(
                    dest));
            byte data[] = new byte[BUFFER];

            for (int i = 0; i < _files.length; i++) {
                Log.v("Compress", "Adding: " + _files[i]);
                FileInputStream fi = new FileInputStream(_files[i]);
                origin = new BufferedInputStream(fi, BUFFER);

                ZipEntry entry = new ZipEntry(_files[i].substring(_files[i]
                        .lastIndexOf("/") + 1));
                out.putNextEntry(entry);
                int count;

                while ((count = origin.read(data, 0, BUFFER)) != -1) {
                    out.write(data, 0, count);
                }
                origin.close();
            }
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void unzip(String _zipFile, String _targetLocation) {

        // create target location folder if not exist
        dirChecker(_targetLocation);

        try {
            FileInputStream fin = new FileInputStream(_zipFile);
            ZipInputStream zin = new ZipInputStream(fin);
            ZipEntry ze = null;
            while ((ze = zin.getNextEntry()) != null) {

                // create dir if required while unzipping
                if (ze.isDirectory()) {
                    dirChecker(ze.getName());
                } else {
                    FileOutputStream fout = new FileOutputStream(
                            _targetLocation + "/" + ze.getName());
                    BufferedOutputStream bufout = new BufferedOutputStream(fout);
                    byte[] buffer = new byte[1024];
                    int read = 0;
                    while ((read = zin.read(buffer)) != -1) {
                        bufout.write(buffer, 0, read);
                    }

                    zin.closeEntry();
                    bufout.close();
                    fout.close();
                }
            }
            zin.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void dirChecker(String dir) {
        File f = new File(dir);
        if (!f.isDirectory()) {
            f.mkdirs();
        }
    }

    public static void downloadFileFromUrl(Context context, String file_url){
        int count;
        try {

            URL url = new URL(file_url);
            URLConnection conexion = url.openConnection();
            conexion.connect();
            int lenghtOfFile = conexion.getContentLength();
            Log.d("ANDRO_ASYNC", "Lenght of file: " + lenghtOfFile);

            InputStream input = new BufferedInputStream(url.openStream());

            String directory_name = null;

            String STORAGE_PATH = Environment.getExternalStorageDirectory()
                    .getAbsolutePath() + "/" + directory_name;

            File cacheDirectory = context.getFilesDir();
            STORAGE_PATH = cacheDirectory.getAbsolutePath()+"/"+directory_name;

            System.out.println("storage path is " + STORAGE_PATH);

            OutputStream output = new FileOutputStream(STORAGE_PATH);

            byte data[] = new byte[1024];

            long total = 0;

            while ((count = input.read(data)) != -1) {
                total += count;
//				publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                output.write(data, 0, count);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
        }
    }

    public static void getAssetFiles(Context context){

        AssetManager assetManager = context.getAssets();

        try {
            String[] files = assetManager.list("Files");

        } catch (IOException e1) {
            e1.printStackTrace();

        } }
    public static String getTextFromTextFile(Context context, String path){
        String content = "";
        InputStream inputStream = null;
        AssetManager assetManager = context.getAssets();
        try {
            inputStream = assetManager.open("helloworld.txt");
            int size = inputStream.available();
            byte[] buffer = new byte[size];
            inputStream.read(buffer);
            inputStream.close();
            content = new String(buffer);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return content;
    }

    public static String getAvailableInternalMemory(Context context){

        File path = Environment.getDataDirectory();
        StatFs stat = new StatFs(path.getPath());
        long blockSize = stat.getBlockSize();
        long availableBlocks = stat.getAvailableBlocks();
        return Formatter.formatFileSize(context, availableBlocks * blockSize);
    }
    public static String getEmail(Context context) {
        AccountManager accountManager = AccountManager.get(context);
        Account account = getAccount(accountManager);

        if (account == null) {
            return null;
        } else {
            return account.name;
        }
    }

    public static Account getAccount(AccountManager accountManager) {
        Account[] accounts = accountManager.getAccountsByType("com.google");
        Account account;
        if (accounts.length > 0) {
            account = accounts[0];
        } else {
            account = null;
        }
        return account;
    }
    public static String getUsername(Context context) {
        AccountManager manager = AccountManager.get(context);
        Account[] accounts = manager.getAccountsByType("com.google");
        List<String> possibleEmails = new LinkedList<String>();

        for (Account account : accounts) {
            // TODO: Check possibleEmail against an email regex or treat
            // account.name as an email address only for certain account.type values.
            possibleEmails.add(account.name);
        }

        if (!possibleEmails.isEmpty() && possibleEmails.get(0) != null) {
            String email = possibleEmails.get(0);
            String[] parts = email.split("@");

            if (parts.length > 1)
                return parts[0];
        }
        return null;
    }
    /******************get Device name***********/
    public static String getDeviceName() {
        String manufacturer = Build.MANUFACTURER;
        String model = Build.MODEL;
        if (model.startsWith(manufacturer)) {
            return capitalize(model);
        } else {
            return capitalize(manufacturer) + " " + model;
        }
    }

    private static String capitalize(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        char first = s.charAt(0);
        if (Character.isUpperCase(first)) {
            return s;
        } else {
            return Character.toUpperCase(first) + s.substring(1);
        }
    }
    private static String getRealPathFromURI(Activity activity, Uri contentURI) {
        String result;
        Cursor cursor = activity.getContentResolver().query(contentURI, null,
                null, null, null);

        if (cursor == null) { // Source is Dropbox or other similar local file
            // path
            result = contentURI.getPath();
        } else {
            cursor.moveToFirst();
            int idx = cursor
                    .getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            result = cursor.getString(idx);
            cursor.close();
        }
        return result;
    }

    public static boolean checkVersion(){
        int currentapiVersion = Build.VERSION.SDK_INT;
        if (currentapiVersion >= Build.VERSION_CODES.LOLLIPOP){
            // Do something for lollipop and above versions
        } else{
            // do something for phones running an SDK before lollipop
        }
        return true;
    }

    public static void shareMessage(Context mContext, String title, String message, String msgExtra){
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_SUBJECT, "NEWS");
        sendIntent.putExtra(Intent.EXTRA_TEXT,title +":\n\n"+"TITLE"+"=========================\n"+message +"\n\n Description  : \n"+"=========================\n"+msgExtra +"\n\n "+"http://play.google.com/store/apps/details?id="+mContext.getPackageName());
        sendIntent.setType("text/plain");
        mContext.startActivity(sendIntent);
    }
	public static void setStatusBarColorIfPossible(Activity context,int color) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
			context.getWindow().addFlags( WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			context.getWindow().setStatusBarColor(color);
		}
	}
}
