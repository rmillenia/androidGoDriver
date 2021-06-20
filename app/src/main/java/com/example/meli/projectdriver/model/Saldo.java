package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class Saldo{

	@SerializedName("rekening")
	private String rekening;

	@SerializedName("id_user")
	private String idUser;

	@SerializedName("idSaldo")
	private String idSaldo;

	@SerializedName("saldoEpay")
	private String saldoEpay;

	@SerializedName("status")
	private String status;

	public  Saldo(){}

	public Saldo(String rekening, String idUser, String idSaldo, String saldoEpay, String status) {
		this.rekening = rekening;
		this.idUser = idUser;
		this.idSaldo = idSaldo;
		this.saldoEpay = saldoEpay;
		this.status = status;
	}

	public void setRekening(String rekening){
		this.rekening = rekening;
	}

	public String getRekening(){
		return rekening;
	}

	public void setIdUser(String idUser){
		this.idUser = idUser;
	}

	public String getIdUser(){
		return idUser;
	}

	public void setIdSaldo(String idSaldo){
		this.idSaldo = idSaldo;
	}

	public String getIdSaldo(){
		return idSaldo;
	}

	public void setSaldoEpay(String saldoEpay){
		this.saldoEpay = saldoEpay;
	}

	public String getSaldoEpay(){
		return saldoEpay;
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
			"Saldo{" + 
			"rekening = '" + rekening + '\'' + 
			",id_user = '" + idUser + '\'' + 
			",idSaldo = '" + idSaldo + '\'' + 
			",saldoEpay = '" + saldoEpay + '\'' + 
			",status = '" + status + '\'' + 
			"}";
		}
}