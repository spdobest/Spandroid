package spandroid.dev.google_products.googleDrive;

import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.GoogleApiAvailability;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.drive.Drive;
import com.google.android.gms.drive.DriveApi;
import com.google.android.gms.drive.DriveContents;
import com.google.android.gms.drive.DriveFile;
import com.google.android.gms.drive.DriveFolder;
import com.google.android.gms.drive.DriveId;
import com.google.android.gms.drive.MetadataChangeSet;
import com.google.android.gms.drive.OpenFileActivityBuilder;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import spandroid.dev.R;

public class GoogleDriveDownloadActivity extends AppCompatActivity implements GoogleApiClient.ConnectionCallbacks,
        GoogleApiClient.OnConnectionFailedListener, View.OnClickListener {

    private static final String TAG = "GoogleDriveDownloadActi";
    private static final int REQUEST_CODE_RESOLUTION = 1;
    private static final int REQUEST_CODE_OPENER = 2;
    /**
     * Handle result of Created file
     */
    final private ResultCallback<DriveFolder.DriveFileResult> fileCallback = new
            ResultCallback<DriveFolder.DriveFileResult>() {
                @Override
                public void onResult(DriveFolder.DriveFileResult result) {
                    if (result.getStatus().isSuccess()) {

                        Toast.makeText(getApplicationContext(), "file created: " +
                                result.getDriveFile().getDriveId(), Toast.LENGTH_LONG).show();

                    }

                    return;

                }
            };
    public DriveFile file;
    AppCompatButton btnCreateFile, btnOpenFIle;
    ProgressBar mProgressBar;
    private GoogleApiClient mGoogleApiClient;
    private boolean fileOperation = false;
    /**
     * This is Result result handler of Drive contents.
     * this callback method call CreateFileOnGoogleDrive() method
     * and also call OpenFileFromGoogleDrive() method,
     * send intent onActivityResult() method to handle result.
     */
    final ResultCallback<DriveApi.DriveContentsResult> driveContentsCallback =
            new ResultCallback<DriveApi.DriveContentsResult>() {
                @Override
                public void onResult(DriveApi.DriveContentsResult result) {

                    if (result.getStatus().isSuccess()) {

                        if (fileOperation == true) {

                            CreateFileOnGoogleDrive(result);

                        } else {

                            OpenFileFromGoogleDrive();

                        }
                    }

                }
            };
    private DriveId mFileId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_google_drive_download);

        btnOpenFIle = findViewById(R.id.btnOpenFIle);
        btnCreateFile = findViewById(R.id.btnCreateFile);
        mProgressBar = findViewById(R.id.progressBar);

        btnOpenFIle.setOnClickListener(this);
        btnCreateFile.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnCreateFile:
                onClickCreateFile();
                break;
            case R.id.btnOpenFIle:
                onClickOpenFile();
                break;
        }
    }

    public void onClickCreateFile() {
        fileOperation = true;

        // create new contents resource
        Drive.DriveApi.newDriveContents(mGoogleApiClient)
                .setResultCallback(driveContentsCallback);

    }

    public void onClickOpenFile() {
        fileOperation = false;

        // create new contents resource
        Drive.DriveApi.newDriveContents(mGoogleApiClient)
                .setResultCallback(driveContentsCallback);
    }

    /**
     * Called when the activity will start interacting with the user.
     * At this point your activity is at the top of the activity stack,
     * with user input going to <a class="vglnk" href="http://it" rel="nofollow"><span>it</span></a>.
     */

    @Override
    protected void onResume() {
        super.onResume();
        if (mGoogleApiClient == null) {

            /**
             * Create the API client and bind it to an instance variable.
             * We use this instance as the callback for connection and connection failures.
             * Since no account name is passed, the user is prompted to choose.
             */
            mGoogleApiClient = new GoogleApiClient.Builder(this)
                    .addApi(Drive.API)
                    .addScope(Drive.SCOPE_FILE)
                    .addConnectionCallbacks(this)
                    .addOnConnectionFailedListener(this)
                    .build();
        }

        mGoogleApiClient.connect();
    }

    @Override
    protected void onStop() {
        super.onStop();
        if (mGoogleApiClient != null) {

            // disconnect Google API client connection
            mGoogleApiClient.disconnect();
        }
        super.onPause();
    }

    @Override
    public void onConnectionFailed(ConnectionResult result) {

        // Called whenever the API client fails to connect.
        Log.i(TAG, "GoogleApiClient connection failed: " + result.toString());

        if (!result.hasResolution()) {

            // show the localized error dialog.
            GoogleApiAvailability.getInstance().getErrorDialog(this, result.getErrorCode(), 0).show();
            return;
        }

        /**
         *  The failure has a resolution. Resolve <a class="vglnk" href="http://it" rel="nofollow"><span>it</span></a>.
         *  Called typically when the app is not yet authorized, and an  authorization
         *  dialog is displayed to the user.
         */

        try {

            result.startResolutionForResult(this, REQUEST_CODE_RESOLUTION);

        } catch (IntentSender.SendIntentException e) {

            Log.e(TAG, "Exception while starting resolution activity", e);
        }
    }

    /**
     * It invoked when Google API client connected
     *
     * @param connectionHint
     */
    @Override
    public void onConnected(Bundle connectionHint) {

        Toast.makeText(getApplicationContext(), "Connected", Toast.LENGTH_LONG).show();
    }

    /**
     * It invoked when connection suspend
     *
     * @param cause
     */
    @Override
    public void onConnectionSuspended(int cause) {

        Log.i(TAG, "GoogleApiClient connection suspended");
    }

    /**
     * Open list of folder and file of the Google Drive
     */
    public void OpenFileFromGoogleDrive() {

        IntentSender intentSender = Drive.DriveApi
                .newOpenFileActivityBuilder()
                .setMimeType(new String[]{"application/pdf", "application/pdf"})
                .build(mGoogleApiClient);
        try {
            startIntentSenderForResult(

                    intentSender, REQUEST_CODE_OPENER, null, 0, 0, 0);

        } catch (IntentSender.SendIntentException e) {

            Log.w(TAG, "Unable to send intent", e);
        }

    }

    /**
     * Create a file in root folder using MetadataChangeSet object.
     *
     * @param result
     */
    public void CreateFileOnGoogleDrive(DriveApi.DriveContentsResult result) {

        final DriveContents driveContents = result.getDriveContents();

        // Perform I/O off the UI thread.
        new Thread() {
            @Override
            public void run() {
                // write content to DriveContents
                OutputStream outputStream = driveContents.getOutputStream();
                Writer writer = new OutputStreamWriter(outputStream);
                try {
                    writer.write("Hello abhay!");
                    writer.close();
                } catch (IOException e) {
                    Log.e(TAG, e.getMessage());
                }

                MetadataChangeSet changeSet = new MetadataChangeSet.Builder()
                        .setTitle("abhaytest2")
                        .setMimeType("text/plain")
                        .setStarred(true).build();

                // create a file in root folder
                Drive.DriveApi.getRootFolder(mGoogleApiClient)
                        .createFile(mGoogleApiClient, changeSet, driveContents)
                        .setResultCallback(fileCallback);
            }
        }.start();
    }

    /**
     * Handle Response of selected file
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    @Override
    protected void onActivityResult(final int requestCode,
                                    final int resultCode, final Intent data) {
        switch (requestCode) {

            case REQUEST_CODE_OPENER:

                if (resultCode == RESULT_OK) {

                    mFileId = data.getParcelableExtra(
                            OpenFileActivityBuilder.EXTRA_RESPONSE_DRIVE_ID);

                    // FileID=file.getId();//it is your file ID which you want to display

                    String id = mFileId.getResourceId();

                    String url = "https://docs.google.com/file/d/" + id;
                    Intent i = new Intent(Intent.ACTION_VIEW);
                    i.setData(Uri.parse(url));
                    startActivity(i);

                }

                break;

            default:
                super.onActivityResult(requestCode, resultCode, data);
                break;
        }
    }


}