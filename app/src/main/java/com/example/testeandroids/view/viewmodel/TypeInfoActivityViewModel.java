package com.example.testeandroids.view.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeandroids.bussines.DescriptionPokemonActivityModel;
import com.example.testeandroids.bussines.TypeInfoActivityModel;
import com.example.testeandroids.data.pokemondata.Type;
import com.example.testeandroids.data.typedata.TypeResponse;

import java.util.ArrayList;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class TypeInfoActivityViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    MutableLiveData<TypeResponse> _responseTypePokemon = new MutableLiveData<>();
    MutableLiveData<Throwable> _requestError = new MutableLiveData<>();

    public void getTypePokemon(String type){
        compositeDisposable.add(TypeInfoActivityModel
                .getInstance()
                .getTypeDetails(type)
                .observeOn(Schedulers.newThread())
                .subscribe(_responseTypePokemon::postValue,_requestError::postValue));
    }
    public int getColorType(String type){
       return DescriptionPokemonActivityModel.getInstance().getColorType(type);
    }

    public int getSrcType(String type) {
        return DescriptionPokemonActivityModel.getInstance().getSrcType(type);
    }


    public MutableLiveData<TypeResponse> getResponseTypePokemon() {
        return _responseTypePokemon;
    }

    public MutableLiveData<Throwable> getRequestError() {
        return _requestError;
    }

    public ArrayList<Type> getListTitleDoubleDamageFrom() {
        return TypeInfoActivityModel.getInstance().listTitleDoubleDamageFrom();
    }

    public ArrayList<Type> getListTitleDoubleDamageTo() {
        return TypeInfoActivityModel.getInstance().listTitleDoubleDamageTo();
    }

    public ArrayList<Type> getListTitleHalfDamageFrom() {
        return TypeInfoActivityModel.getInstance().listTitleHalfDamageFrom();
    }

    public ArrayList<Type> getListTitleHalfDamageTo() {
        return TypeInfoActivityModel.getInstance().listTitleHalfDamageTo();
    }

    public ArrayList<Type> getListTitleNoDamageFrom() {
        return TypeInfoActivityModel.getInstance().listTitleNoDamageFrom();
    }

    public ArrayList<Type> getListTitleNoDamageTo() {
        return TypeInfoActivityModel.getInstance().listTitleNoDamageTo();
    }

    public ArrayList<Type> getListTypeHeader(Type type) {
        return TypeInfoActivityModel.getInstance().listTypeHeader(type);
    }
    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
