package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationI{

	@SerializedName("yellow")
	private Yellow yellow;

	@SerializedName("red-blue")
	private RedBlue redBlue;

	public void setYellow(Yellow yellow){
		this.yellow = yellow;
	}

	public Yellow getYellow(){
		return yellow;
	}

	public void setRedBlue(RedBlue redBlue){
		this.redBlue = redBlue;
	}

	public RedBlue getRedBlue(){
		return redBlue;
	}
}