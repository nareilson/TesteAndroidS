package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationVii{

	@SerializedName("icons")
	private Icons icons;

	@SerializedName("ultra-sun-ultra-moon")
	private UltraSunUltraMoon ultraSunUltraMoon;

	public void setIcons(Icons icons){
		this.icons = icons;
	}

	public Icons getIcons(){
		return icons;
	}

	public void setUltraSunUltraMoon(UltraSunUltraMoon ultraSunUltraMoon){
		this.ultraSunUltraMoon = ultraSunUltraMoon;
	}

	public UltraSunUltraMoon getUltraSunUltraMoon(){
		return ultraSunUltraMoon;
	}
}