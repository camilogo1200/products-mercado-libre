
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class PagingDTO implements Serializable {

    @SerializedName("total")
    @Expose
    private Long total;
    @SerializedName("primary_results")
    @Expose
    private Long primaryResults;
    @SerializedName("offset")
    @Expose
    private Long offset;
    @SerializedName("limit")
    @Expose
    private Long limit;
    private static final long serialVersionUID = -9038525543182954415L;

    /**
     * No args constructor for use in serialization
     */
    public PagingDTO() {
    }

    /**
     * @param total
     * @param offset
     * @param limit
     * @param primaryResults
     */
    public PagingDTO(Long total, Long primaryResults, Long offset, Long limit) {
        super();
        this.total = total;
        this.primaryResults = primaryResults;
        this.offset = offset;
        this.limit = limit;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getPrimaryResults() {
        return primaryResults;
    }

    public void setPrimaryResults(Long primaryResults) {
        this.primaryResults = primaryResults;
    }

    public Long getOffset() {
        return offset;
    }

    public void setOffset(Long offset) {
        this.offset = offset;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    @NonNull
    @Override
    public String toString() {
        return "PagingDTO{" +
                "total=" + total +
                ", primaryResults=" + primaryResults +
                ", offset=" + offset +
                ", limit=" + limit +
                '}';
    }
}
