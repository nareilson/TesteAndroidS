package com.example.testeandroids.view.viewmodel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeandroids.bussines.DescriptionPokemonActivityModel;
import com.example.testeandroids.data.pokemondata.PokemonResponse;
import com.example.testeandroids.view.acivity.DescriptionPokemonActivity;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class DescriptionPokemonActivityViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<PokemonResponse> _resultRerquestPokemon = new MutableLiveData<>();
    private final MutableLiveData<Throwable> _errorRequest = new MutableLiveData<>();
    public void requestPokemon(String name){
        compositeDisposable.add(DescriptionPokemonActivityModel
                .getInstance()
                .getPokemon(name)
                .observeOn(Schedulers.newThread())
                .subscribe(_resultRerquestPokemon::postValue,_errorRequest::postValue));
    }

    public int getSrcType(String type){
        return DescriptionPokemonActivityModel.getInstance().getSrcType(type);
    }

    public int getColorType(String type){
        return DescriptionPokemonActivityModel.getInstance().getColorType(type);
    }

    public LiveData<PokemonResponse> getResultRerquestPokemon() {
        return _resultRerquestPokemon;
    }

    public LiveData<Throwable> getErrorRequest() {
        return _errorRequest;
    }
}
