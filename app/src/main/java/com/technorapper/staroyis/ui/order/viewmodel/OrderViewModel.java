package com.technorapper.staroyis.ui.order.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.JsonObject;
import com.technorapper.staroyis.networking.Repository.Api;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class OrderViewModel extends AndroidViewModel {
    public MutableLiveData<JsonObject> data = new MutableLiveData<>();
    public MutableLiveData<JsonObject> dataSave = new MutableLiveData<>();
    Context context;

    public OrderViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void fetchAddress(Activity mContext,int idn) {
        Api.getAdddressList("1829CTF2CC6DD",idn ,data);
    }


}

