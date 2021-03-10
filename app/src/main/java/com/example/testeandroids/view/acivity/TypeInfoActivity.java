package com.example.testeandroids.view.acivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.testeandroids.R;
import com.example.testeandroids.data.implementacao.ITypeResourceBussines;
import com.example.testeandroids.data.pokemondata.TypesItem;
import com.example.testeandroids.databinding.ActivityTypeInfoBinding;
import com.example.testeandroids.view.adapter.PokTypeAdapterBody;
import com.example.testeandroids.view.adapter.PokTypeAdapterTitle;
import com.example.testeandroids.view.viewmodel.TypeInfoActivityViewModel;

public class TypeInfoActivity extends AppCompatActivity implements ITypeResourceBussines {

    ActivityTypeInfoBinding activityTypeInfoBinding;
    TypeInfoActivityViewModel viewModelTypeActivity;
    ProgressDialog progressDialog;
    PokTypeAdapterBody doubleDamageFrom;
    PokTypeAdapterBody doubleDamageTo;
    PokTypeAdapterBody halfDamageFrom;
    PokTypeAdapterBody halfDamageTo;
    PokTypeAdapterBody noDamageFrom;
    PokTypeAdapterBody noDamageTo;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTypeInfoBinding = DataBindingUtil.setContentView(this, R.layout.activity_type_info);
        viewModelTypeActivity = new ViewModelProvider(this).get(TypeInfoActivityViewModel.class);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.txt_carregando);
        progressDialog.show();
        TypesItem typesItem = (TypesItem) getIntent().getSerializableExtra("type");
        viewModelTypeActivity.getTypePokemon(typesItem.getType().getName());
        initAdapters();
        inittElementView(typesItem);
        observable();
    }

    private void initAdapters() {
        doubleDamageFrom = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        doubleDamageTo = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        halfDamageFrom = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        halfDamageTo = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        noDamageFrom = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        noDamageTo = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
    }

    @SuppressLint("UseCompatLoadingForDrawables")
    private void inittElementView(TypesItem typesItem) {
        activityTypeInfoBinding.rvTypes.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
        PokTypeAdapterTitle adapterTitleDamageFrom = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleDamageTo = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleHalfDamageTo = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleHaldDamageFrom = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleNoDamageFrom = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleNoDamageTo = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        activityTypeInfoBinding.cardView.setCardBackgroundColor(getResources().getColor(getColorType(typesItem.getType().getName())));
        activityTypeInfoBinding.imgLogo.setImageDrawable(getResources().getDrawable(getSrcType(typesItem.getType().getName())));

        ConcatAdapter concatAdapter = new ConcatAdapter(
                adapterTitleDamageFrom,
                doubleDamageFrom,
                adapterTitleDamageTo,
                doubleDamageTo,
                adapterTitleHaldDamageFrom,
                halfDamageFrom,
                adapterTitleHalfDamageTo,
                halfDamageTo,
                adapterTitleNoDamageFrom,
                noDamageFrom,
                adapterTitleNoDamageTo,
                noDamageTo);
        adapterTitleDamageFrom.submitList(viewModelTypeActivity.getListTitleDoubleDamageFrom());
        adapterTitleHaldDamageFrom.submitList(viewModelTypeActivity.getListTitleHalfDamageFrom());
        adapterTitleHalfDamageTo.submitList(viewModelTypeActivity.getListTitleHalfDamageTo());
        adapterTitleNoDamageFrom.submitList(viewModelTypeActivity.getListTitleNoDamageFrom());
        adapterTitleNoDamageTo.submitList(viewModelTypeActivity.getListTitleNoDamageTo());
        adapterTitleDamageTo.submitList(viewModelTypeActivity.getListTitleDoubleDamageTo());
        activityTypeInfoBinding.rvTypes.setAdapter(concatAdapter);
    }

    private void observable() {
        viewModelTypeActivity.getResponseTypePokemon().observe(this, result -> {
            doubleDamageFrom.submitList(result.getDamageRelations().getDoubleDamageFrom());
            doubleDamageTo.submitList(result.getDamageRelations().getDoubleDamageTo());
            halfDamageFrom.submitList(result.getDamageRelations().getHalfDamageFrom());
            halfDamageTo.submitList(result.getDamageRelations().getHalfDamageTo());
            noDamageFrom.submitList(result.getDamageRelations().getNoDamageFrom());
            noDamageTo.submitList(result.getDamageRelations().getNoDamageTo());
            progressDialog.dismiss();
        });
        viewModelTypeActivity.getRequestError().observe(this, error -> {
            progressDialog.dismiss();
            Toast.makeText(getBaseContext(), "Error: " + error.getLocalizedMessage(), Toast.LENGTH_LONG).show();
        });
    }

    @Override
    public int getColorType(String type) {
        return viewModelTypeActivity.getColorType(type);
    }

    @Override
    public int getSrcType(String type) {
        return viewModelTypeActivity.getSrcType(type);
    }
}