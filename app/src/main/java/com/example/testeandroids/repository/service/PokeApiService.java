package com.example.testeandroids.repository.service;

import com.example.testeandroids.data.PokemonListResponse;
import com.example.testeandroids.data.pokemondata.PokemonResponse;
import com.example.testeandroids.data.typedata.TypeResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface PokeApiService {
    @GET("pokemon?&")
    Observable<PokemonListResponse> getPokemomList(@Query("limit") String valorInicio, @Query("offset") String valorLimit);
    @GET("pokemon/{name}")
    Observable<PokemonResponse> getPokemon(@Path("name") String pokeName);
    @GET("type/{type}")
    Observable<TypeResponse> getTypeDetails(@Path("type") String type);
}