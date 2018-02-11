package spandroid.dev.animation;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spandroid.dev.R;

public class DetailFragment extends Fragment {
    //...
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_details_anim, container, false);
        //..
        // AnimationUtils.registerCircularRevealAnimation(getContext(), view, (RevealAnimationSetting) getArguments().getParcelable(ARG_REVEAL_SETTINGS), getColor(R.color.prezi_blue), getColor(R.color.white));
        //...
        return view;
    }
}
