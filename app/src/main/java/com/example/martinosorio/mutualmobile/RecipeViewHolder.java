package com.example.martinosorio.mutualmobile;

import android.support.v7.widget.RecyclerView;

import com.example.martinosorio.mutualmobile.databinding.RecipeViewHolderLayoutBinding;

/**
 * Created by Martin on 3/22/2018.
 */

public class RecipeViewHolder extends RecyclerView.ViewHolder {
    private RecipeViewHolderLayoutBinding binding;

    public RecipeViewHolder(RecipeViewHolderLayoutBinding binding) {
        super(binding.getRoot());
        this.binding = binding;
    }

    public void bind(RecipeViewModel viewModel) {
        binding.setViewModel(viewModel);
        binding.executePendingBindings();
    }
}
