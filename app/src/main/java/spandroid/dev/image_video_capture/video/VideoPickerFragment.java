package spandroid.dev.image_video_capture.video;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;

import spandroid.dev.R;

import static android.Manifest.permission_group.CAMERA;
import static android.Manifest.permission_group.STORAGE;

public class VideoPickerFragment extends Fragment implements View.OnClickListener {

    public static final int REQUEST_VIDEO_CAPTURE = 1;
    public static final int REQUEST_GALLERY = 2;
    public static final int PERMISSION_CODE = 100;
    private static final String TAG = "VideoPickerFragment";

    private Button buttonChooseImage;
    private ImageView imageViewChooseImage;
    private TextView textViewFilePath;

    private String videoPath;


    private BottomSheetDialog bottomSheetDialog;

    public VideoPickerFragment() {
        // Required empty public constructor
    }


    public static VideoPickerFragment newInstance() {
        VideoPickerFragment fragment = new VideoPickerFragment();
        Bundle args = new Bundle();

        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_image_picker, container, false);
        buttonChooseImage = rootView.findViewById(R.id.buttonChooseImage);
        imageViewChooseImage = rootView.findViewById(R.id.imageViewChooseImage);
        textViewFilePath = rootView.findViewById(R.id.textViewFilePath);

        buttonChooseImage.setOnClickListener(this);
        return rootView;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    @Override
    public void onDetach() {
        super.onDetach();

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonChooseImage:
                showImageChooserBottomSheet();
                break;
        }
    }

    public void chooseCameraPermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                CAMERA);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    new String[]{CAMERA},
                    PERMISSION_CODE
            );
            return;
        }
        dispatchTakeVideoIntent();
    }

    public void chooseStoragePermission() {
        int permissionCheck = ContextCompat.checkSelfPermission(getActivity(),
                STORAGE);
        if (permissionCheck != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(
                    getActivity(),
                    new String[]{STORAGE},
                    PERMISSION_CODE
            );
            return;
        }
        openGallery();
    }

    private void openGallery() {
        Intent chooseVideoIntent = new Intent(Intent.ACTION_PICK, MediaStore.Audio.Media.EXTERNAL_CONTENT_URI);
        startActivityForResult(chooseVideoIntent, REQUEST_GALLERY);
    }

    private void dispatchTakeVideoIntent() {
        Intent takeVideoIntent = new Intent(MediaStore.ACTION_VIDEO_CAPTURE);
        if (takeVideoIntent.resolveActivity(getActivity().getPackageManager()) != null) {
            startActivityForResult(takeVideoIntent, REQUEST_VIDEO_CAPTURE);
        }
    }

    private void showImageChooserBottomSheet() {
        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            View view = getLayoutInflater().inflate(R.layout.bottomsheet_imagechooser, null);

            TextView tvTitleImageChooser = view.findViewById(R.id.tvTitleImageChooser);
            TextView textViewOption1 = view.findViewById(R.id.textViewOption1);
            TextView textViewOption2 = view.findViewById(R.id.textViewOption2);

            bottomSheetDialog.setContentView(view);

            textViewOption1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chooseCameraPermission();
                }
            });

            textViewOption2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    chooseStoragePermission();
                }
            });
        }
        if (!bottomSheetDialog.isShowing()) {
            bottomSheetDialog.show();
        } else {
            bottomSheetDialog.dismiss();
            bottomSheetDialog.show();
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String permissions[],
                                           @NonNull int[] grantResults) {
        if (requestCode == PERMISSION_CODE) {
            if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                dispatchTakeVideoIntent();
            }
            if (grantResults.length > 1
                    && grantResults[1] == PackageManager.PERMISSION_GRANTED) {
                openGallery();
            }
        }
    }


    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        switch (requestCode) {
            case REQUEST_VIDEO_CAPTURE:

                if (data != null) {
                    Uri selectedImageUri = data.getData();

                    // OI FILE Manager
                    videoPath = selectedImageUri.getPath();

                    // MEDIA GALLERY
                    videoPath = getPath(selectedImageUri);
                }
                break;
            case REQUEST_GALLERY:

                break;
        }
    }

    // UPDATED!
    public String getPath(Uri uri) {
        String[] projection = {MediaStore.Video.Media.DATA};
        Cursor cursor = getActivity().getContentResolver().query(uri, projection, null, null, null);
        if (cursor != null) {
            // HERE YOU WILL GET A NULLPOINTER IF CURSOR IS NULL
            // THIS CAN BE, IF YOU USED OI FILE MANAGER FOR PICKING THE MEDIA
            int column_index = cursor
                    .getColumnIndexOrThrow(MediaStore.Video.Media.DATA);
            cursor.moveToFirst();
            return cursor.getString(column_index);
        } else
            return null;
    }

    public String getRealPathFromURI(Uri uri) {
        Cursor cursor = getActivity().getContentResolver().query(uri, null, null, null, null);
        cursor.moveToFirst();
        int idx = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
        return cursor.getString(idx);
    }


    public String getFilename() {
        File file = new File(Environment.getExternalStorageDirectory().getPath(), "MyFolder/Images");
        if (!file.exists()) {
            file.mkdirs();
        }
        String uriSting = (file.getAbsolutePath() + "/" + System.currentTimeMillis() + ".jpg");
        return uriSting;

    }

    private String getRealPathFromURI(String contentURI) {
        Uri contentUri = Uri.parse(contentURI);
        Cursor cursor = getActivity().getContentResolver().query(contentUri, null, null, null, null);
        if (cursor == null) {
            return contentUri.getPath();
        } else {
            cursor.moveToFirst();
            int index = cursor.getColumnIndex(MediaStore.Images.ImageColumns.DATA);
            return cursor.getString(index);
        }
    }
}
