package com.technorapper.staroyis.ui.detail.activity;

import android.content.Intent;
import android.os.Bundle;

import com.technorapper.staroyis.R;
import com.technorapper.staroyis.databinding.ActivityDetailProductBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.ui.order.activity.OrderNowActivity;

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


        public void ordernow() {

            Intent intent = new Intent(ProductDetailActivity.this, OrderNowActivity.class);
            startActivity(intent);
        }

    }

}
