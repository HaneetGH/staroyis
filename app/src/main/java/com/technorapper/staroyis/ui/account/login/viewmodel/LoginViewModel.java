package com.technorapper.staroyis.ui.account.login.viewmodel;

import android.app.Activity;
import android.app.Application;
import android.content.Context;

import com.google.gson.JsonObject;
import com.technorapper.staroyis.networking.Repository.Api;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

public class LoginViewModel extends AndroidViewModel {
    public MutableLiveData<JsonObject> data = new MutableLiveData<>();
    public MutableLiveData<JsonObject> dataSave = new MutableLiveData<>();
    Context context;

    public LoginViewModel(@NonNull Application application) {
        super(application);
        context = application;
    }

    public void login(String id, String pass) {
        Api.login( id, pass, data);
    }



}

