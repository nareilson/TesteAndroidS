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
import com.example.testeandroids.data.pokemondata.Type;
import com.example.testeandroids.data.pokemondata.TypesItem;
import com.example.testeandroids.databinding.ActivityTypeInfoBinding;
import com.example.testeandroids.view.adapter.PokTypeAdapterBody;
import com.example.testeandroids.view.adapter.PokTypeAdapterHeader;
import com.example.testeandroids.view.adapter.PokTypeAdapterTitle;
import com.example.testeandroids.view.viewmodel.TypeInfoActivityViewModel;

public class TypeInfoActivity extends AppCompatActivity implements ITypeResourceBussines {

    ActivityTypeInfoBinding activityTypeInfoBinding;
    TypeInfoActivityViewModel viewModelTypeActivity;
    ProgressDialog progressDialog;
    PokTypeAdapterHeader adapterHeader;
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
        TypesItem typesItem = (TypesItem) getIntent().getSerializableExtra(getString(R.string.intent_name_type));
        initElementView(typesItem.getType());
        observable();
    }

    private void initElementView(Type type) {
        initAdaptersAndRecyclerView(type);
        initProgessDialog();
        progressDialog.show();
        viewModelTypeActivity.getTypePokemon(type.getName());
    }

    private void initProgessDialog(){
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.txt_carregando);
    }

    private void initAdaptersAndRecyclerView(Type type) {
        adapterHeader = new PokTypeAdapterHeader(new PokTypeAdapterHeader.DiffUtilsHeader(),this);
        doubleDamageFrom = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        doubleDamageTo = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        halfDamageFrom = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        halfDamageTo = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        noDamageFrom = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);
        noDamageTo = new PokTypeAdapterBody(new PokTypeAdapterBody.typeDiffUltil(), this);

        PokTypeAdapterTitle adapterTitleDamageFrom = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleDamageTo = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleHalfDamageTo = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleHaldDamageFrom = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleNoDamageFrom = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());
        PokTypeAdapterTitle adapterTitleNoDamageTo = new PokTypeAdapterTitle(new PokTypeAdapterTitle.typeDiffUltil());

        ConcatAdapter concatAdapter = new ConcatAdapter(
                adapterHeader,
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

        activityTypeInfoBinding.rvTypes.setLayoutManager(new LinearLayoutManager(getBaseContext(), LinearLayoutManager.VERTICAL, false));
        activityTypeInfoBinding.rvTypes.setAdapter(concatAdapter);

        adapterHeader.submitList(viewModelTypeActivity.getListTypeHeader(type));
        adapterTitleDamageFrom.submitList(viewModelTypeActivity.getListTitleDoubleDamageFrom());
        adapterTitleDamageTo.submitList(viewModelTypeActivity.getListTitleDoubleDamageTo());
        adapterTitleHaldDamageFrom.submitList(viewModelTypeActivity.getListTitleHalfDamageFrom());
        adapterTitleHalfDamageTo.submitList(viewModelTypeActivity.getListTitleHalfDamageTo());
        adapterTitleNoDamageFrom.submitList(viewModelTypeActivity.getListTitleNoDamageFrom());
        adapterTitleNoDamageTo.submitList(viewModelTypeActivity.getListTitleNoDamageTo());
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
            Toast.makeText(getBaseContext(), getString(R.string.alert_error,error.getLocalizedMessage()), Toast.LENGTH_LONG).show();
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