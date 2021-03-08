package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GameIndicesItem{

	@SerializedName("game_index")
	private int gameIndex;

	@SerializedName("version")
	private Version version;

	public void setGameIndex(int gameIndex){
		this.gameIndex = gameIndex;
	}

	public int getGameIndex(){
		return gameIndex;
	}

	public void setVersion(Version version){
		this.version = version;
	}

	public Version getVersion(){
		return version;
	}
}