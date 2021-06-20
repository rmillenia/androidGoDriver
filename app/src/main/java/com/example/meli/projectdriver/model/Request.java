package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class Request {
    @SerializedName("idReq")
    private String id;
    @SerializedName("id_driver")
    private int id_driver;
    @SerializedName("id_user")
    private int id_user;
    @SerializedName("tujuan")
    private String tujuan;
    @SerializedName("lat")
    private Double lat;
    @SerializedName("longs")
    private Double longs;
    @SerializedName("status")
    private String status;

    public Request(){}

    public Request(String id, Integer id_driver, Integer id_user,String tujuan, Double lat, Double longs, String status) {
        this.id = id;
        this.id_driver = id_driver;
        this.id_user = id_user;
        this.tujuan = tujuan;
        this.lat = lat;
        this.longs = longs;
        this.status = status;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getId_driver() {
        return id_driver;
    }

    public void setId_driver(int id_driver) {
        this.id_driver = id_driver;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user) {
        this.id_user = id_user;
    }

    public String getTujuan() {
        return tujuan;
    }

    public void setTujuan(String tujuan) {
        this.tujuan = tujuan;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLongs() {
        return longs;
    }

    public void setLongs(Double longs) {
        this.longs = longs;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
