package com.example.testeandroids.view.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;
import androidx.recyclerview.widget.RecyclerView;

import com.example.testeandroids.R;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.data.implementacao.ListPokemonAdapterEventClick;
import com.example.testeandroids.databinding.ItemPokemonListBinding;

public class ListPokemonAdapter extends ListAdapter<ResultsItem, ListPokemonAdapter.ListPokemonAdapterViewHolder> {
    ListPokemonAdapterEventClick eventClick;

    public ListPokemonAdapter(@NonNull DiffUtil.ItemCallback<ResultsItem> diffCallback, ListPokemonAdapterEventClick eventCLick) {
        super(diffCallback);
        this.eventClick = eventCLick;
    }

    @NonNull
    @Override
    public ListPokemonAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_pokemon_list,parent,false);
        return new ListPokemonAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPokemonAdapterViewHolder holder, int position) {
        holder.bindingItem(getItem(position));
        holder.bindingView.getRoot().setOnClickListener(v->eventClick.eventClick(getItem(position)));
    }

    static class ListPokemonAdapterViewHolder extends RecyclerView.ViewHolder {
        private final ItemPokemonListBinding bindingView;
        public ListPokemonAdapterViewHolder(@NonNull ItemPokemonListBinding itemPokemonListBinding) {
            super(itemPokemonListBinding.getRoot());
            bindingView = itemPokemonListBinding;
        }

        void bindingItem(ResultsItem item){
            bindingView.nome.setText(item.getName());
        }

    }

    public static class ListPokemonDiffUtils extends DiffUtil.ItemCallback<ResultsItem>{

        @Override
        public boolean areItemsTheSame(@NonNull ResultsItem oldItem, @NonNull ResultsItem newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull ResultsItem oldItem, @NonNull ResultsItem newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }
}
