package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class AbilitiesItem{

	@SerializedName("is_hidden")
	private boolean isHidden;

	@SerializedName("ability")
	private Ability ability;

	@SerializedName("slot")
	private int slot;

	public void setIsHidden(boolean isHidden){
		this.isHidden = isHidden;
	}

	public boolean isIsHidden(){
		return isHidden;
	}

	public void setAbility(Ability ability){
		this.ability = ability;
	}

	public Ability getAbility(){
		return ability;
	}

	public void setSlot(int slot){
		this.slot = slot;
	}

	public int getSlot(){
		return slot;
	}
}