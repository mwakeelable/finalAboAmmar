package com.trianglz.aboammarfin.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.trianglz.aboammarfin.R;
import com.trianglz.aboammarfin.UI.MainActivity;

/**
 * Created by wakeel on 29/06/16.
 */
public class HomeFragment extends Fragment {
    MainActivity activity;

    public HomeFragment(){

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        activity = (MainActivity) getActivity();
        return inflater.inflate(R.layout.home_fragment, container, false);
    }
}
