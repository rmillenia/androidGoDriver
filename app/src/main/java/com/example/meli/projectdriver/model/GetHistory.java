package com.example.meli.projectdriver.model;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class GetHistory {

	@SerializedName("status")
	String status;

	@SerializedName("result")
	private List<History> result;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public void setResult(List<History> result){
		this.result = result;
	}

	public List<History> getResult(){
		return result;
	}

	@Override
 	public String toString(){
		return 
			"GetHistory{" +
			"status = '" + status + '\'' +
			",result = '" + result + '\'' + 
			"}";
		}
}