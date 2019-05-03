package com.technorapper.staroyis.ui.account.login.activity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.technorapper.staroyis.R;
import com.technorapper.staroyis.apater.ProductListAdapter;
import com.technorapper.staroyis.databinding.LoginActivityBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.ui.account.login.model.LoginModel;
import com.technorapper.staroyis.ui.account.login.viewmodel.LoginViewModel;
import com.technorapper.staroyis.ui.account.register.activity.RegisterActivity;
import com.technorapper.staroyis.ui.home.activity.MainActivity;
import com.technorapper.staroyis.ui.home.model.AllProductModel;
import com.technorapper.staroyis.ui.home.viewmodel.MainViewModel;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class LoginActivity extends BaseActivity {
    Snackbar snackbar;
    LoginActivityBinding binding;
    LoginViewModel viewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.login_activity);
        binding.setHandler(new ClickHandler());
    }

    @Override
    public void onAttachViewModel() {
        viewModel = ViewModelProviders.of(this).get(LoginViewModel.class);

        viewModel.data.observe(LoginActivity.this, new Observer<JsonObject>() {
            @Override
            public void onChanged(@Nullable JsonObject jsonObject) {
                Gson gson = new
                        Gson();
                if (jsonObject != null && jsonObject.toString() != null) {
                    LoginModel loginModel = gson.fromJson(jsonObject.toString(), LoginModel.class);
                    if (loginModel.getMessage().equalsIgnoreCase("Sucessfully login")) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    } else {
                        snackbar = Snackbar
                                .make(binding.getRoot(), "Fail try Again", Snackbar.LENGTH_LONG);
                        snackbar.show();
                    }

                } else {
                    snackbar = Snackbar
                            .make(binding.getRoot(), "Fail try Again", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    public class ClickHandler {

        public void login(String phone, String pass) {
            if (phone.isEmpty() || pass.isEmpty()){
                snackbar = Snackbar
                        .make(binding.getRoot(), "Credential Missing", Snackbar.LENGTH_LONG);
                snackbar.show();
                return;}
            viewModel.login(phone, pass);
        }

        public void register() {
            Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
            startActivity(intent);
        }

    }
}
