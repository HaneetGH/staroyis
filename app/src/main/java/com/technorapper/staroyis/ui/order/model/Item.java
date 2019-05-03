
package com.technorapper.staroyis.ui.order.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Item {//product_name

    @SerializedName("product_id")
    @Expose
    private Integer productId;

    public Integer getProduct_name() {
        return product_name;
    }

    public void setProduct_name(Integer product_name) {
        this.product_name = product_name;
    }

    @SerializedName("product_name")
    @Expose
    private Integer product_name;
    @SerializedName("quantity")
    @Expose
    private Integer quantity;
    @SerializedName("price")
    @Expose
    private Integer price;

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

}
