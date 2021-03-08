package com.example.testeandroids.view.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeandroids.data.PokemonListResponse;
import com.example.testeandroids.bussines.MainActivityModel;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<Throwable> _requetError = new MutableLiveData<>();
    private final MutableLiveData<PokemonListResponse> _requestCaractersSucess = new MutableLiveData<>();
    public void requestService(int valorIncio, int valorLimit){
        compositeDisposable.add(
                MainActivityModel
                        .getInstance()
                        .getPokemomList(valorIncio, valorLimit)
                        .observeOn(Schedulers.newThread())
                        .subscribe(_requestCaractersSucess::postValue, _requetError::postValue));
    }

    public MutableLiveData<Throwable> getRequetError() {
        return _requetError;
    }

    public MutableLiveData<PokemonListResponse> getRequestCaractersSucess() {
        return _requestCaractersSucess;
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
