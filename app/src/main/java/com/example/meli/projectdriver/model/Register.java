package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class Register {
    @SerializedName("id")
    private String id;
    @SerializedName("nik")
    private String nik;
    @SerializedName("nama")
    private String nama;
    @SerializedName("noHp")
    private String noHp;
    @SerializedName("level")
    private String level;
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;
    @SerializedName("password")
    private String password;

    public Register(){}

    public Register(String id, String nik, String nama, String noHp, String level, String email, String username,  String password) {
        this.id = id;
        this.nik = nik;
        this.nama = nama;
        this.username = username;
        this.noHp = noHp;
        this.email = email;
        this.level = level;
        this.password = password;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getNik() {
        return nik;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNoHp() {
        return noHp;
    }

    public void setNoHp(String noHp) {
        this.noHp = noHp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    }
