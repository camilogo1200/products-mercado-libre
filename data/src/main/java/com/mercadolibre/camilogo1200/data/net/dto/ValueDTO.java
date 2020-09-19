
package com.mercadolibre.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class ValueDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("struct")
    @Expose
    private StructDTO struct;
    @SerializedName("source")
    @Expose
    private Long source;
    private final static long serialVersionUID = -8134721463116383679L;

    /**
     * No args constructor for use in serialization
     */
    public ValueDTO() {
    }

    /**
     * @param struct
     * @param name
     * @param id
     * @param source
     */
    public ValueDTO(String id, String name, StructDTO struct, Long source) {
        super();
        this.id = id;
        this.name = name;
        this.struct = struct;
        this.source = source;
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

    public StructDTO getStruct() {
        return struct;
    }

    public void setStruct(StructDTO struct) {
        this.struct = struct;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    @NotNull
    @Override
    public String toString() {
        return "ValueDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", struct=" + struct +
                ", source=" + source +
                '}';
    }
}
