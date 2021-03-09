package com.example.testeandroids.bussines;

import com.example.testeandroids.bussines.implemetacao.ITypeInfoActivityModel;
import com.example.testeandroids.data.typedata.TypeResponse;
import com.example.testeandroids.repository.service.PokeApiService;
import com.example.testeandroids.repository.service.RetrofitService;

import io.reactivex.rxjava3.core.Observable;

public class TypeInfoActivityModel implements ITypeInfoActivityModel {
    private static ITypeInfoActivityModel instance;
    private final PokeApiService service = new RetrofitService().getPokeApiService();
    private TypeInfoActivityModel(){}

    public static ITypeInfoActivityModel getInstance() {
        if(instance == null){
            instance = new TypeInfoActivityModel();
        }
        return instance;
    }

    @Override
    public Observable<TypeResponse> getTypeDetails(String type) {
        return service.getTypeDetails(type);
    }
}
