package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class VersionGroupDetailsItem{

	@SerializedName("level_learned_at")
	private int levelLearnedAt;

	@SerializedName("version_group")
	private VersionGroup versionGroup;

	@SerializedName("move_learn_method")
	private MoveLearnMethod moveLearnMethod;

	public void setLevelLearnedAt(int levelLearnedAt){
		this.levelLearnedAt = levelLearnedAt;
	}

	public int getLevelLearnedAt(){
		return levelLearnedAt;
	}

	public void setVersionGroup(VersionGroup versionGroup){
		this.versionGroup = versionGroup;
	}

	public VersionGroup getVersionGroup(){
		return versionGroup;
	}

	public void setMoveLearnMethod(MoveLearnMethod moveLearnMethod){
		this.moveLearnMethod = moveLearnMethod;
	}

	public MoveLearnMethod getMoveLearnMethod(){
		return moveLearnMethod;
	}
}