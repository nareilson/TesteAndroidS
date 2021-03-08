package com.example.testeandroids.data.pokemondata;

import java.util.List;
import com.google.gson.annotations.SerializedName;

public class HeldItemsItem{

	@SerializedName("item")
	private Item item;

	@SerializedName("version_details")
	private List<VersionDetailsItem> versionDetails;

	public void setItem(Item item){
		this.item = item;
	}

	public Item getItem(){
		return item;
	}

	public void setVersionDetails(List<VersionDetailsItem> versionDetails){
		this.versionDetails = versionDetails;
	}

	public List<VersionDetailsItem> getVersionDetails(){
		return versionDetails;
	}
}