package com.example.testeandroids.view.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroids.R;
import com.example.testeandroids.data.pokemondata.TypesItem;
import com.example.testeandroids.databinding.ItemTypePokemonBinding;

public class ListTypePokemon extends ListAdapter<TypesItem, ListTypePokemon.TypePokemonViewHolder> {

    public ListTypePokemon(@NonNull DiffUtil.ItemCallback<TypesItem> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TypePokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTypePokemonBinding itemTypePokemonBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_type_pokemon,parent,false);
        return new TypePokemonViewHolder(itemTypePokemonBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TypePokemonViewHolder holder, int position) {
        holder.bindingItens(getItem(position));
    }

    static class TypePokemonViewHolder extends RecyclerView.ViewHolder{
        private ItemTypePokemonBinding bindingView;
        public TypePokemonViewHolder(@NonNull ItemTypePokemonBinding bindingView) {
            super(bindingView.getRoot());
            this.bindingView = bindingView;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        public void bindingItens(TypesItem item){
            bindingView.typeNome.setText(item.getType().getName());
            bindingView.typeLogo.setImageDrawable(bindingView.typeLogo.getContext().getResources().getDrawable(getSrcType(item.getType().getName())));
            bindingView.cardView.setCardBackgroundColor(bindingView.cardView.getContext().getResources().getColor(getColorType(item.getType().getName())));
        }
        private int getSrcType(String type){
            switch (type){
                case "bug":
                    return R.drawable.ic_bug;
                case "ground":
                    return  R.drawable.ic_ground;
                case "dark":
                    return R.drawable.ic_dark;
                case "dragon":
                    return R.drawable.ic_dragon;
                case "electric":
                    return R.drawable.ic_electric;
                case "fairy":
                    return R.drawable.ic_fairy;
                case "fighting":
                    return R.drawable.ic_fighting;
                case "ghost":
                    return R.drawable.ic_ghost;
                case "grass":
                    return R.drawable.ic_grass;
                case "ice":
                    return R.drawable.ic_ice;
                case "poison":
                    return R.drawable.ic_poison;
                case "psychic":
                    return R.drawable.ic_psychic;
                case "rock":
                    return R.drawable.ic_rock;
                case "steel":
                    return R.drawable.ic_steel;
                case "water":
                    return R.drawable.ic_water;
                default:
                    return R.drawable.ic_normal;
            }
        }
        private int getColorType(String type){
            switch (type){
                case "bug":
                    return R.color.bug;
                case "ground":
                    return  R.color.ground;
                case "dark":
                    return R.color.cinza;
                case "dragon":
                    return R.color.azul_escuro;
                case "electric":
                    return R.color.electric;
                case "fairy":
                    return R.color.fairy;
                case "fighting":
                    return R.color.fighting;
                case "ghost":
                    return R.color.purple_700;
                case "grass":
                    return R.color.grass;
                case "ice":
                    return R.color.ice;
                case "poison":
                    return R.color.purple_200;
                case "psychic":
                    return R.color.laranja;
                case "rock":
                    return R.color.marrom_claro;
                case "steel":
                    return R.color.teal_700;
                case "water":
                    return R.color.azul;
                default:
                    return R.color.black;
            }
        }
    }

    public static class DiffUtilsTypePokemo extends DiffUtil.ItemCallback<TypesItem>{

        @Override
        public boolean areItemsTheSame(@NonNull TypesItem oldItem, @NonNull TypesItem newItem) {
            return oldItem.equals(newItem);
        }

        @SuppressLint("DiffUtilEquals")
        @Override
        public boolean areContentsTheSame(@NonNull TypesItem oldItem, @NonNull TypesItem newItem) {
            return oldItem.getType() == newItem.getType();
        }
    }

}
