package com.example.testeandroids.data.pokemondata;

import com.google.gson.annotations.SerializedName;

public class Versions{

	@SerializedName("generation-iii")
	private GenerationIii generationIii;

	@SerializedName("generation-ii")
	private GenerationIi generationIi;

	@SerializedName("generation-v")
	private GenerationV generationV;

	@SerializedName("generation-iv")
	private GenerationIv generationIv;

	@SerializedName("generation-vii")
	private GenerationVii generationVii;

	@SerializedName("generation-i")
	private GenerationI generationI;

	@SerializedName("generation-viii")
	private GenerationViii generationViii;

	@SerializedName("generation-vi")
	private GenerationVi generationVi;

	public void setGenerationIii(GenerationIii generationIii){
		this.generationIii = generationIii;
	}

	public GenerationIii getGenerationIii(){
		return generationIii;
	}

	public void setGenerationIi(GenerationIi generationIi){
		this.generationIi = generationIi;
	}

	public GenerationIi getGenerationIi(){
		return generationIi;
	}

	public void setGenerationV(GenerationV generationV){
		this.generationV = generationV;
	}

	public GenerationV getGenerationV(){
		return generationV;
	}

	public void setGenerationIv(GenerationIv generationIv){
		this.generationIv = generationIv;
	}

	public GenerationIv getGenerationIv(){
		return generationIv;
	}

	public void setGenerationVii(GenerationVii generationVii){
		this.generationVii = generationVii;
	}

	public GenerationVii getGenerationVii(){
		return generationVii;
	}

	public void setGenerationI(GenerationI generationI){
		this.generationI = generationI;
	}

	public GenerationI getGenerationI(){
		return generationI;
	}

	public void setGenerationViii(GenerationViii generationViii){
		this.generationViii = generationViii;
	}

	public GenerationViii getGenerationViii(){
		return generationViii;
	}

	public void setGenerationVi(GenerationVi generationVi){
		this.generationVi = generationVi;
	}

	public GenerationVi getGenerationVi(){
		return generationVi;
	}
}