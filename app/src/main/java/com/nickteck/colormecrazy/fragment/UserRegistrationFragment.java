package com.nickteck.colormecrazy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.nickteck.colormecrazy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class UserRegistrationFragment extends Fragment {

    View mainView;
    private ProgressBar progress;


    public UserRegistrationFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_user_registration, container, false);

        init();


        return mainView;
    }

    private void init() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView tootBarTextViewb = (TextView)toolbar.findViewById(R.id.txtHomeToolBar);
        ImageView imageView = (ImageView) toolbar.findViewById(R.id.imgNavigationIcon);
        imageView.setImageResource(R.drawable.ic_member);
        String content_text = getResources().getString(R.string.member_ship);
        tootBarTextViewb.setText(content_text);

        progress = (ProgressBar) mainView.findViewById(R.id.progress);
        progress.setVisibility(View.INVISIBLE);
    }

}
