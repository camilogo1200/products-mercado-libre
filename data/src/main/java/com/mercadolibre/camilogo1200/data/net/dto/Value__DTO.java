
package com.mercadolibre.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;


public class Value__DTO implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("results")
    @Expose
    private Long results;
    private final static long serialVersionUID = 2711776479983783658L;

    /**
     * No args constructor for use in serialization
     */
    public Value__DTO() {
    }

    /**
     * @param name
     * @param id
     * @param results
     */
    public Value__DTO(String id, String name, Long results) {
        super();
        this.id = id;
        this.name = name;
        this.results = results;
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

    public Long getResults() {
        return results;
    }

    public void setResults(Long results) {
        this.results = results;
    }

    @NotNull
    @Override
    public String toString() {
        return "Value__DTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", results=" + results +
                '}';
    }
}
