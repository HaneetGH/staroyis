package com.technorapper.staroyis.ui.account.register.activity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.technorapper.staroyis.R;
import com.technorapper.staroyis.apater.ProductListAdapter;
import com.technorapper.staroyis.databinding.RegisterActivityBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.ui.account.login.activity.LoginActivity;
import com.technorapper.staroyis.ui.account.register.model.OtpModel;
import com.technorapper.staroyis.ui.account.register.viewmodel.RegisterViewModel;
import com.technorapper.staroyis.ui.home.activity.MainActivity;
import com.technorapper.staroyis.ui.home.model.AllProductModel;
import com.technorapper.staroyis.ui.home.viewmodel.MainViewModel;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class RegisterActivity extends BaseActivity {
    RegisterActivityBinding binding;
    RegisterViewModel viewModel;
    Snackbar snackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.register_activity);
        binding.setHandler(new ClickHandler());
    }

    @Override
    public void onAttachViewModel() {
        viewModel = ViewModelProviders.of(this).get(RegisterViewModel.class);
        viewModel.dataSave.observe(this, new Observer<JsonObject>() {
            @Override
            public void onChanged(JsonObject jsonObject) {
                Log.d("TAF",jsonObject.toString());
            }
        });
        viewModel.data.observe(this, new Observer<JsonObject>() {
            @Override
            public void onChanged(@Nullable JsonObject jsonObject) {
                Gson gson = new
                        Gson();
                if (jsonObject != null && jsonObject.toString() != null) {
                    OtpModel otpModel = gson.fromJson(jsonObject.toString(), OtpModel.class);
                    if (otpModel.getMessage().equalsIgnoreCase("Otp Genrated Successfully")) {
                        snackbar = Snackbar
                                .make(binding.getRoot(), "OTP Send", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    } else {
                        snackbar = Snackbar
                                .make(binding.getRoot(), "Fail", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }

                } else {
                    snackbar = Snackbar
                            .make(binding.getRoot(), "Fail", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

    }

    public class ClickHandler {

        public void register(String phone, String name, String otp, String pass) {
            if (phone.isEmpty() || name.isEmpty() || otp.isEmpty() || pass.isEmpty()){
                snackbar = Snackbar
                        .make(binding.getRoot(), "Data Missing", Snackbar.LENGTH_LONG);
                snackbar.show();
                return;}
            viewModel.register(phone, name, otp, pass);
        }

        public void otp(String phone) {

            if (phone.isEmpty()){
                snackbar = Snackbar
                        .make(binding.getRoot(), "Phone Number is Missing", Snackbar.LENGTH_LONG);
                snackbar.show();
                return;}
            viewModel.otp(phone);
        }

    }
}
