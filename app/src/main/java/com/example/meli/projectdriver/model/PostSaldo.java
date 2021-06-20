package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class PostSaldo {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Saldo mSaldo;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Saldo getmSaldo() {
        return mSaldo;
    }

    public void setmRegister(Saldo mSaldo) {
        this.mSaldo = mSaldo;
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
