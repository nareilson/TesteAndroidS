package com.example.testeandroids.data.typedata;

import java.util.List;

import com.example.testeandroids.data.pokemondata.Type;
import com.google.gson.annotations.SerializedName;

public class TypeResponse{

	@SerializedName("generation")
	private Type generation;

	@SerializedName("game_indices")
	private List<GameIndicesItem> gameIndices;

	@SerializedName("move_damage_class")
	private Type moveDamageClass;

	@SerializedName("names")
	private List<NamesItem> names;

	@SerializedName("pokemon")
	private List<PokemonItem> pokemon;

	@SerializedName("damage_relations")
	private DamageRelations damageRelations;

	@SerializedName("moves")
	private List<Type> moves;

	@SerializedName("name")
	private String name;

	@SerializedName("id")
	private int id;

	public void setGeneration(Type generation){
		this.generation = generation;
	}

	public Type getGeneration(){
		return generation;
	}

	public void setGameIndices(List<GameIndicesItem> gameIndices){
		this.gameIndices = gameIndices;
	}

	public List<GameIndicesItem> getGameIndices(){
		return gameIndices;
	}

	public void setMoveDamageClass(Type moveDamageClass){
		this.moveDamageClass = moveDamageClass;
	}

	public Type getMoveDamageClass(){
		return moveDamageClass;
	}

	public void setNames(List<NamesItem> names){
		this.names = names;
	}

	public List<NamesItem> getNames(){
		return names;
	}

	public void setPokemon(List<PokemonItem> pokemon){
		this.pokemon = pokemon;
	}

	public List<PokemonItem> getPokemon(){
		return pokemon;
	}

	public void setDamageRelations(DamageRelations damageRelations){
		this.damageRelations = damageRelations;
	}

	public DamageRelations getDamageRelations(){
		return damageRelations;
	}

	public void setMoves(List<Type> moves){
		this.moves = moves;
	}

	public List<Type> getMoves(){
		return moves;
	}

	public void setName(String name){
		this.name = name;
	}

	public String getName(){
		return name;
	}

	public void setId(int id){
		this.id = id;
	}

	public int getId(){
		return id;
	}
}