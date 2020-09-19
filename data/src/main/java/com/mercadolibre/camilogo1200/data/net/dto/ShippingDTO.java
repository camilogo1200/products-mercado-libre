
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ShippingDTO implements Serializable {

    @SerializedName("free_shipping")
    @Expose
    private Boolean freeShipping;
    @SerializedName("mode")
    @Expose
    private String mode;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<>();
    @SerializedName("logistic_type")
    @Expose
    private String logisticType;
    @SerializedName("store_pick_up")
    @Expose
    private Boolean storePickUp;
    private static final long serialVersionUID = -1943270938099130107L;

    /**
     * No args constructor for use in serialization
     */
    public ShippingDTO() {
    }

    /**
     * @param mode
     * @param logisticType
     * @param freeShipping
     * @param storePickUp
     * @param tags
     */
    public ShippingDTO(Boolean freeShipping, String mode, List<String> tags, String logisticType, Boolean storePickUp) {
        super();
        this.freeShipping = freeShipping;
        this.mode = mode;
        this.tags = tags;
        this.logisticType = logisticType;
        this.storePickUp = storePickUp;
    }

    public Boolean getFreeShipping() {
        return freeShipping;
    }

    public void setFreeShipping(Boolean freeShipping) {
        this.freeShipping = freeShipping;
    }

    public String getMode() {
        return mode;
    }

    public void setMode(String mode) {
        this.mode = mode;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getLogisticType() {
        return logisticType;
    }

    public void setLogisticType(String logisticType) {
        this.logisticType = logisticType;
    }

    public Boolean getStorePickUp() {
        return storePickUp;
    }

    public void setStorePickUp(Boolean storePickUp) {
        this.storePickUp = storePickUp;
    }

    @NonNull
    @Override
    public String toString() {
        return "ShippingDTO{" +
                "freeShipping=" + freeShipping +
                ", mode='" + mode + '\'' +
                ", tags=" + tags +
                ", logisticType='" + logisticType + '\'' +
                ", storePickUp=" + storePickUp +
                '}';
    }
}
