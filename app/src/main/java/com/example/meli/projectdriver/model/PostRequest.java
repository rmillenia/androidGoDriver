package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class PostRequest {
    @SerializedName("status")
    String status;
    @SerializedName("result")
    Request mRequest;
    @SerializedName("message")
    String message;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Request getmRequest() {
        return mRequest;
    }

    public void setmRequest(Request mRequest) {
        this.mRequest = mRequest;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
