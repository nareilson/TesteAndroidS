package com.example.testeandroids.data.pokemondata;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class MovesItem{

	@SerializedName("version_group_details")
	private List<VersionGroupDetailsItem> versionGroupDetails;

	@SerializedName("move")
	private Move move;

	public void setVersionGroupDetails(List<VersionGroupDetailsItem> versionGroupDetails){
		this.versionGroupDetails = versionGroupDetails;
	}

	public List<VersionGroupDetailsItem> getVersionGroupDetails(){
		return versionGroupDetails;
	}

	public void setMove(Move move){
		this.move = move;
	}

	public Move getMove(){
		return move;
	}
}