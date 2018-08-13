package com.nickteck.colormecrazy.model;

/**
 * Created by admin on 8/10/2018.
 */

public class LoginDetails {

    private String Status_code;
    private String Status_message;
    private String Success;


    public String getStatus_code() {
        return Status_code;
    }

    public void setStatus_code(String status_code) {
        Status_code = status_code;
    }

    public String getStatus_message() {
        return Status_message;
    }

    public void setStatus_message(String status_message) {
        Status_message = status_message;
    }

    public String getSuccess() {
        return Success;
    }

    public void setSuccess(String success) {
        Success = success;
    }
}
