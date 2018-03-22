package com.example.martinosorio.mutualmobile;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.martinosorio.mutualmobile.databinding.GridActivityLayoutBinding;

public class GridActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GridActivityLayoutBinding binding = DataBindingUtil.setContentView(this, R.layout.grid_activity_layout);
        GridActivityViewModel viewModel = new GridActivityViewModel();
        binding.setViewModel(viewModel);
    }
}
