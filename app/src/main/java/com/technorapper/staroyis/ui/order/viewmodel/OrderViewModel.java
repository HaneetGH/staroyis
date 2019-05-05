package com.technorapper.staroyis.ui.order.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.technorapper.staroyis.networking.Repository.Api;
import com.technorapper.staroyis.ui.order.model.Item;

import java.util.List;

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

    public void fetchAddress(Activity mContext, int idn) {

        Api.getAdddressList("1829CTF2CC6DD", idn, data);


    }

    public void SaveAddress(Activity mContext, int idn, String add1, String add2, String city, String state, String pincode, String contactp, String contactPN) {
        Api.saveAdddress("1829CTF2CC6DD", idn, add1, add2, city, state, pincode, contactp, contactPN, dataSave);
    }

    public void SaveOrder(Activity mContext, JsonObject jsonElements) {
        Api.sendOrder(jsonElements, dataSave);
    }


}

