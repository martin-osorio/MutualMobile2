package com.example.martinosorio.mutualmobile;

/**
 * Created by Martin on 3/22/2018.
 */

public class RecipeViewModel {
    private boolean progressVisible;
    private boolean imageVisible;
    private Recipe recipe;

    public RecipeViewModel() {
    }

    public RecipeViewModel(boolean progressVisible, boolean imageVisible, Recipe recipe) {
        this.progressVisible = progressVisible;
        this.imageVisible = imageVisible;
        this.recipe = recipe;
    }
}
