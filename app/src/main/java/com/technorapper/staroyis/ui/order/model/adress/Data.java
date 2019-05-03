
package com.technorapper.staroyis.ui.order.model.adress;

import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Data {

    @SerializedName("address_details")
    @Expose
    private List<AddressDetail> addressDetails = null;

    public List<AddressDetail> getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(List<AddressDetail> addressDetails) {
        this.addressDetails = addressDetails;
    }

}
