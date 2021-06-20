package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetDriver {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<Driver> listDriver;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Driver> getListDataDriver() {
        return listDriver;
    }

    public void setListDataDriver(List<Driver> listDriver) {
        this.listDriver = listDriver;
    }
}

