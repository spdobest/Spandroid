package spandroid.dev.utils;

import android.Manifest;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatTextView;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import spandroid.dev.R;

import static android.Manifest.permission.CAMERA;
import static android.Manifest.permission.READ_EXTERNAL_STORAGE;

public class ImagePickerManager extends AppCompatActivity {

    public static final int REQUEST_CAMERA = 100;
    public static final int REQUEST_GALLERY = 101;
    public static final String IMAGE_PICKER_TYPE = "imagePickerType";
    public static final String IMAGE_CROP_SIZE = "imageCropSize";
    /**
     * Runtime Permission
     *
     * @param
     */
    public static final int RequestPermissionCode = 7;
    private static final String TAG = "ImagePickerManager";
    private static final int REQUEST_CROP = 103;
    private static final int PERMISSIONS_REQUEST_CAMERA_STORAGE = 123;
    LinearLayout llRootImagePickerManager;
    private BottomSheetDialog imagePickerBottomSheet;
    private Uri mImageCaptureUri;
    private Uri mSelectedImageUri;
    private int mSize = 300;
    private String pictureImagePath = "";
    private int mPickFrom = -1;
    private String selectedImagePath = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.manager_imagepicker);
        super.onCreate(savedInstanceState);
        llRootImagePickerManager = findViewById(R.id.llRootImagePickerManager);
        if (getIntent() != null) {

            if (getIntent().hasExtra(IMAGE_PICKER_TYPE)) {
                mPickFrom = getIntent().getIntExtra(IMAGE_PICKER_TYPE, REQUEST_GALLERY);
            }
            if (getIntent().hasExtra(IMAGE_CROP_SIZE)) {
                mSize = getIntent().getIntExtra(IMAGE_CROP_SIZE, 300);
            }
        }

        /**
         * Open camera or gallery as per selected option
         */
        if (mPickFrom == -1) {
            showBottomSheetDialog();
        } else {
            openCameraAndGallery(mPickFrom);
        }
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {

        } else {

        }*/


    }

    private void startCamera() {
        File file = new File(Environment.getExternalStorageDirectory(), "tmp_avatar1.jpg");
        mImageCaptureUri = FileProvider.getUriForFile(getApplicationContext(), getApplicationContext().getPackageName() + ".sp.memeCreator", file);
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        intent.putExtra(MediaStore.EXTRA_OUTPUT, mImageCaptureUri);
        startActivityForResult(intent, REQUEST_CAMERA);
    }

    void openGallery() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_PICK);
        startActivityForResult(Intent.createChooser(intent, "Complete action using"), REQUEST_GALLERY);
    }

    private void doCrop() {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setType("image/*");
        List<ResolveInfo> list = getPackageManager().queryIntentActivities(intent, 0);
        int size = list.size();
        if (size == 0) {
            Toast.makeText(this, "Can not find image crop application installed", Toast.LENGTH_SHORT).show();
            finish();
            return;
        } else {
            intent.setData(mImageCaptureUri);
            intent.putExtra("outputX", mSize);
            intent.putExtra("outputY", mSize);
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("scale", true);
            intent.putExtra("return-data", true);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, mSelectedImageUri);
            Intent i = new Intent(intent);
            ResolveInfo res = list.get(0);
            i.setComponent(new ComponentName(res.activityInfo.packageName, res.activityInfo.name));
            startActivityForResult(i, REQUEST_CROP);
        }
    }


    public void openCamera() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        String imageFileName = "myPicture" + ".jpg";
        File storageDir = Environment.getExternalStoragePublicDirectory(
                Environment.DIRECTORY_PICTURES);
        pictureImagePath = storageDir.getAbsolutePath() + "/" + imageFileName;
        File file = new File(pictureImagePath);

        if (file.exists()) {
            file.delete();
        }

        file = new File(pictureImagePath);

        Uri outputFileUri = FileProvider.getUriForFile(this, getApplicationContext().getPackageName() + ".provider", file);
        // Uri outputFileUri = Uri.fromFile(file);
        takePictureIntent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);

        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_CAMERA);
        }
    }

    /**
     * showing bottom sheet dialog
     */
    public void showBottomSheetDialog() {

        imagePickerBottomSheet = new BottomSheetDialog(this);

        View view = getLayoutInflater().inflate(R.layout.bottomsheet_imagepicker, null);
        AppCompatTextView tvChooseGallery = view.findViewById(R.id.tvChooseImageusingGallery);
        AppCompatTextView tvChooseImageusingCamera = view.findViewById(R.id.tvChooseImageusingCamera);
        AppCompatTextView tvCancelImagePicker = view.findViewById(R.id.tvCancelImagePicker);

        imagePickerBottomSheet.setContentView(view);
        imagePickerBottomSheet.setCanceledOnTouchOutside(false);

        tvChooseImageusingCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCameraAndGallery(REQUEST_CAMERA);
            }
        });

        tvChooseGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openCameraAndGallery(REQUEST_GALLERY);
            }
        });

        tvCancelImagePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imagePickerBottomSheet.dismiss();
                finish();
            }
        });
        imagePickerBottomSheet.show();

    }

    private void RequestMultiplePermission() {

        // Creating String Array with Permissions.
        ActivityCompat.requestPermissions(ImagePickerManager.this, new String[]{
                CAMERA,
                READ_EXTERNAL_STORAGE
        }, RequestPermissionCode);
    }

    // Calling override method.
    @Override
    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case RequestPermissionCode:
                if (grantResults.length > 0) {
                    boolean isCameraPermissionGranted = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                    boolean isReadStoragePermission = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                    if (isCameraPermissionGranted && isReadStoragePermission) {
                        Toast.makeText(ImagePickerManager.this, "Permission Granted", Toast.LENGTH_LONG).show();
                        openCameraAndGallery(mPickFrom);
                    } else {
                        Toast.makeText(ImagePickerManager.this, "Permission Denied", Toast.LENGTH_LONG).show();
                    }
                }

                break;
        }
    }

    public boolean CheckingPermissionIsEnabledOrNot() {

        int FirstPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), CAMERA);
        int ThirdPermissionResult = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);

        return FirstPermissionResult == PackageManager.PERMISSION_GRANTED &&
                ThirdPermissionResult == PackageManager.PERMISSION_GRANTED;
    }

    private void openCameraAndGallery(int type) {
        if (CheckingPermissionIsEnabledOrNot()) {
            if (type == REQUEST_CAMERA) {
                openCamera();
            } else if (type == REQUEST_GALLERY) {
                openGallery();
            }
        } else {
            //Calling method to enable permission.
            RequestMultiplePermission();
        }
    }

    private void cropImage(Uri uri) {
        if (uri != null) {
            Intent intent = new Intent("com.android.camera.action.CROP");
            intent.setDataAndType(uri, "image/*");
            intent.putExtra("crop", "true");
            intent.putExtra("aspectX", 1);
            intent.putExtra("aspectY", 1);
            intent.putExtra("outputX", 320);
            intent.putExtra("outputY", 320);
            intent.putExtra("return-data", true);
            startActivityForResult(intent, REQUEST_CROP);
        } else {
            Toast.makeText(this, "Image Path is null", Toast.LENGTH_SHORT).show();
        }
    }

    public Uri getImageUri(Context inContext, Bitmap inImage) {
        ByteArrayOutputStream bytes = new ByteArrayOutputStream();
        inImage.compress(Bitmap.CompressFormat.JPEG, 100, bytes);
        String path = MediaStore.Images.Media.insertImage(inContext.getContentResolver(), inImage, "signatureImage", null);
        return Uri.parse(path);
    }

    public String getRealPathFromURI(Uri uri) {
        String path = "";

        if (ObjectUtils.isNotNull(uri)) {
            Cursor cursor = getContentResolver().query(uri, null, null, null, null);

            if (ObjectUtils.isNotNull(cursor)) {
                cursor.moveToFirst();
                int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
                path = cursor.getString(idx);
            }
        }

        return path;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode != RESULT_OK) {
            if (!TextUtils.isEmpty(selectedImagePath)) {
                if (data == null) {
                    data = new Intent();
                }
                data.putExtra("data_uri", selectedImagePath);
                setResult(resultCode, data);
                finish();
            } else {
                finish();
            }
            return;
        }

        switch (requestCode) {
            case REQUEST_CAMERA:

                File imgFile = new File(pictureImagePath);

                if (imgFile.exists()) {

                    Bitmap imageBitmapCamera = BitmapFactory.decodeFile(imgFile.getAbsolutePath());

                    // imageViewSignature.setImageBitmap(imageBitmapCamera);

                    Uri tempUri = getImageUri(this, imageBitmapCamera);

                    if (ObjectUtils.isNotNull(tempUri)) {

                        File finalFile = new File(pictureImagePath);

                        if (finalFile != null && !TextUtils.isEmpty(finalFile.getAbsolutePath())) {
                            selectedImagePath = finalFile.getAbsolutePath();
                        }
                        if (finalFile != null && !TextUtils.isEmpty(finalFile.getAbsolutePath())) {
                            selectedImagePath = finalFile.getAbsolutePath();
                        }

                        cropImage(tempUri);

                    }

                }
                break;

            case REQUEST_CROP:
                if (data != null) {
                    Uri uri = data.getData();
                    if (ObjectUtils.isNotNull(uri)) {
                        selectedImagePath = getRealPathFromURI(uri);

                        data.putExtra("data_uri", uri.getPath());
                        setResult(resultCode, data);
                        finish();

                        // imageViewSignature.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                        // imageViewSignature.setImageURI(uri);

						/*Glide.with(getActivity())
								.load(uri)
								.asBitmap()
								.into(imageViewSignature);*/

                    }
                }

                break;

            case REQUEST_GALLERY:
                if (data != null) {
                    Uri uri = data.getData();
                    if (uri != null) {
                        selectedImagePath = getRealPathFromURI(uri);
                        Bitmap bitmapGallery = null;
                        try {
                            bitmapGallery = MediaStore.Images.Media.getBitmap(getContentResolver(), uri);
                        } catch (IOException e) {
                            e.printStackTrace();
                        }

                        // imageViewSignature.setImageBitmap(imageBitmapCamera);
                        if (bitmapGallery != null) {
                            Uri tempUri = getImageUri(this, bitmapGallery);
                            if (tempUri != null) {
                                cropImage(tempUri);
                            }

                        }
                    }

                }
                break;
        }

    }

	/*@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {


		if (resultCode != RESULT_OK)
		{
			finish();
			return;
		}
		if (requestCode == REQUEST_CAMERA)
		{
			doCrop();
		}
		else if (requestCode == REQUEST_GALLERY)
		{
			mImageCaptureUri = data.getData();
			doCrop();
		}
		else if (requestCode == REQUEST_CROP)
		{
			if (data == null)
				data = new Intent();
			data.putExtra("data_uri", mSelectedImageUri.getPath());
			setResult(resultCode, data);
			finish();
		}
		super.onActivityResult(requestCode, resultCode, data);
	}*/

    /**
     * Runtime permission
     */

    private boolean checkAndRequestPermissions() {
        int permissionCAMERA = ContextCompat.checkSelfPermission(this,
                Manifest.permission.CAMERA);
        int storagePermission = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);


        List<String> listPermissionsNeeded = new ArrayList<>();
        if (storagePermission != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.READ_EXTERNAL_STORAGE);
        }
        if (permissionCAMERA != PackageManager.PERMISSION_GRANTED) {
            listPermissionsNeeded.add(Manifest.permission.CAMERA);
        }
        if (!listPermissionsNeeded.isEmpty()) {
            ActivityCompat.requestPermissions(this,
                    listPermissionsNeeded.toArray(new String[listPermissionsNeeded.size()]), PERMISSIONS_REQUEST_CAMERA_STORAGE);
            return false;
        }

        return true;
    }
   /* @Override    public void onRequestPermissionsResult(int requestCode, String permissions[], int[] grantResults) {
        switch (requestCode) {
            case PERMISSIONS_REQUEST_CAMERA_STORAGE:
                if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                    //Permission Granted Successfully. Write working code here.
                } else {
                    //You did not accept the request can not use the functionality.
                }
                break;
        }
    }*/
}