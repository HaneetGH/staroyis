package com.technorapper.staroyis.ui.detail.activity;

import android.content.Intent;
import android.os.Bundle;

import com.technorapper.staroyis.R;
import com.technorapper.staroyis.databinding.ActivityDetailProductBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.ui.order.activity.OrderNowActivity;
import com.technorapper.staroyis.ui.order.model.Item;
import com.technorapper.staroyis.ui.order.model.OrderItemModel;

import java.util.ArrayList;
import java.util.List;

import androidx.databinding.DataBindingUtil;

public class ProductDetailActivity extends BaseActivity {
    ActivityDetailProductBinding binding;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public void onBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_detail_product);
        binding.setHandler(new ClickHandler());

    }

    @Override
    public void onAttachViewModel() {

        binding.setModel(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)));

    }

    public class ClickHandler {

        public void addToCard(String price, String quanitity) {
            Item item = new Item();
            item.setPrice(price);
            item.setQuantity(quanitity);
            item.setProductId(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getId());
            item.setProduct_name(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getProductName());
            List<Item> itemList = new ArrayList<>();
            itemList.add(item);
            orderItemModel.setItems(itemList);
        }

        public void ordernow(String price, String quanitity) {

            Item item = new Item();
            item.setPrice(price);
            item.setQuantity(quanitity);
            item.setProductId(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getId());
            item.setProduct_name(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getProductName());
            List<Item> itemList = new ArrayList<>();
            itemList.add(item);

            orderItemModelNow = new OrderItemModel();
            orderItemModelNow.setItems(itemList);
            Intent intent = new Intent(ProductDetailActivity.this, OrderNowActivity.class);
            startActivity(intent);
        }

    }

}
