package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class Other{

	@SerializedName("dream_world")
	private DreamWorld dreamWorld;

	@SerializedName("official-artwork")
	private OfficialArtwork officialArtwork;

	public void setDreamWorld(DreamWorld dreamWorld){
		this.dreamWorld = dreamWorld;
	}

	public DreamWorld getDreamWorld(){
		return dreamWorld;
	}

	public void setOfficialArtwork(OfficialArtwork officialArtwork){
		this.officialArtwork = officialArtwork;
	}

	public OfficialArtwork getOfficialArtwork(){
		return officialArtwork;
	}
}