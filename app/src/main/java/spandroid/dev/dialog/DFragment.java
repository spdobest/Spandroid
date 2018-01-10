package spandroid.dev.dialog;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spandroid.dev.R;

public class DFragment extends DialogFragment {

    DialogListener listener;

    @Override
    public void onStart() {
        super.onStart();
        // safety check
        if (getDialog() == null) {
            return;
        }

        // set the animations to use on showing and hiding the dialog
     /*   getDialog().getWindow().setWindowAnimations(
                R.style.MyCustomDialogTheme);*/
        // alternative way of doing it
        //getDialog().getWindow().getAttributes().
        //    windowAnimations = R.style.dialog_animation_fade;

        // ... other stuff you want to do in your onStart() method
    }

    @Override
    public void onAttach(Context activity) {
        super.onAttach(activity);

        // This makes sure that the container activity has implemented
        // the callback interface. If not, it throws an exception.
        try {
            listener = (DialogListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnHeadlineSelectedListener");
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getDialog().getWindow()
                .getAttributes().windowAnimations = R.style.DialogAnimation;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setStyle(STYLE_NORMAL, android.R.style.Theme_Black);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_user_feedback, container,
                false);
        //  getDialog().setTitle("DialogFragment Tutorial");
        // Do something else

        final AppCompatEditText etFeedback;
        AppCompatTextView tvSubmit, tvCancel;
        etFeedback = rootView.findViewById(R.id.etDialogFeedback);

        tvSubmit = rootView.findViewById(R.id.tvSubmitFeedback);
        tvCancel = rootView.findViewById(R.id.tvCancelFeedback);

        tvSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onDialogSubmit();
                }

            }
        });

        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != listener) {
                    listener.onDialogCancel();
                }
            }
        });
        return rootView;
    }
//  http://stackoverflow.com/questions/13402782/show-dialogfragment-with-animation-growing-from-a-point/13537234#13537234
/*    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        final Dialog dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().getAttributes().windowAnimations = R.style.MyCustomDialogTheme;
        return dialog;
    }*/

    interface DialogListener {
        void onDialogCancel();

        void onDialogSubmit();
    }

}
