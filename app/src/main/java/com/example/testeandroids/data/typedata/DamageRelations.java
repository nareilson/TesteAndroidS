package com.example.testeandroids.data.typedata;

import java.util.List;

import com.example.testeandroids.data.pokemondata.Type;
import com.google.gson.annotations.SerializedName;

public class DamageRelations{

	@SerializedName("no_damage_from")
	private List<Type> noDamageFrom;

	@SerializedName("half_damage_from")
	private List<Type> halfDamageFrom;

	@SerializedName("no_damage_to")
	private List<Type> noDamageTo;

	@SerializedName("half_damage_to")
	private List<Type> halfDamageTo;

	@SerializedName("double_damage_to")
	private List<Type> doubleDamageTo;

	@SerializedName("double_damage_from")
	private List<Type> doubleDamageFrom;

	public void setNoDamageFrom(List<Type> noDamageFrom){
		this.noDamageFrom = noDamageFrom;
	}

	public List<Type> getNoDamageFrom(){
		return noDamageFrom;
	}

	public void setHalfDamageFrom(List<Type> halfDamageFrom){
		this.halfDamageFrom = halfDamageFrom;
	}

	public List<Type> getHalfDamageFrom(){
		return halfDamageFrom;
	}

	public void setNoDamageTo(List<Type> noDamageTo){
		this.noDamageTo = noDamageTo;
	}

	public List<Type> getNoDamageTo(){
		return noDamageTo;
	}

	public void setHalfDamageTo(List<Type> halfDamageTo){
		this.halfDamageTo = halfDamageTo;
	}

	public List<Type> getHalfDamageTo(){
		return halfDamageTo;
	}

	public void setDoubleDamageTo(List<Type> doubleDamageTo){
		this.doubleDamageTo = doubleDamageTo;
	}

	public List<Type> getDoubleDamageTo(){
		return doubleDamageTo;
	}

	public void setDoubleDamageFrom(List<Type> doubleDamageFrom){
		this.doubleDamageFrom = doubleDamageFrom;
	}

	public List<Type> getDoubleDamageFrom(){
		return doubleDamageFrom;
	}
}