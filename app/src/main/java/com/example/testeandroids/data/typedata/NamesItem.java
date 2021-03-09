package com.example.testeandroids.data.typedata;

import com.google.gson.annotations.SerializedName;

public class NamesItem{

	@SerializedName("name")
	private String name;

	@SerializedName("language")
	private Language language;

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setLanguage(Language language){
		this.language = language;
	}

	public Language getLanguage(){
		return language;
	}
}