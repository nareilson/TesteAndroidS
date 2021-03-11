package com.example.testeandroids.view.acivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.SearchView;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;
import com.example.testeandroids.R;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.data.implementacao.ListPokemonAdapterEventClick;
import com.example.testeandroids.databinding.ActivityMainBinding;
import com.example.testeandroids.view.adapter.ListPokemonAdapter;
import com.example.testeandroids.view.viewmodel.MainActivityViewModel;

import java.util.List;

public class MainActivity extends AppCompatActivity implements ListPokemonAdapterEventClick {
    private MainActivityViewModel mainActivityModel;
    private ActivityMainBinding activityMainBinding;
    private ListPokemonAdapter listPokemonAdapter;
    private ProgressDialog progressDialog;
    private final int VALOR_MINIMO_BUSCA = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mainActivityModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        listPokemonAdapter = new ListPokemonAdapter(new ListPokemonAdapter.ListPokemonDiffUtils(), this);
        initElemntView();
        observable();
    }

    private void initElemntView(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.txt_carregando));
        progressDialog.show();
        mainActivityModel.requestService(0,100);
        activityMainBinding.rvListPokemon.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
        activityMainBinding.rvListPokemon.setAdapter(listPokemonAdapter);
        activityMainBinding.searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                if(newText.length()>= VALOR_MINIMO_BUSCA){
                    List<ResultsItem> filterTemp = mainActivityModel.serchViewRules(newText);
                    if(filterTemp.isEmpty()){
                        Toast.makeText(getBaseContext(),getString(R.string.erro_ao_buscar_item),Toast.LENGTH_SHORT).show();
                    }
                    mainActivityModel.getListResultItemObservable().postValue(filterTemp);
                }else {
                    mainActivityModel.getListResultItemObservable().postValue(mainActivityModel.getCachTempAllListResult());
                }
                return false;
            }
        });
    }

    private void observable(){
        mainActivityModel.getRequestCaractersSucess().observe(this,result->{
            mainActivityModel.setTempAllistResult(result.getResults());
            mainActivityModel.getListResultItemObservable().postValue(result.getResults());
            progressDialog.dismiss();
        });

        mainActivityModel.getListResultItemObservable().observe(this,listPoke->{
            listPokemonAdapter.submitList(listPoke);
        });
        mainActivityModel.getRequetError().observe(this,error->{
            Toast.makeText(getBaseContext(), getString(R.string.alert_error,error.getLocalizedMessage()), Toast.LENGTH_SHORT).show();
            progressDialog.dismiss();
        });
    }

    @Override
    public void eventClick(ResultsItem item) {
        Intent intent = new Intent(this,DescriptionPokemonActivity.class);
        intent.putExtra(getString(R.string.intent_name_pokemon),item);
        startActivity(intent);
    }
}