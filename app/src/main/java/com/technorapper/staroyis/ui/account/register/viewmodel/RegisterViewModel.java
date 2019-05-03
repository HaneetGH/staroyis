package com.technorapper.staroyis.ui.account.register.viewmodel;

import android.app.Application;
import android.content.Context;

import com.google.gson.JsonObject;
import com.technorapper.staroyis.networking.Repository.Api;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class RegisterViewModel extends AndroidViewModel {
    public MutableLiveData<JsonObject> data = new MutableLiveData<>();
    public MutableLiveData<JsonObject> dataSave = new MutableLiveData<>();
    Context context;

    public RegisterViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void register(String id, String name, String otp, String pass) {
        Api.register(id, name, otp, pass, dataSave);
    }

    public void otp(String id) {
        Api.otp(id, data);
    }


}

