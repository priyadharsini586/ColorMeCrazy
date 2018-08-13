package com.nickteck.colormecrazy.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RadioButton;
import android.widget.TextView;

import com.nickteck.colormecrazy.R;

public class UserRegistrationActivity extends AppCompatActivity {

    TextView txtHomeToolBar;
    private ProgressBar progress;
    private TextView fst_nm,cnty_code;
    private TextView lst_nm;
    private EditText dob_edit,email_edit,mbl_no,adres_fst_ln,adres_snd_ln,location,city,state,pincode,occuption;
    private LinearLayout cal_lnLayt;
    private RadioButton radio_male,radio_female,radio_transgender,radio_single,radio_married;
    private Button upload_img_btn,register_btn,cancel_btn;
    private ImageView pro_pic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fragment_user_registration);

         init();
         setOnclickListener();
    }

    private void init() {
        fst_nm = (TextView) findViewById(R.id.fst_nm);
        lst_nm = (TextView) findViewById(R.id.lst_nm);
        dob_edit = (EditText) findViewById(R.id.dob_edit);
        cal_lnLayt = (LinearLayout) findViewById(R.id.cal_lnLayt);
        email_edit = (EditText) findViewById(R.id.email_edit);
        cnty_code = (TextView) findViewById(R.id.cnty_code);
        mbl_no = (EditText) findViewById(R.id.mbl_no);
        radio_male = (RadioButton) findViewById(R.id.radio_male);
        radio_female = (RadioButton) findViewById(R.id.radio_female);
        radio_transgender = (RadioButton) findViewById(R.id.radio_transgender);
        radio_single = (RadioButton) findViewById(R.id.radio_single);
        radio_married = (RadioButton) findViewById(R.id.radio_married);
        adres_fst_ln = (EditText) findViewById(R.id.adres_fst_ln);
        adres_snd_ln = (EditText) findViewById(R.id.adres_snd_ln);
        location = (EditText) findViewById(R.id.location);
        city = (EditText) findViewById(R.id.city);
        state = (EditText) findViewById(R.id.state);
        pincode = (EditText) findViewById(R.id.pincode);
        occuption = (EditText) findViewById(R.id.occuption);
        upload_img_btn = (Button) findViewById(R.id.upload_img_btn);
        pro_pic = (ImageView) findViewById(R.id.pro_pic);
        register_btn = (Button) findViewById(R.id.register_btn);
        cancel_btn = (Button) findViewById(R.id.cancel_btn);


        progress = (ProgressBar) findViewById(R.id.progress);
        progress.setVisibility(View.INVISIBLE);

    }

    private void setOnclickListener() {
        cal_lnLayt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


            }
        });

    }
}
