package com.example.testeandroids.bussines.implemetacao;

import com.example.testeandroids.data.pokemondata.Type;
import com.example.testeandroids.data.typedata.TypeResponse;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;

public interface ITypeInfoActivityModel {
    Observable<TypeResponse> getTypeDetails(String type);
    ArrayList<Type> listTypeHeader(Type type);
    ArrayList<Type> listTitleDoubleDamageFrom();
    ArrayList<Type> listTitleDoubleDamageTo();
    ArrayList<Type> listTitleHalfDamageFrom();
    ArrayList<Type> listTitleHalfDamageTo();
    ArrayList<Type> listTitleNoDamageFrom();
    ArrayList<Type> listTitleNoDamageTo();
}
