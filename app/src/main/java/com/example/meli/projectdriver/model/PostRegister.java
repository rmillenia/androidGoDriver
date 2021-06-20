package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class PostRegister {
        @SerializedName("status")
        String status;
        @SerializedName("result")
        Register mRegister;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Register getmRegister() {
        return mRegister;
    }

    public void setmRegister(Register mRegister) {
        this.mRegister = mRegister;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @SerializedName("message")
        String message;
    }
