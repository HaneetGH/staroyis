package com.technorapper.staroyis.ui.order.activity;

import android.app.Dialog;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.material.snackbar.Snackbar;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.technorapper.staroyis.R;
import com.technorapper.staroyis.apater.AddressListAdapter;
import com.technorapper.staroyis.apater.CartProductListAdapter;
import com.technorapper.staroyis.apater.ProductListAdapter;
import com.technorapper.staroyis.databinding.ActivityOrderBinding;
import com.technorapper.staroyis.databinding.DialogSaveAddressBinding;
import com.technorapper.staroyis.global.BaseActivity;
import com.technorapper.staroyis.interfaces.RecyclerViewClickListener;
import com.technorapper.staroyis.ui.detail.activity.ProductDetailActivity;
import com.technorapper.staroyis.ui.home.activity.MainActivity;
import com.technorapper.staroyis.ui.home.model.AllProductModel;
import com.technorapper.staroyis.ui.home.viewmodel.MainViewModel;
import com.technorapper.staroyis.ui.order.model.adress.AddressModel;
import com.technorapper.staroyis.ui.order.model.order.Item;
import com.technorapper.staroyis.ui.order.model.order.OrderItemModel;
import com.technorapper.staroyis.ui.order.viewmodel.OrderViewModel;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.Nullable;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

public class OrderNowActivity extends BaseActivity implements RecyclerViewClickListener {

    ActivityOrderBinding binding;
    OrderViewModel viewModel;

    @Override
    public void onBinding() {
        binding = DataBindingUtil.setContentView(this, R.layout.activity_order);
        CartProductListAdapter adapter = new CartProductListAdapter(orderItemModel.getItems(), OrderNowActivity.this);
        binding.setAdapter(adapter);
        binding.setHandler(new ClickHandler());
    }

    @Override
    public void onAttachViewModel() {
        viewModel = ViewModelProviders.of(this).get(OrderViewModel.class);
        viewModel.dataSave.observe(this, new Observer<JsonObject>() {
            @Override
            public void onChanged(JsonObject jsonObject) {
                if (jsonObject != null) {
                    Snackbar snackbar = Snackbar
                            .make(binding.getRoot(), jsonObject.get("message").getAsString(), Snackbar.LENGTH_LONG);
                    snackbar.show();
                    Intent intent = new Intent(OrderNowActivity.this,MainActivity.class);
                    startActivity(intent);
                }
            }
        });
        viewModel.data.observe(OrderNowActivity.this, new Observer<JsonObject>() {
            @Override
            public void onChanged(@Nullable JsonObject jsonObject) {
                Gson gson = new
                        Gson();
                if (jsonObject != null && jsonObject.toString() != null) {
                    AddressModel addressModel = gson.fromJson(jsonObject.toString(), AddressModel.class);

                    AddressListAdapter adapter = new AddressListAdapter(addressModel.getData().getAddressDetails(), OrderNowActivity.this);
                    binding.setAdapterAdd(adapter);
                } else {
                    Snackbar snackbar = Snackbar
                            .make(binding.getRoot(), "Check Internet Connection", Snackbar.LENGTH_LONG);
                    snackbar.show();
                }
            }
        });

        viewModel.fetchAddress(OrderNowActivity.this, 10);
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }

    @Override
    public void onClick(View view, int position) {

    }

    public class ClickHandler {

        public void saveAdd(String add1, String add2, String city, String state, String pincode, String contactp, String contactPN) {


            viewModel.SaveAddress(OrderNowActivity.this, 10, add1, add2, city, state, pincode, contactp, contactPN);
        }

        public void addSaveDialog() {
            openDialog();
        }

        JSONObject request;

        public void save() {


            int Total = 0;
            for (int i = 0; i < orderItemModel.getItems().size(); i++) {
                Total += orderItemModel.getItems().get(i).getPrice();
            }
            orderItemModel.setAddressId("1");
            orderItemModel.setSubtotal(1);

            orderItemModel.setToken("1829CTF2CC6DD");
            orderItemModel.setUserId(10);
            orderItemModel.setTotal(Total);

            JsonParser parser = new JsonParser();
            JsonObject o = parser.parse(new Gson().toJson(orderItemModel)).getAsJsonObject();

            viewModel.SaveOrder(OrderNowActivity.this, o);//orderItemModelNow.getItems()
        }


    }

    private void openDialog() {


        DialogSaveAddressBinding binding = DataBindingUtil
                .inflate(LayoutInflater.from(OrderNowActivity.this), R.layout.dialog_save_address, null, false);
        binding.setHandler(new ClickHandler());
        Dialog dialog = new Dialog(OrderNowActivity.this);
        dialog.setContentView(binding.getRoot());
        dialog.show();
        ;

    }

}
