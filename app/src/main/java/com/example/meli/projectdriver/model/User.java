package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class User {
    @SerializedName("level")
    private String level;
    @SerializedName("totalSaldo")
    private String totalSaldo;
    @SerializedName("nik")
    private String nik;
    @SerializedName("password")
    private String password;
    @SerializedName("nama")
    private String nama;
    @SerializedName("foto")
    private String foto;
    @SerializedName("noHp")
    private String noHp;
    @SerializedName("id")
    private String id;
    @SerializedName("email")
    private String email;
    @SerializedName("username")
    private String username;

    public User(){}

    public User(String level, String totalSaldo, String nik, String password, String nama, String foto, String noHp, String id, String email, String username) {
        this.level = level;
        this.totalSaldo = totalSaldo;
        this.nik = nik;
        this.password = password;
        this.nama = nama;
        this.foto = foto;
        this.noHp = noHp;
        this.id = id;
        this.email = email;
        this.username = username;
    }

    public void setLevel(String level){
        this.level = level;
    }

    public String getLevel(){
        return level;
    }

    public void setTotalSaldo(String totalSaldo){
        this.totalSaldo = totalSaldo;
    }

    public String getTotalSaldo(){
        return totalSaldo;
    }

    public void setNik(String nik){
        this.nik = nik;
    }

    public String getNik(){
        return nik;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setNama(String nama){
        this.nama = nama;
    }

    public String getNama(){
        return nama;
    }

    public void setFoto(String foto){
        this.foto = foto;
    }

    public String getFoto(){
        return foto;
    }

    public void setNoHp(String noHp){
        this.noHp = noHp;
    }

    public String getNoHp(){
        return noHp;
    }

    public void setId(String id){
        this.id = id;
    }

    public String getId(){
        return id;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return username;
    }

    @Override
    public String toString(){
        return
                "User{" +
                        "level = '" + level + '\'' +
                        ",totalSaldo = '" + totalSaldo + '\'' +
                        ",nik = '" + nik + '\'' +
                        ",password = '" + password + '\'' +
                        ",nama = '" + nama + '\'' +
                        ",foto = '" + foto + '\'' +
                        ",noHp = '" + noHp + '\'' +
                        ",id = '" + id + '\'' +
                        ",email = '" + email + '\'' +
                        ",username = '" + username + '\'' +
                        "}";
    }
}


