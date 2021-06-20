package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class GetTransaksi {
        @SerializedName("status")
        String status;
        @SerializedName("result")
        List<Transaksi> listTransaksi;
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

        public List<Transaksi> getListDataTransaksi() {
            return listTransaksi;
        }

        public void setListDataTransaksi(List<Transaksi> listTransaksi) {
            this.listTransaksi = listTransaksi;
        }
}
