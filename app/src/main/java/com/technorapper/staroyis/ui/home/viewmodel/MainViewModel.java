package com.technorapper.staroyis.ui.home.viewmodel;

import android.app.Activity;
import android.app.Application;

import android.content.Context;

import com.google.gson.JsonObject;
import com.technorapper.staroyis.networking.Repository.Api;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class MainViewModel extends AndroidViewModel {
    public MutableLiveData<JsonObject> data = new MutableLiveData<>();
    public MutableLiveData<JsonObject> dataSave = new MutableLiveData<>();
    Context context;

    public MainViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void fetchProduct(Activity mContext) {
        Api.getProductList("1829CTF2CC6DD",data);
    }



}

