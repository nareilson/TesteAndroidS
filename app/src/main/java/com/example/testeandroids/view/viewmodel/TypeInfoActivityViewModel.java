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
    private ArrayList<Type> listTitleDoubleDamageFrom = new ArrayList<>();
    private ArrayList<Type> listTitleDoubleDamageTo= new ArrayList<>();
    private ArrayList<Type> listTitleHalfDamageFrom = new ArrayList<>();
    private ArrayList<Type> listTitleHalfDamageTo= new ArrayList<>();
    private ArrayList<Type> listTitleNoDamageFrom = new ArrayList<>();
    private ArrayList<Type> listTitleNoDamageTo= new ArrayList<>();


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
        Type type = new Type();
        type.setName("double_damage_from");
        listTitleDoubleDamageFrom.add(type);
        return listTitleDoubleDamageFrom;
    }

    public ArrayList<Type> getListTitleDoubleDamageTo() {
        Type type = new Type();
        type.setName("double_damage_to");
        listTitleDoubleDamageFrom.add(type);
        return listTitleDoubleDamageTo;
    }

    public ArrayList<Type> getListTitleHalfDamageFrom() {
        Type type = new Type();
        type.setName("half_damage_from");
        listTitleHalfDamageFrom.add(type);
        return listTitleHalfDamageFrom;
    }

    public ArrayList<Type> getListTitleHalfDamageTo() {
        Type type = new Type();
        type.setName("half_damage_to");
        listTitleHalfDamageTo.add(type);
        return listTitleHalfDamageTo;
    }

    public ArrayList<Type> getListTitleNoDamageFrom() {
        Type type = new Type();
        type.setName("no_damage_from");
        listTitleNoDamageFrom.add(type);
        return listTitleNoDamageFrom;
    }

    public ArrayList<Type> getListTitleNoDamageTo() {
        Type type = new Type();
        type.setName("no_damage_to");
        listTitleNoDamageTo.add(type);
        return listTitleNoDamageTo;
    }
}
