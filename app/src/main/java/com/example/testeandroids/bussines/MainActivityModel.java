package com.example.testeandroids.bussines;

import com.example.testeandroids.data.PokemonListResponse;
import com.example.testeandroids.bussines.implemetacao.IMainActivityModel;
import com.example.testeandroids.repository.service.PokeApiService;
import com.example.testeandroids.repository.service.RetrofitService;

import io.reactivex.rxjava3.core.Observable;

public class MainActivityModel implements IMainActivityModel {
   private static IMainActivityModel instance;
   private MainActivityModel(){}
   private final PokeApiService service = new RetrofitService().getPokeApiService();

    public static IMainActivityModel getInstance(){
        if(instance == null){
            instance = new MainActivityModel();
        }
        return instance;
    }

    @Override
    public Observable<PokemonListResponse> getPokemomList(int valorInicio, int valorLimit) {
        return service.getPokemomList(String.valueOf(valorInicio),String.valueOf(valorLimit));
    }
}
