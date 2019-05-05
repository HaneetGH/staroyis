package com.technorapper.staroyis.global;

import android.os.Bundle;

import com.technorapper.staroyis.ui.home.model.AllProductModel;
import com.technorapper.staroyis.ui.order.model.order.Item;
import com.technorapper.staroyis.ui.order.model.order.OrderItemModel;

import java.util.ArrayList;
import java.util.List;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LifecycleOwner;

public abstract class BaseActivity extends AppCompatActivity {
    public static AllProductModel allProductModel=new AllProductModel();
    public static com.technorapper.staroyis.ui.order.model.order.OrderItemModel orderItemModel = new OrderItemModel();
    public static List<Item> itemList = new ArrayList<>();
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onBinding();
        onAttachViewModel();
    }

    public abstract void onBinding();

    public abstract void onAttachViewModel();
}
