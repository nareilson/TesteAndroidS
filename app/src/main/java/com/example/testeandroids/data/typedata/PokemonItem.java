package com.example.testeandroids.data.typedata;

import com.google.gson.annotations.SerializedName;

public class PokemonItem{

	@SerializedName("pokemon")
	private Pokemon pokemon;

	@SerializedName("slot")
	private int slot;

	public void setPokemon(Pokemon pokemon){
		this.pokemon = pokemon;
	}

	public Pokemon getPokemon(){
		return pokemon;
	}

	public void setSlot(int slot){
		this.slot = slot;
	}

	public int getSlot(){
		return slot;
	}
}