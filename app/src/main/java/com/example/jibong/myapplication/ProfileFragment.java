package com.example.jibong.myapplication;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by jibong on 08/12/2017.
 */

public class ProfileFragment extends Fragment {


    @BindView(R.id.profileDesc)
    TextView profileDescription;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        ViewGroup rootView = (ViewGroup) inflater.inflate(
                R.layout.profile_view, container, false);

        ButterKnife.bind(this, rootView);

        profileDescription.setText("CHANGE PROFILE DESCRIPTION");

        return rootView;
    }
}
