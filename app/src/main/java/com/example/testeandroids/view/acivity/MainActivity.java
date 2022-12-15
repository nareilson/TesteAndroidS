package com.example.testeandroids.view.acivity;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;
import com.example.testeandroids.R;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.data.implementacao.ListPokemonAdapterEventClick;
import com.example.testeandroids.databinding.ActivityMainBinding;
import com.example.testeandroids.view.adapter.ListPokemonAdapter;
import com.example.testeandroids.view.viewmodel.MainActivityViewModel;

/*
     Link do Desafio
     https://www.dropbox.com/s/cfggf15f4d42efz/Teste%20Android.pdf?dl=0
     */
public class MainActivity extends AppCompatActivity implements ListPokemonAdapterEventClick {
    private MainActivityViewModel mainActivityModel;
    private ActivityMainBinding activityMainBinding;
    private ListPokemonAdapter listPokemonAdapter;
    private ProgressDialog progressDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.txt_carregando));
        mainActivityModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        listPokemonAdapter = new ListPokemonAdapter(new ListPokemonAdapter.ListPokemonDiffUtils(), this);
        progressDialog.show();
        mainActivityModel.requestService(0,50);
        initElemntView();
        observable();
    }

    private void initElemntView(){
        activityMainBinding.rvListPokemon.setLayoutManager(new LinearLayoutManager(getBaseContext(),LinearLayoutManager.VERTICAL,false));
        activityMainBinding.rvListPokemon.setAdapter(listPokemonAdapter);
        activityMainBinding.rvListPokemon.addOnLayoutChangeListener(new View.OnLayoutChangeListener() {
            @Override
            public void onLayoutChange(View v, int left, int top, int right, int bottom, int oldLeft, int oldTop, int oldRight, int oldBottom) {

            }
        });
    }

    private void observable(){
        mainActivityModel.getRequestCaractersSucess().observe(this,result->{
            listPokemonAdapter.submitList(result.getResults());
            progressDialog.dismiss();
        });
        mainActivityModel.getRequetError().observe(this,error->{
            Toast.makeText(getBaseContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        });
    }

    @Override
    public void eventClick(ResultsItem item) {
        Intent intent = new Intent(this,DescriptionPokemonActivity.class);
        intent.putExtra("pokemon",item);
        startActivity(intent);
    }

}