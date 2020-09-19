
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class SellerDTO implements Serializable
{

    @SerializedName("id")
    @Expose
    private Long id;
    @SerializedName("permalink")
    @Expose
    private Object permalink;
    @SerializedName("registration_date")
    @Expose
    private Object registrationDate;
    @SerializedName("car_dealer")
    @Expose
    private Boolean carDealer;
    @SerializedName("real_estate_agency")
    @Expose
    private Boolean realEstateAgency;
    @SerializedName("tags")
    @Expose
    private Object tags;
    private static final long serialVersionUID = -1940634293783132879L;

    /**
     * No args constructor for use in serialization
     * 
     */
    public SellerDTO() {
    }

    /**
     * 
     * @param realEstateAgency
     * @param registrationDate
     * @param carDealer
     * @param id
     * @param permalink
     * @param tags
     */
    public SellerDTO(Long id, Object permalink, Object registrationDate, Boolean carDealer, Boolean realEstateAgency, Object tags) {
        super();
        this.id = id;
        this.permalink = permalink;
        this.registrationDate = registrationDate;
        this.carDealer = carDealer;
        this.realEstateAgency = realEstateAgency;
        this.tags = tags;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Object getPermalink() {
        return permalink;
    }

    public void setPermalink(Object permalink) {
        this.permalink = permalink;
    }

    public Object getRegistrationDate() {
        return registrationDate;
    }

    public void setRegistrationDate(Object registrationDate) {
        this.registrationDate = registrationDate;
    }

    public Boolean getCarDealer() {
        return carDealer;
    }

    public void setCarDealer(Boolean carDealer) {
        this.carDealer = carDealer;
    }

    public Boolean getRealEstateAgency() {
        return realEstateAgency;
    }

    public void setRealEstateAgency(Boolean realEstateAgency) {
        this.realEstateAgency = realEstateAgency;
    }

    public Object getTags() {
        return tags;
    }

    public void setTags(Object tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public String toString() {
        return "SellerDTO{" +
                "id=" + id +
                ", permalink=" + permalink +
                ", registrationDate=" + registrationDate +
                ", carDealer=" + carDealer +
                ", realEstateAgency=" + realEstateAgency +
                ", tags=" + tags +
                '}';
    }
}
