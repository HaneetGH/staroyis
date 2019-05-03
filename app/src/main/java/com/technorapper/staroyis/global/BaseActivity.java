package com.technorapper.staroyis.global;

import android.os.Bundle;

import com.technorapper.staroyis.ui.home.model.AllProductModel;
import com.technorapper.staroyis.ui.order.model.OrderItemModel;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

public abstract class BaseActivity extends AppCompatActivity {
    public static AllProductModel allProductModel;
    public static OrderItemModel orderItemModel;
    public  static OrderItemModel orderItemModelNow;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBinding();
        onAttachViewModel();
    }

    public abstract void onBinding();

    public abstract void onAttachViewModel();
}
