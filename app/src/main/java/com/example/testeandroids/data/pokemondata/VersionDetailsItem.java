package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class VersionDetailsItem{

	@SerializedName("version")
	private Version version;

	@SerializedName("rarity")
	private int rarity;

	public void setVersion(Version version){
		this.version = version;
	}

	public Version getVersion(){
		return version;
	}

	public void setRarity(int rarity){
		this.rarity = rarity;
	}

	public int getRarity(){
		return rarity;
	}
}