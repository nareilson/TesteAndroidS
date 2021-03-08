package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class Gold{

	@SerializedName("back_default")
	private String backDefault;

	@SerializedName("front_default")
	private String frontDefault;

	@SerializedName("back_shiny")
	private String backShiny;

	@SerializedName("front_shiny")
	private String frontShiny;

	public void setBackDefault(String backDefault){
		this.backDefault = backDefault;
	}

	public String getBackDefault(){
		return backDefault;
	}

	public void setFrontDefault(String frontDefault){
		this.frontDefault = frontDefault;
	}

	public String getFrontDefault(){
		return frontDefault;
	}

	public void setBackShiny(String backShiny){
		this.backShiny = backShiny;
	}

	public String getBackShiny(){
		return backShiny;
	}

	public void setFrontShiny(String frontShiny){
		this.frontShiny = frontShiny;
	}

	public String getFrontShiny(){
		return frontShiny;
	}
}