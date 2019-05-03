
package com.technorapper.staroyis.ui.order.model;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItemModel {

    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("address_id")
    @Expose
    private String addressId;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getAddressId() {
        return addressId;
    }

    public void setAddressId(String addressId) {
        this.addressId = addressId;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
