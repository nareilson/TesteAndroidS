package com.example.testeandroids.data.implementacao;

import com.example.testeandroids.data.pokemondata.TypesItem;

public interface ITypeResourceBussines {
    int getColorType(String type);
    int getSrcType(String type);
    void eventClick(TypesItem typesItem);
}
