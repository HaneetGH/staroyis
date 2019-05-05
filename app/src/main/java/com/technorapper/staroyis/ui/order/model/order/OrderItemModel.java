
package com.technorapper.staroyis.ui.order.model.order;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderItemModel {

    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("user_id")
    @Expose
    private Integer userId;
    @SerializedName("address_id")
    @Expose
    private String addressId;
    @SerializedName("subtotal")
    @Expose
    private Integer subtotal;
    @SerializedName("tax")
    @Expose
    private Integer tax;
    @SerializedName("total")
    @Expose
    private Integer total;
    @SerializedName("items")
    @Expose
    private List<Item> items = null;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

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

    public Integer getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Integer subtotal) {
        this.subtotal = subtotal;
    }

    public Integer getTax() {
        return tax;
    }

    public void setTax(Integer tax) {
        this.tax = tax;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<Item> getItems() {
        return items;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

}
