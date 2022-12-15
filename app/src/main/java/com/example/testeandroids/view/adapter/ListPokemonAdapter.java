package com.example.testeandroids.view.adapter;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleRegistry;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

import com.example.testeandroids.R;
import com.example.testeandroids.data.ResultsItem;
import com.example.testeandroids.data.implementacao.ListPokemonAdapterEventClick;
import com.example.testeandroids.databinding.ActivityMainBinding;
import com.example.testeandroids.databinding.ItemPokemonListBinding;
import com.example.testeandroids.view.viewmodel.MainActivityViewModel;

import org.jetbrains.annotations.NotNull;

public class ListPokemonAdapter extends ListAdapter<ResultsItem, ListPokemonAdapter.ListPokemonAdapterViewHolder> {
    ListPokemonAdapterEventClick eventClick;

    public ListPokemonAdapter(@NonNull DiffUtil.ItemCallback<ResultsItem> diffCallback, ListPokemonAdapterEventClick eventCLick) {
        super(diffCallback);
        this.eventClick = eventCLick;
    }

    @NonNull
    @Override
    public ListPokemonAdapterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ItemPokemonListBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.item_pokemon_list, parent, false);
        return new ListPokemonAdapterViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ListPokemonAdapterViewHolder holder, int position) {
        holder.bindingItem(getItem(position));
//        holder.bindingView.getRoot().setOnClickListener(v->eventClick.eventClick(getItem(position)));
    }

    static class ListPokemonAdapterViewHolder extends ViewHolderBase implements LifecycleOwner {
        private final ItemPokemonListBinding bindingView;
        private final LifecycleRegistry lifecycleRegistry = new LifecycleRegistry(this);
        MainActivityViewModel mainActivityModel;

        public ListPokemonAdapterViewHolder(@NonNull ItemPokemonListBinding itemPokemonListBinding) {
            super(itemPokemonListBinding.getRoot());
            itemPokemonListBinding.setLifecycleOwner(this);
            bindingView = itemPokemonListBinding;
            mainActivityModel = new ViewModelProvider((AppCompatActivity) itemPokemonListBinding.getRoot().getContext()).get(MainActivityViewModel.class);
        }

        void bindingItem(ResultsItem item) {
            Log.e("teste", "bindingItem: " + bindingView.nome.getText().toString());
            mainActivityModel.getCont().observe(this, v ->{
                bindingView.nome.setText(item.getName() + " -> " + v);
            });

            bindingView.getRoot().setOnClickListener(v -> {
                int cont = 1;
                if(mainActivityModel.getCont().getValue() != null){
                    cont = mainActivityModel.getCont().getValue();
                }

                int a = cont++;
                mainActivityModel.getCont().postValue(a);
            });
        }


        @NonNull
        @NotNull
        @Override
        public Lifecycle getLifecycle() {
            return lifecycleRegistry;
        }

        @Override
        void onViewAttachedToWindow() {
            Log.e("teste", "onViewAttachedToWindow: " + bindingView.nome.getText().toString());
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_START);
        }

        @Override
        void onViewDetachedFromWindow() {
            Log.e("teste", "onViewDetachedFromWindow: " + bindingView.nome.getText().toString());
            lifecycleRegistry.handleLifecycleEvent(Lifecycle.Event.ON_STOP);
        }


        @Override
        void onViewRecycled() {
            Log.e("teste", "onViewRecycled: " + bindingView.nome.getText().toString());
            Log.e("teste", "onViewRecycled: " + getLifecycle().getCurrentState());
        }
    }

    public static class ListPokemonDiffUtils extends DiffUtil.ItemCallback<ResultsItem> {

        @Override
        public boolean areItemsTheSame(@NonNull ResultsItem oldItem, @NonNull ResultsItem newItem) {
            return oldItem.equals(newItem);
        }

        @Override
        public boolean areContentsTheSame(@NonNull ResultsItem oldItem, @NonNull ResultsItem newItem) {
            return oldItem.getName().equals(newItem.getName());
        }
    }

    @Override
    public void onViewAttachedToWindow(@NonNull @NotNull ListPokemonAdapterViewHolder holder) {
        holder.onViewAttachedToWindow();
        super.onViewAttachedToWindow(holder);
    }

    @Override
    public void onViewDetachedFromWindow(@NonNull @NotNull ListPokemonAdapterViewHolder holder) {
        holder.onViewDetachedFromWindow();
        super.onViewDetachedFromWindow(holder);
    }

    @Override
    public void onViewRecycled(@NonNull @NotNull ListPokemonAdapterViewHolder holder) {
        holder.onViewRecycled();
        super.onViewRecycled(holder);
    }
}
