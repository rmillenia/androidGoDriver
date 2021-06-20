package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class History {

	@SerializedName("transaksi_id")
	private String transaksiId;

	@SerializedName("totalSaldo")
	private String totalSaldo;

	@SerializedName("rating")
	private String rating;

	@SerializedName("id_rating")
	private String idRating;

	@SerializedName("nik")
	private String nik;

	@SerializedName("password")
	private String password;

	@SerializedName("startTime")
	private String startTime;

	@SerializedName("noHp")
	private String noHp;

	@SerializedName("id")
	private String id;

	@SerializedName("email")
	private String email;

	@SerializedName("id_driver")
	private String idDriver;

	@SerializedName("longTuj")
	private String longTuj;

	@SerializedName("level")
	private String level;

	@SerializedName("totalHarga")
	private String totalHarga;

	@SerializedName("lokasi_jemput")
	private String lokasiJemput;

	@SerializedName("id_transaksi")
	private String idTransaksi;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("latJem")
	private String latJem;

	@SerializedName("tujuan")
	private String tujuan;

	@SerializedName("latTuj")
	private String latTuj;

	@SerializedName("nama")
	private String nama;

	@SerializedName("foto")
	private String foto;

	@SerializedName("endTime")
	private Object endTime;

	@SerializedName("longJem")
	private String longJem;

	@SerializedName("status")
	private String status;

	@SerializedName("username")
	private String username;

	public History(){}

	public History(String transaksiId, String totalSaldo, String rating, String idRating, String nik, String password, String startTime, String noHp, String id, String email, String idDriver, String longTuj, String level, String totalHarga, String lokasiJemput, String idTransaksi, String idUser, String latJem, String tujuan, String latTuj, String nama, String foto, Object endTime, String longJem, String status, String username) {
		this.transaksiId = transaksiId;
		this.totalSaldo = totalSaldo;
		this.rating = rating;
		this.idRating = idRating;
		this.nik = nik;
		this.password = password;
		this.startTime = startTime;
		this.noHp = noHp;
		this.id = id;
		this.email = email;
		this.idDriver = idDriver;
		this.longTuj = longTuj;
		this.level = level;
		this.totalHarga = totalHarga;
		this.lokasiJemput = lokasiJemput;
		this.idTransaksi = idTransaksi;
		this.idUser = idUser;
		this.latJem = latJem;
		this.tujuan = tujuan;
		this.latTuj = latTuj;
		this.nama = nama;
		this.foto = foto;
		this.endTime = endTime;
		this.longJem = longJem;
		this.status = status;
		this.username = username;
	}

	public void setTransaksiId(String transaksiId){
		this.transaksiId = transaksiId;
	}

	public String getTransaksiId(){
		return transaksiId;
	}

	public void setTotalSaldo(String totalSaldo){
		this.totalSaldo = totalSaldo;
	}

	public String getTotalSaldo(){
		return totalSaldo;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	public void setIdRating(String idRating){
		this.idRating = idRating;
	}

	public String getIdRating(){
		return idRating;
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

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
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

	public void setIdDriver(String idDriver){
		this.idDriver = idDriver;
	}

	public String getIdDriver(){
		return idDriver;
	}

	public void setLongTuj(String longTuj){
		this.longTuj = longTuj;
	}

	public String getLongTuj(){
		return longTuj;
	}

	public void setLevel(String level){
		this.level = level;
	}

	public String getLevel(){
		return level;
	}

	public void setTotalHarga(String totalHarga){
		this.totalHarga = totalHarga;
	}

	public String getTotalHarga(){
		return totalHarga;
	}

	public void setLokasiJemput(String lokasiJemput){
		this.lokasiJemput = lokasiJemput;
	}

	public String getLokasiJemput(){
		return lokasiJemput;
	}

	public void setIdTransaksi(String idTransaksi){
		this.idTransaksi = idTransaksi;
	}

	public String getIdTransaksi(){
		return idTransaksi;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setLatJem(String latJem){
		this.latJem = latJem;
	}

	public String getLatJem(){
		return latJem;
	}

	public void setTujuan(String tujuan){
		this.tujuan = tujuan;
	}

	public String getTujuan(){
		return tujuan;
	}

	public void setLatTuj(String latTuj){
		this.latTuj = latTuj;
	}

	public String getLatTuj(){
		return latTuj;
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

	public void setEndTime(Object endTime){
		this.endTime = endTime;
	}

	public Object getEndTime(){
		return endTime;
	}

	public void setLongJem(String longJem){
		this.longJem = longJem;
	}

	public String getLongJem(){
		return longJem;
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

	@Override
 	public String toString(){
		return 
			"History{" +
			"transaksi_id = '" + transaksiId + '\'' + 
			",totalSaldo = '" + totalSaldo + '\'' + 
			",rating = '" + rating + '\'' + 
			",id_rating = '" + idRating + '\'' + 
			",nik = '" + nik + '\'' + 
			",password = '" + password + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",noHp = '" + noHp + '\'' + 
			",id = '" + id + '\'' + 
			",email = '" + email + '\'' + 
			",id_driver = '" + idDriver + '\'' + 
			",longTuj = '" + longTuj + '\'' + 
			",level = '" + level + '\'' + 
			",totalHarga = '" + totalHarga + '\'' + 
			",lokasi_jemput = '" + lokasiJemput + '\'' + 
			",id_transaksi = '" + idTransaksi + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",latJem = '" + latJem + '\'' + 
			",tujuan = '" + tujuan + '\'' + 
			",latTuj = '" + latTuj + '\'' + 
			",nama = '" + nama + '\'' + 
			",foto = '" + foto + '\'' + 
			",endTime = '" + endTime + '\'' + 
			",longJem = '" + longJem + '\'' + 
			",status = '" + status + '\'' + 
			",username = '" + username + '\'' + 
			"}";
		}
}