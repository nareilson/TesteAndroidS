package com.example.testeandroids.view.acivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.util.Log;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.Toast;

import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.LottieCompositionFactory;
import com.airbnb.lottie.LottieDrawable;
import com.bumptech.glide.Glide;
import com.example.testeandroids.R;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.data.implementacao.ITypeResourceBussines;
import com.example.testeandroids.data.implementacao.ITypeResourceEventClick;
import com.example.testeandroids.data.pokemondata.TypesItem;
import com.example.testeandroids.databinding.ActivityDescriptionPokemonBinding;
import com.example.testeandroids.view.adapter.ListTypePokemon;
import com.example.testeandroids.view.viewmodel.DescriptionPokemonActivityViewModel;

public class DescriptionPokemonActivity extends AppCompatActivity implements ITypeResourceBussines, ITypeResourceEventClick {
    private ActivityDescriptionPokemonBinding activityDescriptionPokemonBinding;
    private DescriptionPokemonActivityViewModel viewModelDescriptionActivity;
    private ListTypePokemon listTypePokemon;
    private ProgressDialog progressDialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDescriptionPokemonBinding = DataBindingUtil.setContentView(this,R.layout.activity_description_pokemon);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(getString(R.string.txt_carregando));
        listTypePokemon = new ListTypePokemon(new ListTypePokemon.DiffUtilsTypePokemo(),this,this);
        viewModelDescriptionActivity = new ViewModelProvider(this).get(DescriptionPokemonActivityViewModel.class);
        ResultsItem resultsItem = (ResultsItem) getIntent().getSerializableExtra("pokemon");
        progressDialog.show();
        viewModelDescriptionActivity.requestPokemon(resultsItem.getName());
        initItemView();
        observable();
    }

    private void observable(){
        viewModelDescriptionActivity.getResultRerquestPokemon().observe(this,pokemonResponse -> {
            activityDescriptionPokemonBinding.title.setText(pokemonResponse.getName());
            activityDescriptionPokemonBinding.pesoInfo.setText(String.valueOf(pokemonResponse.getWeight()));
            activityDescriptionPokemonBinding.alturaInfo.setText(String.valueOf(pokemonResponse.getHeight()));
            activityDescriptionPokemonBinding.xpBaseInfo.setText(String.valueOf(pokemonResponse.getBaseExperience()));
            listTypePokemon.submitList(pokemonResponse.getTypes());
            Glide.with(activityDescriptionPokemonBinding.pokemonImg)
                    .load(pokemonResponse.getSprites().getOther().getOfficialArtwork().getFrontDefault())
                    .placeholder(createLottieDrawable("loading-dots-in-yellow.json"))
                    .error(createLottieDrawable("error.json"))
                    .into(activityDescriptionPokemonBinding.pokemonImg);
            progressDialog.dismiss();
        });
        viewModelDescriptionActivity.getErrorRequest().observe(this,error-> {
            Toast.makeText(getBaseContext(),error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
            progressDialog.dismiss();
        });
    }

    private void initItemView(){
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getBaseContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        activityDescriptionPokemonBinding.rvTypes.setLayoutManager(linearLayoutManager);
        activityDescriptionPokemonBinding.rvTypes.setAdapter(listTypePokemon);
    }

    private LottieDrawable createLottieDrawable(String filename) {
        final LottieDrawable lottieDrawable = new LottieDrawable();
        LottieCompositionFactory.fromAsset(getBaseContext(),filename).addListener(lis->{
            lottieDrawable.setComposition(lis);
            lottieDrawable.playAnimation();
        });
        return lottieDrawable;
    }

    @Override
    public int getColorType(String type) {
        return viewModelDescriptionActivity.getColorType(type);
    }

    @Override
    public int getSrcType(String type) {
        return viewModelDescriptionActivity.getSrcType(type);
    }

    @Override
    public void eventClick(TypesItem typesItem) {
        Intent intencao  = new Intent(this,TypeInfoActivity.class);
        intencao.putExtra("type",typesItem);
        startActivity(intencao);
    }
}