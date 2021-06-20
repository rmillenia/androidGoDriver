package com.example.meli.projectdriver.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class PostTransaksi {

	@SerializedName("result")
	private List<Transaksi> result;
	@SerializedName("status")
	String status;
	@SerializedName("message")
	String message;



	public void setResult(List<Transaksi> result){
		this.result = result;
	}

	public List<Transaksi> getResult(){
		return result;
	}

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

	@Override
 	public String toString(){
		return 
			"PostTransaksi{" +
			"result = '" + result + '\'' + 
			"}";
		}
}