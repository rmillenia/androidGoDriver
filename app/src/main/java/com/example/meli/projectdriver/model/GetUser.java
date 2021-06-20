package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetUser {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    List<User> listUser;
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

    public List<User> getListDataUser() {
        return listUser;
    }

    public void setListDataUser(List<User> listUser) {
        this.listUser = listUser;
    }
}
