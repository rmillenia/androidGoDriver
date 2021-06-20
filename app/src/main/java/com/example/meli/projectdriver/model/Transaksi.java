package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class Transaksi {

	@SerializedName("longTuj")
	private String longTuj;

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

	@SerializedName("startTime")
	private String startTime;

	@SerializedName("endTime")
	private String endTime;

	@SerializedName("longJem")
	private String longJem;

	@SerializedName("id_driver")
	private String idDriver;

	@SerializedName("status")
	private String status;


	public  Transaksi(){}

	public Transaksi(String longTuj, String totalHarga, String lokasiJemput, String idTransaksi, String idUser, String latJem, String tujuan, String latTuj, String startTime, String endTime, String longJem, String idDriver, String status) {
		this.longTuj = longTuj;
		this.totalHarga = totalHarga;
		this.lokasiJemput = lokasiJemput;
		this.idTransaksi = idTransaksi;
		this.idUser = idUser;
		this.latJem = latJem;
		this.tujuan = tujuan;
		this.latTuj = latTuj;
		this.startTime = startTime;
		this.endTime = endTime;
		this.longJem = longJem;
		this.idDriver = idDriver;
		this.status = status;
	}

	public void setLongTuj(String longTuj){
		this.longTuj = longTuj;
	}

	public String getLongTuj(){
		return longTuj;
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

	public void setStartTime(String startTime){
		this.startTime = startTime;
	}

	public String getStartTime(){
		return startTime;
	}

	public void setEndTime(String endTime){
		this.endTime = endTime;
	}

	public String getEndTime(){
		return endTime;
	}

	public void setLongJem(String longJem){
		this.longJem = longJem;
	}

	public String getLongJem(){
		return longJem;
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

	@Override
 	public String toString(){
		return 
			"Transaksi{" +
			"longTuj = '" + longTuj + '\'' + 
			",totalHarga = '" + totalHarga + '\'' + 
			",lokasi_jemput = '" + lokasiJemput + '\'' + 
			",id_transaksi = '" + idTransaksi + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",latJem = '" + latJem + '\'' + 
			",tujuan = '" + tujuan + '\'' + 
			",latTuj = '" + latTuj + '\'' + 
			",startTime = '" + startTime + '\'' + 
			",endTime = '" + endTime + '\'' + 
			",longJem = '" + longJem + '\'' + 
			",id_driver = '" + idDriver + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}