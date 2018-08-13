package com.nickteck.colormecrazy.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.activity.UserRegistrationActivity;
import com.nickteck.colormecrazy.adapter.ViewPagerAdapter;
import com.nickteck.colormecrazy.additionalClass.HelperClass;
import com.nickteck.colormecrazy.model.ContentListData;
import com.nickteck.colormecrazy.utilclass.Constants;
import com.viewpagerindicator.CirclePageIndicator;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContentFragment extends Fragment implements View.OnClickListener {

    View mainView;
    private static ViewPager mPager;
    private static int NUM_PAGES = 0;
    private static int currentPage = 0;
    private ArrayList<ContentListData> imageModelArrayList;
    private int [] sliderList = {R.drawable.slider1,R.drawable.slider2,R.drawable.slider3,R.drawable.slider4};
    private LinearLayout ldtSeatAvltyList;
    private LinearLayout member_ship;


    public ContentFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        mainView =  inflater.inflate(R.layout.fragment_content, container, false);

        init();


        return mainView;
    }



    private void init() {

        Toolbar toolbar = (Toolbar) getActivity().findViewById(R.id.toolbar);
        TextView tootBarTextViewb = (TextView)toolbar.findViewById(R.id.txtHomeToolBar);
        String content_text = getResources().getString(R.string.category_fragment);
        tootBarTextViewb.setText(content_text);



        mPager = (ViewPager) mainView.findViewById(R.id.viewPager);
        imageModelArrayList = populateList();
        mPager.setAdapter(new ViewPagerAdapter(getActivity(),imageModelArrayList));
        CirclePageIndicator indicator = (CirclePageIndicator) mainView.findViewById(R.id.indicator);

        indicator.setViewPager(mPager);

        final float density = getResources().getDisplayMetrics().density;
        indicator.setRadius(3 * density);
        NUM_PAGES =imageModelArrayList.size();
        // Auto start of viewpager
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == NUM_PAGES) {
                    currentPage = 0;
                }
                mPager.setCurrentItem(currentPage++, true);
            }
        };
        Timer swipeTimer = new Timer();
        swipeTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, 3000);


        indicator.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                currentPage = position;

            }

            @Override
            public void onPageScrolled(int pos, float arg1, int arg2) {

            }

            @Override
            public void onPageScrollStateChanged(int pos) {

            }
        });

        /*ldtSeatAvltyList = (LinearLayout) mainView.findViewById(R.id.ldtSeatAvltyList);
        ldtSeatAvltyList.setOnClickListener(this);*/
        member_ship = (LinearLayout) mainView.findViewById(R.id.member_ship);
        member_ship.setOnClickListener(this);

    }

    private ArrayList<ContentListData> populateList(){

        ArrayList<ContentListData> list = new ArrayList<>();

        for(int i = 0; i <sliderList.length; i++){
            ContentListData imageModel = new ContentListData();
            imageModel.setImage_drawable(sliderList[i]);
            list.add(imageModel);
        }

        return list;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
           /* case R.id.ldtSeatAvltyList:
                SeatAvailabilityFragment catagoryFragment = new SeatAvailabilityFragment();
                HelperClass.replaceFragment(catagoryFragment, Constants.SEATAVAILABILITYFRAGMENT, (AppCompatActivity) getActivity());
                break;*/

            case R.id.member_ship:

                /*UserRegistrationFragment userRegistrationFragment = new UserRegistrationFragment();
                HelperClass.replaceFragment(userRegistrationFragment,Constants.REGISTRATIONFRAGMENT,(AppCompatActivity) getActivity());
                break;*/

                Intent intent = new Intent(getActivity(), UserRegistrationActivity.class);
                startActivity(intent);
        }


    }
}
