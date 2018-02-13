package spandroid.dev.room;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialog;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import spandroid.dev.R;
import spandroid.dev.room.adapter.RoomAdapter;
import spandroid.dev.room.animator.MyItemAnimator;
import spandroid.dev.room.controller.OnUserSelectListener;
import spandroid.dev.room.db.AppDatabase;
import spandroid.dev.room.dto.User;

public class RoomActivity extends AppCompatActivity implements OnUserSelectListener {

    private static String INSERT = "insert";
    private static String DELETE = "delete";
    private static String UPDATE = "update";
    @BindView(R.id.recyclerViewUsers)
    RecyclerView recyclerViewUsers;
    @BindView(R.id.btnAdd)
    AppCompatButton btnAdd;
    @BindView(R.id.btnUpdate)
    AppCompatButton btnUpdate;
    @BindView(R.id.btnDelete)
    AppCompatButton btnDelete;
    @BindView(R.id.llBottom)
    LinearLayout llBottom;
    @BindView(R.id.rootLayout)
    RelativeLayout rootLayout;
    //  FOR BOTTOM SHEET
    AppCompatEditText etEmail;
    AppCompatEditText etFname;
    AppCompatEditText etLName;
    AppCompatEditText etMobile;
    AppCompatButton btnRoomAction;
    BottomSheetDialog mBottomSheetDialog;
    List<User> userList = new ArrayList<>();
    RoomAdapter roomAdapter;

    int selectedPosition = -1;

    private static void addUser(final AppDatabase db, User user) {
        db.userDao().insertAll(user);
    }

    private static void populateWithTestData(AppDatabase db) {
        User user = new User();
        user.setFirstName("Ajay");
        user.setLastName("Saini");
        user.setMobileNumber("8749222342");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);
        ButterKnife.bind(this);

        userList.addAll(AppDatabase.getAppDatabase(RoomActivity.this).userDao().getAll());
        roomAdapter = new RoomAdapter(userList, this);

        DividerItemDecoration horizontalDecoration = new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL);
        Drawable horizontalDivider = ContextCompat.getDrawable(this, R.drawable.horizontal_divider);
        recyclerViewUsers.setLayoutManager(new LinearLayoutManager(RoomActivity.this, LinearLayoutManager.VERTICAL, false));
        horizontalDecoration.setDrawable(horizontalDivider);
        recyclerViewUsers.addItemDecoration(horizontalDecoration);
        recyclerViewUsers.setItemAnimator(new MyItemAnimator());

        recyclerViewUsers.setAdapter(roomAdapter);

    }

    private void showBottomSheetUpdate(final User user, final String action) {

        if (mBottomSheetDialog == null) {
            mBottomSheetDialog = new BottomSheetDialog(RoomActivity.this);
        }


        if (mBottomSheetDialog != null) {

            mBottomSheetDialog.setContentView(R.layout.bottomsheet_room_insert);
            etEmail = mBottomSheetDialog.findViewById(R.id.etEmail);
            etFname = mBottomSheetDialog.findViewById(R.id.etFname);
            etLName = mBottomSheetDialog.findViewById(R.id.etLName);
            etMobile = mBottomSheetDialog.findViewById(R.id.etMobile);
            btnRoomAction = mBottomSheetDialog.findViewById(R.id.btnRoomAction);
        }

        if (user != null) {
            etEmail.setText(user.getEmailId());
            etFname.setText(user.getFirstName());
            etLName.setText(user.getLastName());
            etEmail.setText(user.getMobileNumber());
        }

        btnRoomAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (action.equalsIgnoreCase(INSERT)) {

                    User userInsert = new User();
                    userInsert.setFirstName(etFname.getText().toString().trim());
                    userInsert.setLastName(etLName.getText().toString().trim());
                    userInsert.setMobileNumber(etMobile.getText().toString().trim());
                    addUser(AppDatabase.getAppDatabase(RoomActivity.this), userInsert);
                    userInsert.setEmailId(etEmail.getText().toString().trim());
                    userList.add(userInsert);
                    roomAdapter.notifyDataSetChanged();

                } else if (action.equalsIgnoreCase(UPDATE)) {

                    User userUpdate = new User();
                    userUpdate.setFirstName(etFname.getText().toString().trim());
                    userUpdate.setLastName(etLName.getText().toString().trim());
                    userUpdate.setMobileNumber(etMobile.getText().toString().trim());
                    userUpdate.setEmailId(etEmail.getText().toString().trim());

                    update(userUpdate);

                    roomAdapter.notifyItemChanged(selectedPosition);
                } else {
                    User userDelete = new User();
                    userDelete.setFirstName(etFname.getText().toString().trim());
                    userDelete.setLastName(etLName.getText().toString().trim());
                    userDelete.setMobileNumber(etMobile.getText().toString().trim());
                    userDelete.setEmailId(etEmail.getText().toString().trim());

                    delete(userDelete);
                }
            }
        });

        mBottomSheetDialog.show();
    }

    @OnClick({R.id.btnAdd, R.id.btnUpdate, R.id.btnDelete})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btnAdd:
                showBottomSheetUpdate(null, INSERT);
                break;
            case R.id.btnUpdate:
                showBottomSheetUpdate(userList.get(selectedPosition), UPDATE);
                break;
            case R.id.btnDelete:
                delete(userList.get(selectedPosition));
                roomAdapter.notifyDataSetChanged();
                break;
        }
    }

    private void update(User user) {
        AppDatabase.getAppDatabase(this).userDao().updateAll(user);
    }

    private void delete(User user) {
        AppDatabase.getAppDatabase(this).userDao().delete(user);
    }

    @Override
    public void onUserSelect(int position, View view) {
        this.selectedPosition = position;
    }

    @Override
    public void onViewANimate(View view) {
        int itemAdapterPosition = recyclerViewUsers.getChildAdapterPosition(view);

        if (itemAdapterPosition == RecyclerView.NO_POSITION) {

            return;

        }
    }


    public void onColorsListItemClicked(View view) {

        int itemAdapterPosition = recyclerViewUsers.getChildAdapterPosition(view);

        if (itemAdapterPosition == RecyclerView.NO_POSITION) {

            return;

        }
    }

    private void setRecyclerViewFallANimation(RecyclerView recyclerview) {
        int resId = R.anim.layout_animation_falldown;
        LayoutAnimationController animation = AnimationUtils.loadLayoutAnimation(this, resId);
        recyclerview.setLayoutAnimation(animation);
    }
}
