package com.example.testeandroids.view.adapter;

import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroids.data.pokemondata.Type;

public class PokTypeAdapterHeader extends ListAdapter<Type, PokTypeAdapterHeader.TyperAdapterViewHolder> {

    protected PokTypeAdapterHeader(@NonNull DiffUtil.ItemCallback<Type> diffCallback) {
        super(diffCallback);
    }

    @NonNull
    @Override
    public TyperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull TyperAdapterViewHolder holder, int position) {

    }

    static class TyperAdapterViewHolder extends RecyclerView.ViewHolder{

        public TyperAdapterViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    static class typeDiffUltil extends DiffUtil.ItemCallback<Type> {

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
