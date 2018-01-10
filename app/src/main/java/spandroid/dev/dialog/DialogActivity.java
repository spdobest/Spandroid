package spandroid.dev.dialog;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.RatingBar;
import android.widget.Toast;

import spandroid.dev.R;

/**
 * Created by Venkatesh on 3/22/16.
 */
public class DialogActivity extends AppCompatActivity implements DFragment.DialogListener {
    boolean isUpdateDialogOpen;
    AlertDialog ratingDialog;
    DFragment dFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog);

        findViewById(R.id.btnDialogIphone).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showUpdateDialog(false);
            }
        });

        findViewById(R.id.btnDialogMaterial).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateAppDialog();
            }
        });

        findViewById(R.id.btnDialograting).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showRatingDialog(true);
            }
        });

        findViewById(R.id.btnDialogFeedback).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogFeedback();
            }
        });

        findViewById(R.id.btnDialogAppCompat).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAppCompatDialog();
            }
        });

        findViewById(R.id.btnDialogFragment).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dFragment = new DFragment();
                FragmentManager fm = getSupportFragmentManager();
                // Show DialogFragment
                dFragment.show(fm, "Dialog Fragment");
            }
        });
    }

    private void updateAppDialog() {
        final AlertDialog alertDialogRemoveCartItem = new AlertDialog.Builder(
                DialogActivity.this).create();
        // Setting Dialog Title
        alertDialogRemoveCartItem.setTitle("Update App ");
        // Setting Dialog Message
        //alertDialog.setMessage("Please login to add to WishList");

        alertDialogRemoveCartItem.setMessage("Do you want to Update this Application ?");
        // Setting Icon to Dialog
        alertDialogRemoveCartItem.setIcon(R.drawable.ic_launcher);

        // Setting OK Button
        alertDialogRemoveCartItem.setButton(AlertDialog.BUTTON_POSITIVE, "Update", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
                try {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
                } catch (android.content.ActivityNotFoundException anfe) {
                    startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
                }
                alertDialogRemoveCartItem.dismiss();
            }
        });

        alertDialogRemoveCartItem.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                android.util.Log.i("", "onClicked: ");
                //((HomeActivity) context).showLoginScreen(Constants.FROM_ADAPTER_SCREEN);
                alertDialogRemoveCartItem.dismiss();
            }
        });

        // Showing Alert Message
        alertDialogRemoveCartItem.show();

    }

    private void showUpdateDialog(boolean forceUpdate) {
        isUpdateDialogOpen = true;
        AppCompatTextView tvTitle, tvMsg, tvUpdate, tvNotnow;
        LinearLayout linearLayout;
        View lineVert;
        AppCompatTextView tvForceUpdate;
        final RatingBar ratingBar;
        LayoutInflater factory = LayoutInflater.from(this);
        final View ratingDialogView = factory.inflate(
                R.layout.dialog_update_app, null);

//        Typeface face= Typeface.createFromAsset(getAssets(), "fonts/roboto_thin.ttf");

        tvTitle = ratingDialogView.findViewById(R.id.tvUpdateAppTitle);
        tvMsg = ratingDialogView.findViewById(R.id.tvUpdateAppMsg);
        tvUpdate = ratingDialogView.findViewById(R.id.tvUpdateAppUpdate);
        tvNotnow = ratingDialogView.findViewById(R.id.tvUpdateAppNotNow);
        linearLayout = ratingDialogView.findViewById(R.id.llUpdate);
        lineVert = ratingDialogView.findViewById(R.id.lineVert);


        tvForceUpdate = ratingDialogView.findViewById(R.id.tvForceUpdate);


        ratingDialog = new AlertDialog.Builder(DialogActivity.this/*,R.style.AppCompatAlertDialogStyle*/).create();
        ratingDialog.setView(ratingDialogView);

        if (forceUpdate) {
            linearLayout.setVisibility(View.INVISIBLE);
            lineVert.setVisibility(View.INVISIBLE);
            tvForceUpdate.setVisibility(View.VISIBLE);
        }

        ratingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                isUpdateDialogOpen = false;
            }
        });

        //     ratingBar = (RatingBar)ratingDialogView.findViewById(R.id.dialog_ratingbar);


        // Setting OK Button
/*        ratingDialog.setButton(AlertDialog.BUTTON_NEGATIVE, "Cancel", new DialogInterface.OnClickListener() {
             @Override
             public void onClick(DialogInterface dialog, int which) {
                 ratingDialog.dismiss();
             }
         });

        ratingDialog.setButton(AlertDialog.BUTTON_POSITIVE, "Submit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if (ratingBar.getRating() < 3) {
                    showDialogFeedback();
                }
                ratingDialog.dismiss();
            }
        });*/

        // Showing Alert Message
        ratingDialog.show();
    }

    private void showRatingDialog(boolean forceUpdate) {
        isUpdateDialogOpen = true;
        AppCompatTextView tvTitle, tvUpdate, tvNotnow;
        LinearLayout linearLayout;
        View lineVert;
        AppCompatTextView tvForceUpdate;
        final RatingBar ratingBar;
        LayoutInflater factory = LayoutInflater.from(this);
        final View ratingDialogView = factory.inflate(
                R.layout.dialog_rating_app, null);

        tvTitle = ratingDialogView.findViewById(R.id.tvUpdateAppTitle);
        tvUpdate = ratingDialogView.findViewById(R.id.tvUpdateAppUpdate);
        tvNotnow = ratingDialogView.findViewById(R.id.tvUpdateAppNotNow);
        linearLayout = ratingDialogView.findViewById(R.id.llUpdate);
        tvForceUpdate = ratingDialogView.findViewById(R.id.tvForceUpdate);
        lineVert = ratingDialogView.findViewById(R.id.lineVert);

        ratingBar = ratingDialogView.findViewById(R.id.ratingbarApp);
        ratingBar.setNumStars(5);
       /* Drawable drawable = ratingBar.getProgressDrawable();
        drawable.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);*/


        ratingDialog = new AlertDialog.Builder(this/*,R.style.AppCompatAlertDialogStyle*/).create();
        ratingDialog.setView(ratingDialogView);

        if (true) {
            linearLayout.setVisibility(View.INVISIBLE);
            lineVert.setVisibility(View.INVISIBLE);
            tvForceUpdate.setVisibility(View.VISIBLE);
        }

        ratingDialog.setOnDismissListener(new DialogInterface.OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialog) {
                isUpdateDialogOpen = false;
            }
        });

        tvNotnow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDialog.dismiss();
            }
        });

        tvUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ratingDialog.dismiss();
                openPlaystore();
            }
        });

        tvForceUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (ratingBar.getRating() >= 3) {
                    openPlaystore();
                    ratingDialog.dismiss();
                } else {
//                    showDialogFeedback();
                    ratingDialog.dismiss();
                }
            }
        });
        // Showing Alert Message
        ratingDialog.show();
    }

    private void showDialogFeedback() {
        final AppCompatEditText etFeedback;
        AppCompatTextView tvSubmit, tvCancel;
        LayoutInflater factory = LayoutInflater.from(this);
        final View ratingDialogView = factory.inflate(
                R.layout.dialog_user_feedback, null);
        final AlertDialog feedbackDialog = new AlertDialog.Builder(this).create();
        feedbackDialog.setView(ratingDialogView);
        feedbackDialog.setCancelable(true);

        etFeedback = ratingDialogView.findViewById(R.id.etDialogFeedback);

        tvSubmit = ratingDialogView.findViewById(R.id.tvSubmitFeedback);
        tvCancel = ratingDialogView.findViewById(R.id.tvCancelFeedback);

        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackDialog.dismiss();
            }
        });

        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                feedbackDialog.dismiss();
            }
        });
        feedbackDialog.getWindow().addFlags(WindowManager.LayoutParams.FLAG_LOCAL_FOCUS_MODE);
        // Showing Alert Message
        feedbackDialog.show();
    }

    /*
        PackageInfo pInfo = getPackageManager().getPackageInfo(getPackageName(), 0);
        String version = pInfo.versionName;

        ratingBar = (RatingBar) view.findViewById(R.id.ratingbarApp);
            ratingBar.setNumStars(5);
            Drawable drawable = ratingBar.getProgressDrawable();
            drawable.setColorFilter(Color.parseColor("#ffffff"), PorterDuff.Mode.SRC_ATOP);


    Drawable progress = ratingBar.getProgressDrawable();
    DrawableCompat.setTint(progress, Color.WHITE);

    */
    private void openPlaystore() {
        final String appPackageName = getPackageName(); // getPackageName() from Context or Activity object
        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id=" + appPackageName)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("https://play.google.com/store/apps/details?id=" + appPackageName)));
        }
    }

    private void showAppCompatDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this, R.style.AppCompatAlertDialogStyle);
        builder.setTitle("Dialog");
        builder.setMessage("Hello here is the best example of AppCompatAlertDialogd.com. Lets make use of it");
        builder.setPositiveButton("OK", null);
        builder.setNegativeButton("Cancel", null);

        builder.show();

    }

    @Override
    public void onDialogCancel() {
        Toast.makeText(DialogActivity.this, "Dialog.cancel", Toast.LENGTH_SHORT).show();
        if (null != dFragment)
            dFragment.getDialog().cancel();
    }

    @Override
    public void onDialogSubmit() {
        Toast.makeText(DialogActivity.this, "Dialog Submit", Toast.LENGTH_SHORT).show();
        if (null != dFragment)
            dFragment.getDialog().cancel();
    }
}
