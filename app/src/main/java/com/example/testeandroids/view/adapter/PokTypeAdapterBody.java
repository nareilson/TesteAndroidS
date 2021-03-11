package com.example.testeandroids.view.adapter;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroids.R;
import com.example.testeandroids.data.implementacao.ITypeResourceBussines;
import com.example.testeandroids.data.pokemondata.Type;
import com.example.testeandroids.databinding.ItemTypeAdapterBodyBinding;
import com.example.testeandroids.databinding.ItemTypePokemonBinding;

public class PokTypeAdapterBody extends ListAdapter<Type, PokTypeAdapterBody.TyperAdapterViewHolder> {
    ITypeResourceBussines resourceBussines;
    public PokTypeAdapterBody(@NonNull DiffUtil.ItemCallback<Type> diffCallback, ITypeResourceBussines resourceBussines) {
        super(diffCallback);
        this.resourceBussines = resourceBussines;
    }

    @NonNull
    @Override
    public TyperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemTypeAdapterBodyBinding itemTypePokemonBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_type_adapter_body,parent,false);
        return new TyperAdapterViewHolder(itemTypePokemonBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TyperAdapterViewHolder holder, int position) {
        holder.bindingItemView(getItem(position),resourceBussines);
    }

    static class TyperAdapterViewHolder extends RecyclerView.ViewHolder{
        private final ItemTypeAdapterBodyBinding itemTypePokemonBinding;
        public TyperAdapterViewHolder(@NonNull ItemTypeAdapterBodyBinding itemTypePokemonBinding) {
            super(itemTypePokemonBinding.getRoot());
            this.itemTypePokemonBinding = itemTypePokemonBinding;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        void bindingItemView(Type item, ITypeResourceBussines resourceBussines){
            itemTypePokemonBinding.typeLogo.setImageDrawable(itemTypePokemonBinding.typeLogo.getContext().getResources().getDrawable(resourceBussines.getSrcType(item.getName())));
            itemTypePokemonBinding.cardViewImg.setCardBackgroundColor(itemTypePokemonBinding.cardViewImg.getContext().getResources().getColor(resourceBussines.getColorType(item.getName())));
            itemTypePokemonBinding.typeNome.setText(item.getName());
        }
    }

   public static class typeDiffUltil extends DiffUtil.ItemCallback<Type> {

        @Override
        public boolean areItemsTheSame(@NonNull Type oldItem, @NonNull Type newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull Type oldItem, @NonNull Type newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
