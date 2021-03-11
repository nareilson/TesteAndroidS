package com.example.testeandroids.bussines;

import com.example.testeandroids.R;
import com.example.testeandroids.bussines.implemetacao.IDescriptionPokemonActivityModel;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.data.pokemondata.PokemonResponse;
import com.example.testeandroids.repository.service.PokeApiService;
import com.example.testeandroids.repository.service.RetrofitService;

import io.reactivex.rxjava3.core.Observable;

public class DescriptionPokemonActivityModel implements IDescriptionPokemonActivityModel {
    private static IDescriptionPokemonActivityModel instance;
    private final PokeApiService service = new RetrofitService().getPokeApiService();
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

    @Override
    public int getSrcType(String type) {
        switch (type){
            case "bug":
                return R.drawable.ic_bug;
            case "ground":
                return  R.drawable.ic_ground;
            case "dark":
                return R.drawable.ic_dark;
            case "fire":
                return R.drawable.ic_fire;
            case "dragon":
                return R.drawable.ic_dragon;
            case "electric":
                return R.drawable.ic_electric;
            case "fairy":
                return R.drawable.ic_fairy;
            case "fighting":
                return R.drawable.ic_fighting;
            case "ghost":
                return R.drawable.ic_ghost;
            case "flying":
                return R.drawable.ic_flying;
            case "grass":
                return R.drawable.ic_grass;
            case "ice":
                return R.drawable.ic_ice;
            case "poison":
                return R.drawable.ic_poison;
            case "psychic":
                return R.drawable.ic_psychic;
            case "rock":
                return R.drawable.ic_rock;
            case "steel":
                return R.drawable.ic_steel;
            case "water":
                return R.drawable.ic_water;
            default:
                return R.drawable.ic_normal;
        }
    }

    @Override
    public int getColorType(String type) {
        switch (type){
            case "bug":
                return R.color.bug;
            case "ground":
                return  R.color.ground;
            case "dark":
                return R.color.cinza;
            case "dragon":
                return R.color.azul_escuro;
            case "electric":
                return R.color.electric;
            case "fairy":
                return R.color.fairy;
            case "fighting":
                return R.color.fighting;
            case "ghost":
                return R.color.purple_700;
            case "grass":
                return R.color.grass;
            case "ice":
                return R.color.ice;
            case "poison":
                return R.color.purple_200;
            case "psychic":
                return R.color.laranja;
            case "rock":
                return R.color.marrom_claro;
            case "steel":
                return R.color.teal_700;
            case "water":
                return R.color.azul;
            case "flying":
                return R.color.flyingp;
            case "fire":
                return R.color.fire;
            default:
                return R.color.black;
        }
    }
}
