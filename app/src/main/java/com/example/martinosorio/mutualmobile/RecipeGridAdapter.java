package com.example.martinosorio.mutualmobile;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.martinosorio.mutualmobile.databinding.RecipeViewHolderLayoutBinding;

/**
 * Created by Martin on 3/22/2018.
 */

public class RecipeGridAdapter extends RecyclerView.Adapter {
    private LayoutInflater layoutInflater;
    private int nextID = 0;

    public RecipeGridAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecipeViewHolderLayoutBinding binding = DataBindingUtil.inflate(layoutInflater, R.layout.recipe_view_holder_layout, parent, false);
        return new RecipeViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        RecipeViewModel viewModel = new RecipeViewModel();
        ((RecipeViewHolder) holder).bind(viewModel);
    }

    @Override
    public int getItemCount() {
        //return films.getFilms().size();
        return 0;
    }
}