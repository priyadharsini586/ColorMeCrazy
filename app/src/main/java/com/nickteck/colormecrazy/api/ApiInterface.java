package com.nickteck.colormecrazy.api;

import com.nickteck.colormecrazy.model.LoginDetails;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * Created by admin on 8/10/2018.
 */

public interface ApiInterface {

    @FormUrlEncoded
    @POST("client_details_by_phone.php")
    Call<LoginDetails> checkMobileNo(@Field("x") JSONObject object);

    @FormUrlEncoded
    @POST("verify_otp.php")
    Call<LoginDetails> checkopt(@Field("x") JSONObject object);
}
