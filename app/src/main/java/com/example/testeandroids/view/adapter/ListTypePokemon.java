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
import com.example.testeandroids.data.implementacao.ITypeResourceBussines;
import com.example.testeandroids.data.implementacao.ITypeResourceEventClick;
import com.example.testeandroids.data.pokemondata.TypesItem;
import com.example.testeandroids.databinding.ItemTypePokemonBinding;

public class ListTypePokemon extends ListAdapter<TypesItem, ListTypePokemon.TypePokemonViewHolder> {
    private final ITypeResourceBussines iTypeResourceBussines;
    private final ITypeResourceEventClick eventClick;
    public ListTypePokemon(@NonNull DiffUtil.ItemCallback<TypesItem> diffCallback,ITypeResourceBussines iTypeResourceBussines,ITypeResourceEventClick eventClick) {
        super(diffCallback);
        this.iTypeResourceBussines = iTypeResourceBussines;
        this.eventClick = eventClick;
    }

    @NonNull
    @Override
    public TypePokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTypePokemonBinding itemTypePokemonBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.item_type_pokemon,parent,false);
        return new TypePokemonViewHolder(itemTypePokemonBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TypePokemonViewHolder holder, int position) {
        holder.bindingItens(getItem(position),iTypeResourceBussines);
        holder.itemView.setOnClickListener(v->{
            eventClick.eventClick(getItem(position));
        });
    }

    static class TypePokemonViewHolder extends RecyclerView.ViewHolder{
        private final ItemTypePokemonBinding bindingView;
        public TypePokemonViewHolder(@NonNull ItemTypePokemonBinding bindingView) {
            super(bindingView.getRoot());
            this.bindingView = bindingView;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        public void bindingItens(TypesItem item,ITypeResourceBussines iTypeResourceBussines){
            bindingView.typeNome.setText(item.getType().getName());
            bindingView.typeLogo.setImageDrawable(bindingView.typeLogo.getContext().getResources().getDrawable(iTypeResourceBussines.getSrcType(item.getType().getName())));
            bindingView.cardView.setCardBackgroundColor(bindingView.cardView.getContext().getResources().getColor(iTypeResourceBussines.getColorType(item.getType().getName())));
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
