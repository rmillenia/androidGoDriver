package com.example.meli.projectdriver.model;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class PostRating {
        @SerializedName("status")
        String status;
    @SerializedName("result")
    private List<Rating> result;

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

    public List<Rating> getResult() {
        return result;
    }

    public void setResult(List<Rating> result) {
        this.result = result;
    }

    @SerializedName("message")
        String message;
    }


