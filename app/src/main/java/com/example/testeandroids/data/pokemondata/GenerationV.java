package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationV{

	@SerializedName("black-white")
	private BlackWhite blackWhite;

	public void setBlackWhite(BlackWhite blackWhite){
		this.blackWhite = blackWhite;
	}

	public BlackWhite getBlackWhite(){
		return blackWhite;
	}
}