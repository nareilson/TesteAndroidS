package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class GenerationVi{

	@SerializedName("omegaruby-alphasapphire")
	private OmegarubyAlphasapphire omegarubyAlphasapphire;

	@SerializedName("x-y")
	private XY xY;

	public void setOmegarubyAlphasapphire(OmegarubyAlphasapphire omegarubyAlphasapphire){
		this.omegarubyAlphasapphire = omegarubyAlphasapphire;
	}

	public OmegarubyAlphasapphire getOmegarubyAlphasapphire(){
		return omegarubyAlphasapphire;
	}

	public void setXY(XY xY){
		this.xY = xY;
	}

	public XY getXY(){
		return xY;
	}
}