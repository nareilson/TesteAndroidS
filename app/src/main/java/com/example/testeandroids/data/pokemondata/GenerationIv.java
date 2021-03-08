package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationIv{

	@SerializedName("platinum")
	private Platinum platinum;

	@SerializedName("diamond-pearl")
	private DiamondPearl diamondPearl;

	@SerializedName("heartgold-soulsilver")
	private HeartgoldSoulsilver heartgoldSoulsilver;

	public void setPlatinum(Platinum platinum){
		this.platinum = platinum;
	}

	public Platinum getPlatinum(){
		return platinum;
	}

	public void setDiamondPearl(DiamondPearl diamondPearl){
		this.diamondPearl = diamondPearl;
	}

	public DiamondPearl getDiamondPearl(){
		return diamondPearl;
	}

	public void setHeartgoldSoulsilver(HeartgoldSoulsilver heartgoldSoulsilver){
		this.heartgoldSoulsilver = heartgoldSoulsilver;
	}

	public HeartgoldSoulsilver getHeartgoldSoulsilver(){
		return heartgoldSoulsilver;
	}
}