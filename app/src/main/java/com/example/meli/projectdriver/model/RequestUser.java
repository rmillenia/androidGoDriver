package com.example.meli.projectdriver.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class RequestUser{

	@SerializedName("level")
	private String level;

	@SerializedName("totalSaldo")
	private String totalSaldo;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("tujuan")
	private String tujuan;

	@SerializedName("longs")
	private String longs;

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

    @SerializedName("idReq")
    private String idReq;

	@SerializedName("lat")
	private String lat;

	@SerializedName("email")
	private String email;

	@SerializedName("id_driver")
	private String idDriver;

	@SerializedName("status")
	private String status;

	@SerializedName("username")
	private String username;

    public RequestUser(){}

    public RequestUser(String level, String totalSaldo, String idUser, String tujuan, String longs, String nik, String password, String nama, String foto, String noHp, String id, String idReq, String lat, String email, String idDriver, String status, String username) {
        this.level = level;
        this.totalSaldo = totalSaldo;
        this.idUser = idUser;
        this.tujuan = tujuan;
        this.longs = longs;
        this.nik = nik;
        this.password = password;
        this.nama = nama;
        this.foto = foto;
        this.noHp = noHp;
        this.id = id;
        this.idReq = idReq;
        this.lat = lat;
        this.email = email;
        this.idDriver = idDriver;
        this.status = status;
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

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setTujuan(String tujuan){
		this.tujuan = tujuan;
	}

	public String getTujuan(){
		return tujuan;
	}

	public void setLongs(String longs){
		this.longs = longs;
	}

	public String getLongs(){
		return longs;
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

	public void setLat(String lat){
		this.lat = lat;
	}

	public String getLat(){
		return lat;
	}

	public void setEmail(String email){
		this.email = email;
	}

	public String getEmail(){
		return email;
	}

	public void setIdDriver(String idDriver){
		this.idDriver = idDriver;
	}

	public String getIdDriver(){
		return idDriver;
	}

	public void setStatus(String status){
		this.status = status;
	}

	public String getStatus(){
		return status;
	}

	public void setUsername(String username){
		this.username = username;
	}

	public String getUsername(){
		return username;
	}

    public String getIdReq() {
        return idReq;
    }

    public void setIdReq(String idReq) {
        this.idReq = idReq;
    }

    @Override
	public String toString(){
		return
				"Transaksi{" +
						"level = '" + level + '\'' +
						",totalSaldo = '" + totalSaldo + '\'' +
						",id_user = '" + idUser + '\'' +
						",tujuan = '" + tujuan + '\'' +
						",longs = '" + longs + '\'' +
						",nik = '" + nik + '\'' +
						",password = '" + password + '\'' +
						",nama = '" + nama + '\'' +
						",foto = '" + foto + '\'' +
						",noHp = '" + noHp + '\'' +
						",id = '" + id + '\'' +
						",lat = '" + lat + '\'' +
						",email = '" + email + '\'' +
						",id_driver = '" + idDriver + '\'' +
						",status = '" + status + '\'' +
						",username = '" + username + '\'' +
                        ",username = '" + idReq + '\'' +
						"}";
	}
}