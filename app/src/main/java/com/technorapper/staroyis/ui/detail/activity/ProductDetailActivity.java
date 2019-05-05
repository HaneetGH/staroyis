package com.technorapper.staroyis.ui.detail.activity;

import android.content.Intent;
import android.os.Bundle;

import com.technorapper.staroyis.R;
import com.technorapper.staroyis.databinding.ActivityDetailProductBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.ui.order.activity.OrderNowActivity;
import com.technorapper.staroyis.ui.order.model.Item;
import com.technorapper.staroyis.ui.order.model.order.OrderItemModel;

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

        orderItemModel.setTax(Integer.parseInt(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getTax()));

    }

    public class ClickHandler {

        public void addToCard(String price, String quanitity) {
            com.technorapper.staroyis.ui.order.model.order.Item item = new com.technorapper.staroyis.ui.order.model.order.Item();
            item.setPrice(Integer.parseInt(price));
            item.setQuantity((Integer.parseInt(quanitity)));
            item.setProductId((Integer.parseInt(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getId())));
            item.setProductName(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getProductName());
     ;
            itemList.add(item);
            orderItemModel.setItems(itemList);
        }

        public void ordernow(String price, String quanitity) {

            com.technorapper.staroyis.ui.order.model.order.Item item = new com.technorapper.staroyis.ui.order.model.order.Item();
            item.setPrice(Integer.parseInt(price));
            item.setQuantity((Integer.parseInt(quanitity)));
            item.setProductId((Integer.parseInt(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getId())));
            item.setProductName(allProductModel.getData().getProducts().get(getIntent().getIntExtra("position", 0)).getProductName());

            itemList.add(item);


            orderItemModel.setItems(itemList);
            Intent intent = new Intent(ProductDetailActivity.this, OrderNowActivity.class);
            startActivity(intent);
        }

    }

}
