
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class InstallmentsDTO implements Serializable
{

    @SerializedName("quantity")
    @Expose
    private Long quantity;
    @SerializedName("amount")
    @Expose
    private Double amount;
    @SerializedName("rate")
    @Expose
    private Long rate;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    private static final long serialVersionUID = -921993116423495768L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public InstallmentsDTO() {
    }

    /**
     * 
     * @param amount
     * @param quantity
     * @param rate
     * @param currencyId
     */
    public InstallmentsDTO(Long quantity, Double amount, Long rate, String currencyId) {
        super();
        this.quantity = quantity;
        this.amount = amount;
        this.rate = rate;
        this.currencyId = currencyId;
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Long getRate() {
        return rate;
    }

    public void setRate(Long rate) {
        this.rate = rate;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    @NonNull
    @Override
    public String toString() {
        return "InstallmentsDTO{" +
                "quantity=" + quantity +
                ", amount=" + amount +
                ", rate=" + rate +
                ", currencyId='" + currencyId + '\'' +
                '}';
    }
}
