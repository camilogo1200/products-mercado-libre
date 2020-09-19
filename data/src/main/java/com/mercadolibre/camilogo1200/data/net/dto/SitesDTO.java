package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Defines the fields for the Site APi Response
 *
 * @author Cristhian C. Gómez N
 * @see <a href="https://developers.mercadolibre.com.co/es_co/categorias-y-publicaciones#close">Mercadolibre Developers Sites Api</a>
 * @since 1.0
 */
public class SitesDTO implements Serializable {

    /**
     * @serial default site currency id
     */
    @SerializedName("default_currency_id")
    @Expose
    private String defaultCurrencyId;
    /**
     * @serial default site id
     */
    @SerializedName("id")
    @Expose
    private String id;
    /**
     * @serial default site name
     */
    @SerializedName("name")
    @Expose
    private String name;

    public String getDefaultCurrencyId() {
        return defaultCurrencyId;
    }

    public void setDefaultCurrencyId(String defaultCurrencyId) {
        this.defaultCurrencyId = defaultCurrencyId;
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

    @NonNull
    @Override
    public String toString() {
        return "SitesDTO{" +
                "defaultCurrencyId='" + defaultCurrencyId + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
