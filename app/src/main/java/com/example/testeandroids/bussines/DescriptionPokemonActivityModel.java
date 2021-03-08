package com.example.testeandroids.bussines;

import com.example.testeandroids.bussines.implemetacao.IDescriptionPokemonActivityModel;
import com.example.testeandroids.data.pokemondata.PokemonResponse;
import com.example.testeandroids.repository.service.PokeApiService;
import com.example.testeandroids.repository.service.RetrofitService;

import io.reactivex.rxjava3.core.Observable;

public class DescriptionPokemonActivityModel implements IDescriptionPokemonActivityModel {
    private static IDescriptionPokemonActivityModel instance;
    private final PokeApiService service = new RetrofitService().getDbzService();
    private DescriptionPokemonActivityModel(){}

    public static IDescriptionPokemonActivityModel getInstance(){
        if(instance == null){
            instance = new DescriptionPokemonActivityModel();
        }
        return instance;
    }

    @Override
    public Observable<PokemonResponse> getPokemon(String pokeName) {
        return service.getPokemon(pokeName);
    }
}
