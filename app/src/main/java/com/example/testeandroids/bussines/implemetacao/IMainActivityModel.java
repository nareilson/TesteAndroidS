package com.example.testeandroids.bussines.implemetacao;

import com.example.testeandroids.data.PokemonListResponse;

import io.reactivex.rxjava3.core.Observable;

public interface IMainActivityModel {
     Observable<PokemonListResponse> getPokemomList(int valorInicio, int valorLimit);
}
