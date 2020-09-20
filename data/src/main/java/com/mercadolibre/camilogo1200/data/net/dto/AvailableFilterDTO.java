
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AvailableFilterDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("type")
    @Expose
    private String type;
    @SerializedName("values")
    @Expose
    private List<Value__DTO> values = new ArrayList<>();
    private static final long serialVersionUID = 7962938143378638268L;

    /**
     * No args constructor for use in serialization
     */
    public AvailableFilterDTO() {
    }

    /**
     * @param values
     * @param name
     * @param id
     * @param type
     */
    public AvailableFilterDTO(String id, String name, String type, List<Value__DTO> values) {
        super();
        this.id = id;
        this.name = name;
        this.type = type;
        this.values = values;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public List<Value__DTO> getValues() {
        return values;
    }

    public void setValues(List<Value__DTO> values) {
        this.values = values;
    }

    @NonNull
    @Override
    public String toString() {
        return "AvailableFilterDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", values=" + values +
                '}';
    }
}
