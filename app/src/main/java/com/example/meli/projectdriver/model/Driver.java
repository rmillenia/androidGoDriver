package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class Driver{
	@SerializedName("level")
	private String level;
	@SerializedName("totalSaldo")
	private String totalSaldo;
	@SerializedName("fotoSim")
	private String fotoSim;
	@SerializedName("nik")
	private String nik;
	@SerializedName("password")
	private String password;
	@SerializedName("id_detail")
	private String id_detail;
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
	@SerializedName("id_driver")
	private String id_driver;
	@SerializedName("status")
	private String status;
	@SerializedName("username")
	private String username;

	public Driver(String level, String totalSaldo, String fotoSim, String nik, String password, String id_detail, String nama, String foto, String noHp, String id, String email, String id_driver, String status, String username) {
		this.level = level;
		this.totalSaldo = totalSaldo;
		this.fotoSim = fotoSim;
		this.nik = nik;
		this.password = password;
		this.id_detail = id_detail;
		this.nama = nama;
		this.foto = foto;
		this.noHp = noHp;
		this.id = id;
		this.email = email;
		this.id_driver = id_driver;
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

	public void setFotoSim(String fotoSim){
		this.fotoSim = fotoSim;
	}

	public String getFotoSim(){
		return fotoSim;
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

	public String getId_detail() {
		return id_detail;
	}

	public void setId_detail(String id_detail) {
		this.id_detail = id_detail;
	}

	public String getId_driver() {
		return id_driver;
	}

	public void setId_driver(String id_driver) {
		this.id_driver = id_driver;
	}

	@Override
 	public String toString(){
		return 
			"Driver{" + 
			"level = '" + level + '\'' + 
			",totalSaldo = '" + totalSaldo + '\'' + 
			",fotoSim = '" + fotoSim + '\'' + 
			",nik = '" + nik + '\'' + 
			",password = '" + password + '\'' + 
			",id_detail = '" + id_detail + '\'' +
			",nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",noHp = '" + noHp + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",id_driver = '" + id_driver + '\'' +
			",status = '" + status + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}
