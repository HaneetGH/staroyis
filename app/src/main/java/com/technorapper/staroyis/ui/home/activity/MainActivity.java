package com.technorapper.staroyis.ui.home.activity;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.technorapper.staroyis.R;
import com.technorapper.staroyis.apater.ProductListAdapter;
import com.technorapper.staroyis.databinding.ActivityMainBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.interfaces.RecyclerViewClickListener;
import com.technorapper.staroyis.ui.detail.activity.ProductDetailActivity;
import com.technorapper.staroyis.ui.home.model.AllProductModel;
import com.technorapper.staroyis.ui.home.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity implements RecyclerViewClickListener {
    ActivityMainBinding binding;
    MainViewModel viewModel;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    }

    @Override
    public void onAttachViewModel() {
        viewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        viewModel.data.observe(MainActivity.this, new Observer<JsonObject>() {
            @Override
            public void onChanged(@Nullable JsonObject jsonObject) {
                Gson gson = new
                        Gson();
                if (jsonObject != null && jsonObject.toString() != null) {
                     allProductModel = gson.fromJson(jsonObject.toString(), AllProductModel.class);

                    ProductListAdapter adapter = new ProductListAdapter(allProductModel.getData().getProducts(), MainActivity.this);
                    binding.setAdapter(adapter);
                } else {
                    snackbar = Snackbar
                            .make(binding.getRoot(), "Check Internet Connection", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });
        viewModel.fetchProduct(MainActivity.this);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view, int position) {

        Intent intent = new Intent(this, ProductDetailActivity.class);
        intent.putExtra("position", position);
        startActivity(intent);

    }
}
