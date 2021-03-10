package com.example.testeandroids.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroids.R;
import com.example.testeandroids.data.pokemondata.Type;
import com.example.testeandroids.databinding.AdapterTitleBinding;

public class PokTypeAdapterTitle extends ListAdapter<Type, PokTypeAdapterTitle.TyperAdapterViewHolder> {

    public PokTypeAdapterTitle(@NonNull DiffUtil.ItemCallback<Type> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TyperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        AdapterTitleBinding adapterTitleBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),R.layout.adapter_title,parent,false);
        return new TyperAdapterViewHolder(adapterTitleBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TyperAdapterViewHolder holder, int position) {
        holder.bindingItemView(getItem(position).getName());
    }

    static class TyperAdapterViewHolder extends RecyclerView.ViewHolder{
        private final AdapterTitleBinding adapterTitleBinding;
        public TyperAdapterViewHolder(@NonNull AdapterTitleBinding adapterTitleBinding) {
            super(adapterTitleBinding.getRoot());
            this.adapterTitleBinding = adapterTitleBinding;
        }
        public void bindingItemView(String title){
            adapterTitleBinding.title.setText(title);
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
