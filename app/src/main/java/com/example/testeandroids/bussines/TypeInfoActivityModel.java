package com.example.testeandroids.bussines;

import com.example.testeandroids.bussines.implemetacao.ITypeInfoActivityModel;
import com.example.testeandroids.data.pokemondata.Type;
import com.example.testeandroids.data.typedata.TypeResponse;
import com.example.testeandroids.repository.service.PokeApiService;
import com.example.testeandroids.repository.service.RetrofitService;

import java.util.ArrayList;

import io.reactivex.rxjava3.core.Observable;

public class TypeInfoActivityModel implements ITypeInfoActivityModel {
    private static ITypeInfoActivityModel instance;
    private final PokeApiService service = new RetrofitService().getPokeApiService();

    private TypeInfoActivityModel() {
    }

    public static ITypeInfoActivityModel getInstance() {
        if (instance == null) {
            instance = new TypeInfoActivityModel();
        }
        return instance;
    }

    @Override
    public Observable<TypeResponse> getTypeDetails(String type) {
        return service.getTypeDetails(type);
    }

    @Override
    public ArrayList<Type> listTypeHeader(Type type) {
        ArrayList<Type> list = new ArrayList<>();
        list.add(type);
        return list;
    }

    @Override
    public ArrayList<Type> listTitleDoubleDamageFrom() {
        ArrayList<Type> list = new ArrayList<>();
        Type type = new Type();
        type.setName("Recebe dano duplo em:");
        list.add(type);
        return list;
    }

    @Override
    public ArrayList<Type> listTitleDoubleDamageTo() {
        ArrayList<Type> list = new ArrayList<>();
        Type type = new Type();
        type.setName("Causa Dano Duplo em:");
        list.add(type);
        return list;
    }

    @Override
    public ArrayList<Type> listTitleHalfDamageFrom() {
        ArrayList<Type> list = new ArrayList<>();
        Type type = new Type();
        type.setName("Recebe dano reduzido em:");
        list.add(type);
        return list;
    }

    @Override
    public ArrayList<Type> listTitleHalfDamageTo() {
        ArrayList<Type> list = new ArrayList<>();
        Type type = new Type();
        type.setName("Causa dano reduzido em:");
        list.add(type);
        return list;
    }

    @Override
    public ArrayList<Type> listTitleNoDamageFrom() {
        ArrayList<Type> list = new ArrayList<>();
        Type type = new Type();
        type.setName("Não recebe dano de:");
        list.add(type);
        return list;
    }

    @Override
    public ArrayList<Type> listTitleNoDamageTo() {
        ArrayList<Type> list = new ArrayList<>();
        Type type = new Type();
        type.setName("Não causa dano em:");
        list.add(type);
        return list;
    }
}
