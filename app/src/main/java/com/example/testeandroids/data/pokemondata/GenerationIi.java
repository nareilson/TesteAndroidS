package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationIi{

	@SerializedName("gold")
	private Gold gold;

	@SerializedName("crystal")
	private Crystal crystal;

	@SerializedName("silver")
	private Silver silver;

	public void setGold(Gold gold){
		this.gold = gold;
	}

	public Gold getGold(){
		return gold;
	}

	public void setCrystal(Crystal crystal){
		this.crystal = crystal;
	}

	public Crystal getCrystal(){
		return crystal;
	}

	public void setSilver(Silver silver){
		this.silver = silver;
	}

	public Silver getSilver(){
		return silver;
	}
}