package spandroid.dev.image_video_capture.files;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import spandroid.dev.R;

public class FileChooserFragment extends Fragment implements View.OnClickListener {

    private static final String TAG = "FileChooserFragment";
    private static final int REQUEST_FILE_CHOOSRER = 1;
    private Button buttonChooseImage;
    private ImageView imageViewChooseImage;
    private TextView textViewFilePath;
    private BottomSheetDialog bottomSheetDialog;


    public FileChooserFragment() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FileChooserFragment newInstance() {
        FileChooserFragment fragment = new FileChooserFragment();
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
        View rootView = inflater.inflate(R.layout.fragment_image_picker, container, false);
        buttonChooseImage = rootView.findViewById(R.id.buttonChooseImage);
        imageViewChooseImage = rootView.findViewById(R.id.imageViewChooseImage);
        textViewFilePath = rootView.findViewById(R.id.textViewFilePath);

        buttonChooseImage.setOnClickListener(this);
        return rootView;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.buttonChooseImage:
                showImageChooserBottomSheet();
                break;
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);

    }

    private void showImageChooserBottomSheet() {
        if (bottomSheetDialog == null) {
            bottomSheetDialog = new BottomSheetDialog(getActivity());
            View view = getLayoutInflater().inflate(R.layout.bottomsheet_imagechooser, null);

            TextView tvTitleImageChooser = view.findViewById(R.id.tvTitleImageChooser);
            TextView textViewOption1 = view.findViewById(R.id.textViewOption1);
            TextView textViewOption2 = view.findViewById(R.id.textViewOption2);

            tvTitleImageChooser.setText("Choose File");
            textViewOption1.setText("Choose from Internal Storage");
            textViewOption2.setText("Choose from Google Drive");

            bottomSheetDialog.setContentView(view);

            textViewOption1.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                }
            });

            textViewOption2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

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


    private void chooseFile() {
        Intent intentFileChooser = new Intent(Intent.ACTION_GET_CONTENT);
        intentFileChooser.setType("*/*");
        startActivityForResult(intentFileChooser, REQUEST_FILE_CHOOSRER);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case REQUEST_FILE_CHOOSRER:
                if (data != null && data.getData() != null) {
                    String filePath = data.getData().getPath();
                    Log.i(TAG, "File Path  " + filePath);
                }
                break;
        }
    }
}
