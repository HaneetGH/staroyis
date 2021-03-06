package com.technorapper.staroyis.networking.Repository;

import android.app.Activity;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.technorapper.staroyis.networking.ApiUtils;
import com.technorapper.staroyis.networking.StaroyisApi;
import com.technorapper.staroyis.ui.order.model.Item;

import java.util.List;

import androidx.lifecycle.MutableLiveData;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.http.Query;

public class Api {
    private static StaroyisApi staroyisApi = ApiUtils.getBaseUrl();

    public static void getProductList(String id, final MutableLiveData<JsonObject> data) {
        staroyisApi.GetAllProduct(id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                data.setValue(null);
            }
        });


    }


    public static void sendOrder(JsonObject jsonElements, final MutableLiveData<JsonObject> data) {
        staroyisApi.Order(jsonElements).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                data.setValue(null);
            }
        });


    }

    public static void getAdddressList(String token, int id, final MutableLiveData<JsonObject> data) {
        staroyisApi.GetAllAddresst(token, id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {

                data.setValue(response.body());

            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {

                data.setValue(null);

            }
        });


    }

    public static void saveAdddress(String token, int idn, String add1, String add2, String city, String state, String pincode, String contactp, String contactPN, final MutableLiveData<JsonObject> data) {
        staroyisApi.AddAddress(token, idn, add1, add2, city, state, pincode, contactp, contactPN).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                data.setValue(null);
            }
        });


    }

    public static void login(String id, String pass, final MutableLiveData<JsonObject> data) {
        staroyisApi.login("1829CTF2CC6DD", id, pass).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                data.setValue(null);
            }
        });


    }

    public static void otp(String id, final MutableLiveData<JsonObject> data) {
        staroyisApi.otp("1829CTF2CC6DD", id).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {
                data.setValue(null);
            }
        });


    }

    public static void register(String id, String name, String otp, String pass, final MutableLiveData<JsonObject> data) {
        staroyisApi.register("1829CTF2CC6DD", id, name, otp, pass).enqueue(new Callback<JsonObject>() {
            @Override
            public void onResponse(Call<JsonObject> call, Response<JsonObject> response) {
                data.setValue(response.body());
            }

            @Override
            public void onFailure(Call<JsonObject> call, Throwable t) {


                data.setValue(null);
            }
        });


    }
}
