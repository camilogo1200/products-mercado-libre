
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ItemsQueryResultDTO implements Serializable {

    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("query")
    @Expose
    private String query;
    @SerializedName("paging")
    @Expose
    private PagingDTO paging;
    @SerializedName("results")
    @Expose
    private List<ResultDTO> results = new ArrayList<>();
    @SerializedName("secondary_results")
    @Expose
    private List<Object> secondaryResults = new ArrayList<>();
    @SerializedName("related_results")
    @Expose
    private List<Object> relatedResults = new ArrayList<>();
    @SerializedName("sort")
    @Expose
    private SortDTO sort;
    @SerializedName("available_sorts")
    @Expose
    private List<AvailableSortDTO> availableSorts = new ArrayList<>();
    @SerializedName("filters")
    @Expose
    private List<FilterDTO> filters = new ArrayList<>();
    @SerializedName("available_filters")
    @Expose
    private List<AvailableFilterDTO> availableFilters = new ArrayList<>();
    private static final long serialVersionUID = 7274285277094183055L;

    /**
     * No args constructor for use in serialization
     */
    public ItemsQueryResultDTO() {
    }

    /**
     * @param secondaryResults
     * @param relatedResults
     * @param availableSorts
     * @param availableFilters
     * @param query
     * @param siteId
     * @param paging
     * @param sort
     * @param filters
     * @param results
     */
    public ItemsQueryResultDTO(String siteId, String query, PagingDTO paging, List<ResultDTO> results, List<Object> secondaryResults, List<Object> relatedResults, SortDTO sort, List<AvailableSortDTO> availableSorts, List<FilterDTO> filters, List<AvailableFilterDTO> availableFilters) {
        super();
        this.siteId = siteId;
        this.query = query;
        this.paging = paging;
        this.results = results;
        this.secondaryResults = secondaryResults;
        this.relatedResults = relatedResults;
        this.sort = sort;
        this.availableSorts = availableSorts;
        this.filters = filters;
        this.availableFilters = availableFilters;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public PagingDTO getPaging() {
        return paging;
    }

    public void setPaging(PagingDTO paging) {
        this.paging = paging;
    }

    public List<ResultDTO> getResults() {
        return results;
    }

    public void setResults(List<ResultDTO> results) {
        this.results = results;
    }

    public List<Object> getSecondaryResults() {
        return secondaryResults;
    }

    public void setSecondaryResults(List<Object> secondaryResults) {
        this.secondaryResults = secondaryResults;
    }

    public List<Object> getRelatedResults() {
        return relatedResults;
    }

    public void setRelatedResults(List<Object> relatedResults) {
        this.relatedResults = relatedResults;
    }

    public SortDTO getSort() {
        return sort;
    }

    public void setSort(SortDTO sort) {
        this.sort = sort;
    }

    public List<AvailableSortDTO> getAvailableSorts() {
        return availableSorts;
    }

    public void setAvailableSorts(List<AvailableSortDTO> availableSorts) {
        this.availableSorts = availableSorts;
    }

    public List<FilterDTO> getFilters() {
        return filters;
    }

    public void setFilters(List<FilterDTO> filters) {
        this.filters = filters;
    }

    public List<AvailableFilterDTO> getAvailableFilters() {
        return availableFilters;
    }

    public void setAvailableFilters(List<AvailableFilterDTO> availableFilters) {
        this.availableFilters = availableFilters;
    }

    @NonNull
    @Override
    public String toString() {
        return "ItemsQueryResultDTO{" +
                "siteId='" + siteId + '\'' +
                ", query='" + query + '\'' +
                ", paging=" + paging +
                ", results=" + results +
                ", secondaryResults=" + secondaryResults +
                ", relatedResults=" + relatedResults +
                ", sort=" + sort +
                ", availableSorts=" + availableSorts +
                ", filters=" + filters +
                ", availableFilters=" + availableFilters +
                '}';
    }
}
