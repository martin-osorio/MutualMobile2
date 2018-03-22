package com.example.martinosorio.mutualmobile;

import android.app.Activity;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Martin on 3/22/2018.
 */

public class GridActivityViewModel extends BaseObservable {
    public static final String TAG = "moltag";
    private boolean progressVisibility;
    private boolean recyclerViewVisibility;
    public ArrayList<Recipe> recipes = new ArrayList<>();

    public GridActivityViewModel() {
        final EdamamController edamamController = new EdamamController();
        edamamController.start("chicken", new Callback<EdamamReply>() {
            @Override
            public void onResponse(Call<EdamamReply> call, Response<EdamamReply> response) {
                Log.d(TAG, "onResponse: " + response);
                recipes = edamamController.processResults(response);
                Log.d(TAG, "onResponse: ");
            }

            @Override
            public void onFailure(Call<EdamamReply> call, Throwable t) {
                Log.d(TAG, "onFailure: ");
            }
        });
        
        setProgressVisibility(true);
        setRecyclerViewVisibility(false);
    }

    @Bindable
    public boolean isProgressVisibility() {
        return progressVisibility;
    }

    @Bindable
    private void setProgressVisibility(boolean progressVisibility) {
        this.progressVisibility = progressVisibility;
        //notifyPropertyChanged(BR.progressVisibility);
    }

    @Bindable
    public boolean isRecyclerViewVisibility() {
        return recyclerViewVisibility;
    }

    @Bindable
    private void setRecyclerViewVisibility(boolean recyclerViewVisibility) {
        this.recyclerViewVisibility = recyclerViewVisibility;
        //notifyPropertyChanged(BR.recyclerViewVisibility);
    }

    /*private void setupRecyclerView() {
        FilmGridRecyclerViewAdapter adapter = new FilmGridRecyclerViewAdapter(context, films);

        RecyclerView recyclerView = ((Activity) context).findViewById(R.id.recyclerView);
        recyclerView.setAdapter(adapter);

        setRecyclerViewVisibility(true);
        setProgressVisibility(false);
    }*/
}
