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
import com.example.testeandroids.databinding.ItemPoktypeAdapterHeaderBinding;

public class PokTypeAdapterHeader extends ListAdapter<Type, PokTypeAdapterHeader.TyperAdapterViewHolder> {
    ITypeResourceBussines resourceBussines;
    public PokTypeAdapterHeader(@NonNull DiffUtil.ItemCallback<Type> diffCallback, ITypeResourceBussines resourceBussines) {
        super(diffCallback);
        this.resourceBussines = resourceBussines;
    }

    @NonNull
    @Override
    public TyperAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPoktypeAdapterHeaderBinding itemPoktypeAdapterHeaderBinding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_poktype_adapter_header,parent,false);
        return new TyperAdapterViewHolder(itemPoktypeAdapterHeaderBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull TyperAdapterViewHolder holder, int position) {
        holder.bindingView(getItem(position),resourceBussines);
    }

    static class TyperAdapterViewHolder extends RecyclerView.ViewHolder{
        private final ItemPoktypeAdapterHeaderBinding itemPoktypeAdapterHeaderBinding;
        public TyperAdapterViewHolder(@NonNull ItemPoktypeAdapterHeaderBinding itemPoktypeAdapterHeaderBinding) {
            super(itemPoktypeAdapterHeaderBinding.getRoot());
            this.itemPoktypeAdapterHeaderBinding = itemPoktypeAdapterHeaderBinding;
        }

        @SuppressLint("UseCompatLoadingForDrawables")
        public void bindingView(Type item, ITypeResourceBussines resourceBussines){
            itemPoktypeAdapterHeaderBinding.cardView.setCardBackgroundColor(itemPoktypeAdapterHeaderBinding.cardView.getContext().getResources().getColor(resourceBussines.getColorType(item.getName())));
            itemPoktypeAdapterHeaderBinding.imgLogo.setImageDrawable(itemPoktypeAdapterHeaderBinding.imgLogo.getContext().getResources().getDrawable(resourceBussines.getSrcType(item.getName())));
            itemPoktypeAdapterHeaderBinding.typeNome.setText(item.getName());
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

    public static class DiffUtilsHeader extends DiffUtil.ItemCallback<Type>{

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
