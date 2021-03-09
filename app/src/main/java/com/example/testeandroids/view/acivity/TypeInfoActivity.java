package com.example.testeandroids.view.acivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ConcatAdapter;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.Toast;

import com.example.testeandroids.R;
import com.example.testeandroids.data.pokemondata.TypesItem;
import com.example.testeandroids.databinding.ActivityTypeInfoBinding;
import com.example.testeandroids.view.viewmodel.TypeInfoActivityViewModel;

public class TypeInfoActivity extends AppCompatActivity {

    ActivityTypeInfoBinding activityTypeInfoBinding;
    TypeInfoActivityViewModel viewModelTypeActivity;
    ProgressDialog progressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityTypeInfoBinding = DataBindingUtil.setContentView(this,R.layout.activity_type_info);
        viewModelTypeActivity = new ViewModelProvider(this).get(TypeInfoActivityViewModel.class);
        progressDialog = new ProgressDialog(this);
        progressDialog.setTitle(R.string.txt_carregando);
        progressDialog.show();
        TypesItem typesItem = (TypesItem) getIntent().getSerializableExtra("type");
        viewModelTypeActivity.getTypePokemon(typesItem.getType().getName());
        observable();
    }

    private void observable(){
        viewModelTypeActivity.getResponseTypePokemon().observe(this,result->{

            progressDialog.dismiss();
        });
        viewModelTypeActivity.getRequestError().observe(this,error->{
            progressDialog.dismiss();
            Toast.makeText(getBaseContext(),"Error: "+error.getLocalizedMessage(),Toast.LENGTH_LONG).show();
        });
    }
}