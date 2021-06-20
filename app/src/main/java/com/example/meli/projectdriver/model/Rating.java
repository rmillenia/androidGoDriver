package com.example.meli.projectdriver.model;

import com.google.gson.annotations.SerializedName;

public class Rating{

	@SerializedName("transaksi_id")
	private String transaksiId;

	@SerializedName("rating")
	private String rating;

	public void setTransaksiId(String transaksiId){
		this.transaksiId = transaksiId;
	}

	public String getTransaksiId(){
		return transaksiId;
	}

	public void setRating(String rating){
		this.rating = rating;
	}

	public String getRating(){
		return rating;
	}

	@Override
 	public String toString(){
		return 
			"Rating{" + 
			"transaksi_id = '" + transaksiId + '\'' + 
			",rating = '" + rating + '\'' + 
			"}";
		}
}