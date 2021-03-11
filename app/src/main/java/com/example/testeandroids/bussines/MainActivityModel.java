package com.example.testeandroids.bussines;

import com.example.testeandroids.data.PokemonListResponse;
import com.example.testeandroids.bussines.implemetacao.IMainActivityModel;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.repository.service.PokeApiService;
import com.example.testeandroids.repository.service.RetrofitService;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public List<ResultsItem> serchViewRules(String newText,List<ResultsItem> tempList) {
        ArrayList<ResultsItem> filterTemp = new ArrayList<>();
        for(ResultsItem item:tempList){
            if(item.getName().toLowerCase().contains(newText)){
                filterTemp.add(item);
            }
        }
        return filterTemp;
    }
}
