package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class TypesItem implements Serializable {

	@SerializedName("slot")
	private int slot;

	@SerializedName("type")
	private Type type;

	public void setSlot(int slot){
		this.slot = slot;
	}

	public int getSlot(){
		return slot;
	}

	public void setType(Type type){
		this.type = type;
	}

	public Type getType(){
		return type;
	}
}