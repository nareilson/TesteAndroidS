package com.example.testeandroids.data;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ResultsItem implements Serializable {

	@SerializedName("name")
	private String name;

	@SerializedName("url")
	private String url;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setUrl(String url){
		this.url = url;
	}

	public String getUrl(){
		return url;
	}
}