package spandroid.dev.addviewProgrammatically;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatImageView;
import android.text.InputFilter;
import android.text.InputType;
import android.text.TextUtils;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import spandroid.dev.R;

public class AddViewActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = "AddViewActivity";

    LinearLayout linearLayoutRoot;
    AppCompatButton tvButtonSubmit;

    int idCount = 0;
    AppCompatImageView imageAddRemove;
    private List<View> linearLayoutList = new ArrayList<>();
    private List<AppCompatEditText> listEdittext = new ArrayList<>();
    private List<String> fieldUiId = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_view);
        linearLayoutRoot = findViewById(R.id.linearLayoutRoot);
        tvButtonSubmit = findViewById(R.id.tvButtonSubmit);

        addLayout();

        tvButtonSubmit.setOnClickListener(this);
    }


    private View createFieldLayout(String hint) {

        final AutoCompleteTextView editText = new AutoCompleteTextView(this);
        editText.setBackgroundResource(R.drawable.boarder_gray_one_dp);
        editText.setTextSize(TypedValue.COMPLEX_UNIT_SP, 14);
        editText.setMaxLines(1);
        editText.setImeOptions(EditorInfo.IME_ACTION_NEXT);
        editText.setHintTextColor(ContextCompat.getColor(AddViewActivity.this, R.color.color_D3D3D3));
        int paddingPixel = 10;
        float density = getResources().getDisplayMetrics().density;
        int paddingDp = (int) (paddingPixel * density);
        editText.setPadding(paddingDp, paddingDp, paddingDp, paddingDp);

        String baseId = "et" + (++idCount);

        editText.setTag(baseId);
        //  editText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(Integer.parseInt(fieldSize))});


        editText.setInputType(InputType.TYPE_CLASS_PHONE);


        //  fieldUiId.add(fieldUi);
        linearLayoutList.add(editText);
        return editText;
    }

    private void removeFieldLayout(String baseId) {
        /*EditText editText;
        for (int i = 0; i < etGroupList.size(); i++) {
            editText = etGroupList.get(i);
            if (editText.getTag().equals(baseId)) {
                etGroupList.remove(i);
                linearLayoutRoot.removeView(editText);
            }
        }*/
    }


    private void addLayout() {
        final View layout2 = LayoutInflater.from(this).inflate(R.layout.layout_add_subview, linearLayoutRoot, false);

        NumberPicker numberPickerType = (NumberPicker) layout2.findViewById(R.id.numberPickerType);
        final AppCompatEditText edittext = (AppCompatEditText) layout2.findViewById(R.id.edittext);
        final AppCompatEditText edittextHint = (AppCompatEditText) layout2.findViewById(R.id.edittextHint);
        final AppCompatImageView imageAdd = (AppCompatImageView) layout2.findViewById(R.id.imageAdd);
        final AppCompatImageView imageRemove = (AppCompatImageView) layout2.findViewById(R.id.imageRemove);

        final PopupMenu popupMenu = new PopupMenu(this, edittextHint);
        /**
         * Step 2: Inflate the menu resource. Here the menu resource is
         * defined in the res/menu project folder
         */
        popupMenu.inflate(R.menu.popup_menu);

        edittextHint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                popupMenu.show();
            }
        });
/**
 *  Handle menu item clicks
 */
        popupMenu.setOnMenuItemClickListener(
                new PopupMenu.OnMenuItemClickListener() {
                    @Override
                    public boolean onMenuItemClick(MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.mail:
                                edittextHint.setText("Email");
                                edittext.setHint("Email");
                                break;
                            case R.id.mobile:
                                edittextHint.setText("Mobile");
                                edittext.setHint("Mobile");
                                break;
                            case R.id.phone:
                                edittextHint.setText("Phone");
                                edittext.setHint("Phone");
                                break;
                        }
                        return true;
                    }
                });

        imageAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addLayout();
                imageAdd.setVisibility(View.INVISIBLE);
                imageRemove.setVisibility(View.VISIBLE);
            }
        });

        imageRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                linearLayoutList.remove(layout2);
                linearLayoutRoot.removeView(layout2);
                listEdittext.remove(edittext);
            }
        });


        /**
         * FOR NUMBER PICKER VIEW
         */
        final String[] arrayString = new String[]{"Mobile", "Phone", "HOme", "WOrk"};
        numberPickerType.setMinValue(0);
        numberPickerType.setMaxValue(arrayString.length - 1);
        numberPickerType.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker numberPicker, int i, int i1) {
                Log.i(TAG, "onValueChange: " + arrayString[i] + " " + arrayString[i1]);
                edittext.setHint(arrayString[i1]);
            }
        });

        numberPickerType.setFormatter(new NumberPicker.Formatter() {
            @Override
            public String format(int value) {
                // TODO Auto-generated method stub
                return arrayString[value];
            }
        });

        /**
         * END NUMBER PICKER VIEW
         */

        linearLayoutRoot.addView(layout2);
        linearLayoutList.add(layout2);

        listEdittext.add(edittext);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.tvButtonSubmit:

                String print = "Values";
                for (int i = 0; i < listEdittext.size(); i++) {
                    AppCompatEditText et = listEdittext.get(i);
                    if (et != null) {
                        if (TextUtils.isEmpty(et.getText())) {
                            Toast.makeText(this, "Please ENter " + et.getHint(), Toast.LENGTH_SHORT).show();
                            return;
                        }
                    }
                    print = print + " " + et.getText() + " ";
                }
                Toast.makeText(this, print, Toast.LENGTH_LONG).show();
                break;
        }
    }
}
