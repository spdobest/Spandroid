package spandroid.dev.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatButton;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;

import spandroid.dev.R;

public class FragmentMainActivity extends AppCompatActivity implements View.OnClickListener, FragmentSelectListener {

    private static final String TAG = "MyFragmentActivity";

    private FrameLayout frameContainer;
    private AppCompatButton btnFragmentA;
    private AppCompatButton btnFragmentB;
    private AppCompatButton btnFragmentC;
    private AppCompatButton btnFragmentD;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        initVIew();
    }

    private void initVIew() {
        frameContainer = findViewById(R.id.frameContainer);
        btnFragmentA = findViewById(R.id.btnFragmentA);
        btnFragmentB = findViewById(R.id.btnFragmentB);
        btnFragmentC = findViewById(R.id.btnFragmentC);
        btnFragmentD = findViewById(R.id.btnFragmentD);


        btnFragmentD.setOnClickListener(this);
        btnFragmentC.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);
        btnFragmentA.setOnClickListener(this);


        addFragmentOnTop(FragmentA.newInstance(""));

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnFragmentD:
                replaceFragment(FragmentD.newInstance(""));
                break;
            case R.id.btnFragmentC:
                replaceFragment(FragmentC.newInstance(""));
                break;
            case R.id.btnFragmentB:
                replaceFragment(FragmentB.newInstance(""));
                break;
            case R.id.btnFragmentA:
                replaceFragment(FragmentA.newInstance(""));
                break;
        }
    }

    public void addFragment(Fragment baseFragment, boolean withAnimation) {
        FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        if (withAnimation) {
            ft.setCustomAnimations(android.R.anim.slide_in_left, android.R.anim.slide_out_right, android.R.anim.slide_out_right, android.R.anim.slide_out_right);
        }
        ft.replace(R.id.frameContainer, baseFragment, baseFragment.getTag());
        ft.addToBackStack(baseFragment.getTag());
        ft.commit();
    }

    // CLEAR BACK STACK.
    private void clearBackStack() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        while (fragmentManager.getBackStackEntryCount() != 0) {
            fragmentManager.popBackStackImmediate();
        }
    }

    /**
     * Add a fragment on top of the current stack
     */
    public void addFragmentOnTop(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.frameContainer, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void onBackPressed() {
        FragmentManager fragments = getSupportFragmentManager();
        Fragment homeFrag = fragments.findFragmentByTag("0");

        if (fragments.getBackStackEntryCount() > 1) {
            // We have fragments on the backstack that are poppable
            fragments.popBackStackImmediate();
        } else if (homeFrag == null || !homeFrag.isVisible()) {
            // We aren't showing the home screen, so that is the next stop on the back journey

        } else {
            // We are already showing the home screen, so the next stop is out of the app.
            supportFinishAfterTransition();
        }
    }

    private void replaceFragment(Fragment fragment) {
        String backStateName = fragment.getClass().getName();

        FragmentManager manager = getSupportFragmentManager();
        boolean fragmentPopped = manager.popBackStackImmediate(backStateName, 0);

        Log.i(TAG, "replaceFragment: " + backStateName + " isPoped " + fragmentPopped);
        FragmentTransaction ft = manager.beginTransaction();
        if (!fragmentPopped) { //fragment not in back stack, create it.

            ft.replace(R.id.frameContainer, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        } else {

            switch (backStateName) {
                case "FragmentA":
                    fragment = FragmentA.newInstance("");
                    break;
                case "FragmentB":
                    fragment = FragmentB.newInstance("");
                    break;
                case "FragmentC":
                    fragment = FragmentC.newInstance("");
                    break;
                case "FragmentD":
                    fragment = FragmentD.newInstance("");
                    break;
            }

            ft.replace(R.id.frameContainer, fragment);
            ft.addToBackStack(backStateName);
            ft.commit();
        }
    }

    @Override
    public void onFragmentSelect(int type) {
        switch (type) {
            case 1:
                addFragmentOnTop(FragmentA.newInstance(""));
                break;
            case 2:
                addFragmentOnTop(FragmentB.newInstance(""));
                break;
            case 3:
                replaceFragment(FragmentC.newInstance(""));
                break;
            case 4:
                replaceFragment(FragmentD.newInstance(""));
                break;
        }
    }
}
