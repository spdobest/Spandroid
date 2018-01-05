package spandroid.dev.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import spandroid.dev.R;

public class FragmentC extends Fragment implements View.OnClickListener {

    private static final String TAG = "FragmentC";

    private static final String ARG_PARAM1 = "param1";

    // TODO: Rename and change types of parameters
    private String mParam1;

    private FragmentSelectListener mListener;
    private AppCompatButton btnFragmentA;
    private AppCompatButton btnFragmentB;
    private AppCompatButton btnFragmentC;
    private AppCompatButton btnFragmentD;

    public FragmentC() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @return A new instance of fragment FragmentA.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentC newInstance(String param1) {
        FragmentC fragment = new FragmentC();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_a, container, false);
        initVIew(view);
        return view;
    }

    private void initVIew(View view) {
        btnFragmentA = view.findViewById(R.id.btnFragmentA);
        btnFragmentB = view.findViewById(R.id.btnFragmentB);
        btnFragmentC = view.findViewById(R.id.btnFragmentC);
        btnFragmentD = view.findViewById(R.id.btnFragmentD);


        btnFragmentD.setOnClickListener(this);
        btnFragmentC.setOnClickListener(this);
        btnFragmentB.setOnClickListener(this);
        btnFragmentA.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        int type = 0;
        switch (view.getId()) {
            case R.id.btnFragmentD:
                type = 4;
                break;
            case R.id.btnFragmentC:
                type = 3;
                break;
            case R.id.btnFragmentB:
                type = 2;
                break;
            case R.id.btnFragmentA:
                type = 1;
                break;
        }

        if (mListener != null) {
            mListener.onFragmentSelect(type);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            mListener = (FragmentSelectListener) context;
        } catch (ClassCastException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }
}
