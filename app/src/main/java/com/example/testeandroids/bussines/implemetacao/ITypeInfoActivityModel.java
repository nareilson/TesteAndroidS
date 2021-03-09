package com.example.testeandroids.bussines.implemetacao;

import com.example.testeandroids.data.typedata.TypeResponse;

import io.reactivex.rxjava3.core.Observable;

public interface ITypeInfoActivityModel {
    Observable<TypeResponse> getTypeDetails(String type);
}
