package com.example.testeandroids.view.viewmodel;

import android.widget.Toast;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testeandroids.R;
import com.example.testeandroids.data.PokemonListResponse;
import com.example.testeandroids.bussines.MainActivityModel;
import com.example.testeandroids.data.ResultsItem;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.rxjava3.disposables.CompositeDisposable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MainActivityViewModel extends ViewModel {
    private final CompositeDisposable compositeDisposable = new CompositeDisposable();
    private final MutableLiveData<Throwable> _requetError = new MutableLiveData<>();
    private final MutableLiveData<PokemonListResponse> _requestCaractersSucess = new MutableLiveData<>();
    private final MutableLiveData<List<ResultsItem>> _listResultItemObservable = new MutableLiveData<>();
    private final ArrayList<ResultsItem> cachTempAllListResult = new ArrayList<>();
    public void requestService(int valorIncio, int valorLimit){
        compositeDisposable.add(
                MainActivityModel
                        .getInstance()
                        .getPokemomList(valorIncio, valorLimit)
                        .observeOn(Schedulers.newThread())
                        .subscribe(_requestCaractersSucess::postValue, _requetError::postValue));
    }

    public MutableLiveData<List<ResultsItem>> getListResultItemObservable() {
        return _listResultItemObservable;
    }

    public MutableLiveData<Throwable> getRequetError() {
        return _requetError;
    }

    public MutableLiveData<PokemonListResponse> getRequestCaractersSucess() {
        return _requestCaractersSucess;
    }

    public ArrayList<ResultsItem> getCachTempAllListResult() {
        return cachTempAllListResult;
    }

    public void setTempAllistResult(List<ResultsItem> list){
        cachTempAllListResult.clear();
        cachTempAllListResult.addAll(list);
    }

    public List<ResultsItem> serchViewRules(String newText){
       return MainActivityModel.getInstance().serchViewRules(newText,getCachTempAllListResult());
    }

    @Override
    protected void onCleared() {
        super.onCleared();
        compositeDisposable.dispose();
    }
}
