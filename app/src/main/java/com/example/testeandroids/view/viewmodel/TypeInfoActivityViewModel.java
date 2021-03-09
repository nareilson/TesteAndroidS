package com.example.testeandroids.view.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeandroids.bussines.TypeInfoActivityModel;
import com.example.testeandroids.data.typedata.TypeResponse;

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

    public MutableLiveData<TypeResponse> getResponseTypePokemon() {
        return _responseTypePokemon;
    }

    public MutableLiveData<Throwable> getRequestError() {
        return _requestError;
    }
}
