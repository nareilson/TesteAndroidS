package com.example.testeandroids.bussines.implemetacao;

import com.example.testeandroids.data.pokemondata.PokemonResponse;
import io.reactivex.rxjava3.core.Observable;

public interface IDescriptionPokemonActivityModel {
    Observable<PokemonResponse> getPokemon(String pokeName);
}
