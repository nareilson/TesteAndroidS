package com.example.testeandroids.view.adapter;

import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

public abstract class ViewHolderBase extends RecyclerView.ViewHolder{
    public ViewHolderBase(@NonNull @NotNull View itemView) {
        super(itemView);
    }

    abstract void onViewAttachedToWindow();

    abstract void onViewDetachedFromWindow();

    abstract void onViewRecycled();
}
