package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class ValueStructDTO implements Serializable {

    private final static long serialVersionUID = 2633979220139253532L;
    @SerializedName("number")
    @Expose
    private Long number;
    @SerializedName("unit")
    @Expose
    private String unit;

    /**
     * No args constructor for use in serialization
     */
    public ValueStructDTO() {
    }

    /**
     * @param number
     * @param unit
     */
    public ValueStructDTO(Long number, String unit) {
        super();
        this.number = number;
        this.unit = unit;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @NonNull
    @Override
    public String toString() {
        return "ValueStructDTO{" +
                "number=" + number +
                ", unit='" + unit + '\'' +
                '}';
    }
}
