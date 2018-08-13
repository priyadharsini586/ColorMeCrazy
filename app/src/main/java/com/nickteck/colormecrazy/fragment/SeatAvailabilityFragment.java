package com.nickteck.colormecrazy.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.activity.DashBoardActivity;

/**
 * A simple {@link Fragment} subclass.
 */
public class SeatAvailabilityFragment extends Fragment {

    View mainView;
    RelativeLayout reltve_bck_btn;


    public SeatAvailabilityFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_seat_availability, container, false);

        init();
        setOnclickListener();

        return mainView;
    }

    private void init() {
        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView tootBarTextViewb = (TextView)toolbar.findViewById(R.id.txtHomeToolBar);
        String content_text = getResources().getString(R.string.category_fragment);
        tootBarTextViewb.setText(content_text);

        reltve_bck_btn = (RelativeLayout) getActivity().findViewById(R.id.reltve_bck_btn);

    }

    private void setOnclickListener() {

        reltve_bck_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               getActivity().onBackPressed();
            }
        });
    }

}
