package com.example.testeandroids.bussines.implemetacao;

import com.example.testeandroids.data.PokemonListResponse;
import com.example.testeandroids.data.ResultsItem;

import java.util.List;

import io.reactivex.rxjava3.core.Observable;

public interface IMainActivityModel {
     Observable<PokemonListResponse> getPokemomList(int valorInicio, int valorLimit);
     List<ResultsItem> serchViewRules(String newText,List<ResultsItem> tempList);
}
