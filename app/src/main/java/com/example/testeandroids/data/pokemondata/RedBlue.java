package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class RedBlue{

	@SerializedName("front_gray")
	private String frontGray;

	@SerializedName("back_default")
	private String backDefault;

	@SerializedName("back_gray")
	private String backGray;

	@SerializedName("front_default")
	private String frontDefault;

	public void setFrontGray(String frontGray){
		this.frontGray = frontGray;
	}

	public String getFrontGray(){
		return frontGray;
	}

	public void setBackDefault(String backDefault){
		this.backDefault = backDefault;
	}

	public String getBackDefault(){
		return backDefault;
	}

	public void setBackGray(String backGray){
		this.backGray = backGray;
	}

	public String getBackGray(){
		return backGray;
	}

	public void setFrontDefault(String frontDefault){
		this.frontDefault = frontDefault;
	}

	public String getFrontDefault(){
		return frontDefault;
	}
}