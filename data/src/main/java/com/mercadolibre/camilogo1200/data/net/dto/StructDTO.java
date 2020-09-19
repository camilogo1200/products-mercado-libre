
package com.mercadolibre.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class StructDTO implements Serializable {

    @SerializedName("number")
    @Expose
    private Long number;
    @SerializedName("unit")
    @Expose
    private String unit;
    private static final long serialVersionUID = 4595925397019603939L;

    /**
     * No args constructor for use in serialization
     */
    public StructDTO() {
    }

    /**
     * @param number
     * @param unit
     */
    public StructDTO(Long number, String unit) {
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
    
    @NotNull
    @Override
    public String toString() {
        return "StructDTO{" +
                "number=" + number +
                ", unit='" + unit + '\'' +
                '}';
    }
}
