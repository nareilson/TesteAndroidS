package com.example.testeandroids.data.typedata;

import com.example.testeandroids.data.pokemondata.Type;
import com.google.gson.annotations.SerializedName;

public class GameIndicesItem{

	@SerializedName("generation")
	private Type generation;

	@SerializedName("game_index")
	private int gameIndex;

	public void setGeneration(Type generation){
		this.generation = generation;
	}

	public Type getGeneration(){
		return generation;
	}

	public void setGameIndex(int gameIndex){
		this.gameIndex = gameIndex;
	}

	public int getGameIndex(){
		return gameIndex;
	}
}