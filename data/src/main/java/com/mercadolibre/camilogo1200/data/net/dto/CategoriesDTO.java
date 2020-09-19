package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Defines the fields for the Categories API Response
 *
 * @author Cristhian C. Gómez N
 * @see <a href="https://developers.mercadolibre.com.co/es_co/categorias-y-publicaciones#close">Mercadolibre Developers Sites Api</a>
 * @since 1.0
 */
public class CategoriesDTO implements Serializable {
    /**
     * @serial default category id
     */
    @SerializedName("id")
    @Expose
    private String id;
    /**
     * @serial default category name
     */
    @SerializedName("name")
    @Expose
    private String name;
    /**
     * @serial category picture
     */
    @SerializedName("picture")
    @Expose
    private String picture;
    /**
     * @serial category permalink
     */
    @SerializedName("permalink")
    @Expose
    private String permalink;
    /**
     * @serial category total items
     */
    @SerializedName("total_items_in_this_category")
    @Expose
    private String totalItems;


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

    @NonNull
    @Override
    public String toString() {
        return "CategoriesDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", picture='" + picture + '\'' +
                ", permalink='" + permalink + '\'' +
                ", totalItems='" + totalItems + '\'' +
                '}';
    }
}
