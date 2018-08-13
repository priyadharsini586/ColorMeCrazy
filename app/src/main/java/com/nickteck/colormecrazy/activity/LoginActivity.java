package com.nickteck.colormecrazy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.androidadvance.topsnackbar.TSnackbar;
import com.nickteck.colormecrazy.R;
import com.nickteck.colormecrazy.additionalClass.HelperClass;
import com.nickteck.colormecrazy.api.ApiClient;
import com.nickteck.colormecrazy.api.ApiInterface;
import com.nickteck.colormecrazy.database.DataBaseHandler;
import com.nickteck.colormecrazy.model.LoginDetails;
import com.nickteck.colormecrazy.service.MyApplication;
import com.nickteck.colormecrazy.service.NetworkChangeReceiver;
import com.nickteck.colormecrazy.utilclass.Constants;

import org.json.JSONException;
import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity implements NetworkChangeReceiver.ConnectivityReceiverListener {

    EditText ph_no;
    Button btnSubmit;
    private boolean isPhone;
    boolean netWorkConnection;
    TSnackbar tSnackbar;
    LinearLayout mainView;
    private String getMobileNo;
    ApiInterface apiInterface;
    LoginDetails loginDetails;
    private TextView enter_ph_text;
    private String getActivationCode;
    private Button sbmt_act_btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        mainView = (LinearLayout) findViewById(R.id.sclMainView);

        MyApplication.getInstance().setConnectivityListener(this);
        tSnackbar = HelperClass.showTopSnackBar(mainView, "Network not connected");
        if (HelperClass.isNetworkAvailable(getApplicationContext())) {
            netWorkConnection = true;
            if (tSnackbar.isShown())
                tSnackbar.dismiss();
        }
        else {
            netWorkConnection = false;
            tSnackbar.show();
        }
        // getting permission for app
        getPermission();


        init();
        setOnclickListener();
    }

    private void getPermission() {


    }

    private void init() {
        ph_no = (EditText) findViewById(R.id.ph_no);
        btnSubmit = (Button) findViewById(R.id.sbmt_btn);
        enter_ph_text = (TextView) findViewById(R.id.enter_ph_text);
        sbmt_act_btn = (Button) findViewById(R.id.sbmt_act_btn);
    }

    private void setOnclickListener() {

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                isPhone = HelperClass.isValidMobile(ph_no.getText().toString());
                if (isPhone) {
                    checkLogin();
                } else {
                    validation();
                }
            }
        });

        sbmt_act_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getActivationCode = ph_no.getText().toString();
                if(getActivationCode.isEmpty()){
                    Toast.makeText(LoginActivity.this, "Please Enter Activation Code", Toast.LENGTH_SHORT).show();
                }else {
                    setActivationCode();
                }

            }
        });



    }

    private void checkLogin() {

       /* Intent intent = new Intent(LoginActivity.this,DashBoardActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.fadein,R.anim.fadeout);
        finish();*/

        if (netWorkConnection) {

            getMobileNo = ph_no.getText().toString();
            // api call for the add  mobile no validation
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("phone", getMobileNo);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Call<LoginDetails> checkMobileNo = apiInterface.checkMobileNo(jsonObject);
            checkMobileNo.enqueue(new Callback<LoginDetails>() {

                @Override
                public void onResponse(Call<LoginDetails> call, Response<LoginDetails> response) {
                    if (response.isSuccessful()) {
                        loginDetails = response.body();
                        if (loginDetails.getStatus_code() != null) {
                            if (loginDetails.getStatus_code().equals(Constants.LOGIN_SUCESS)) {
                                btnSubmit.setVisibility(View.GONE);
                                sbmt_act_btn.setVisibility(View.VISIBLE);
                                enter_ph_text.setText("Enter Your Activation Code");
                                ph_no.getText().clear();
                                ph_no.setHint("Enter Your Activation Code");
                            }
                        }

                    }
                }

                @Override
                public void onFailure(Call<LoginDetails> call, Throwable t) {
                    Toast.makeText(LoginActivity.this, ""+t.getMessage(), Toast.LENGTH_SHORT).show();

                }
            });

        }


    }

    private void setActivationCode() {
        if (netWorkConnection) {
            // api call for the add  mobile no validation
            apiInterface = ApiClient.getClient().create(ApiInterface.class);
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("phone", getMobileNo);
                jsonObject.put("otp", getActivationCode);
            } catch (JSONException e) {
                e.printStackTrace();
            }
            Call<LoginDetails> checkMobileNo = apiInterface.checkopt(jsonObject);
            checkMobileNo.enqueue(new Callback<LoginDetails>() {


                @Override
                public void onResponse(Call<LoginDetails> call, Response<LoginDetails> response) {
                    if (response.isSuccessful()) {
                        loginDetails = response.body();
                        if (loginDetails.getStatus_code() != null) {
                            if (loginDetails.getStatus_code().equals(Constants.SUCESS)) {
                                DataBaseHandler dataBaseHandler = new DataBaseHandler(getApplicationContext());
                                dataBaseHandler.insertLoginTable(getMobileNo,"Logged-In-Successfully");
                                 Intent intent = new Intent(LoginActivity.this,DashBoardActivity.class);
                                startActivity(intent);
                                overridePendingTransition(R.anim.fadein,R.anim.fadeout);
                                finish();

                            }else if(loginDetails.getStatus_code().equals(Constants.FAILURE)){
                                Toast.makeText(LoginActivity.this, "OTP Not Matched", Toast.LENGTH_SHORT).show();
                            }


                        }
                    }
                }

                @Override
                public void onFailure(Call<LoginDetails> call, Throwable t) {

                }
            });



        }



    }

    private void validation() {
        if (!isPhone) {
            ph_no.setError("Invalid Phone number");
        }
    }

    @Override
    public void onNetworkConnectionChanged(boolean isConnected) {

    }
}
