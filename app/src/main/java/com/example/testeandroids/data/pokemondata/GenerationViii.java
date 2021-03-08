package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationViii{

	@SerializedName("icons")
	private Icons icons;

	public void setIcons(Icons icons){
		this.icons = icons;
	}

	public Icons getIcons(){
		return icons;
	}
}