
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class ResultDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("site_id")
    @Expose
    private String siteId;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("seller")
    @Expose
    private SellerDTO seller;
    @SerializedName("price")
    @Expose
    private Long price;
    @SerializedName("currency_id")
    @Expose
    private String currencyId;
    @SerializedName("available_quantity")
    @Expose
    private Long availableQuantity;
    @SerializedName("sold_quantity")
    @Expose
    private Long soldQuantity;
    @SerializedName("buying_mode")
    @Expose
    private String buyingMode;
    @SerializedName("listing_type_id")
    @Expose
    private String listingTypeId;
    @SerializedName("stop_time")
    @Expose
    private String stopTime;
    @SerializedName("condition")
    @Expose
    private String condition;
    @SerializedName("permalink")
    @Expose
    private String permalink;
    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;
    @SerializedName("accepts_mercadopago")
    @Expose
    private Boolean acceptsMercadopago;
    @SerializedName("installments")
    @Expose
    private InstallmentsDTO installments;
    @SerializedName("address")
    @Expose
    private AddressDTO address;
    @SerializedName("shipping")
    @Expose
    private ShippingDTO shipping;
    @SerializedName("seller_address")
    @Expose
    private SellerAddress sellerAddress;
    @SerializedName("attributes")
    @Expose
    private List<AttributeDTO> attributes = new ArrayList<>();
    @SerializedName("original_price")
    @Expose
    private Long originalPrice;
    @SerializedName("category_id")
    @Expose
    private String categoryId;
    @SerializedName("official_store_id")
    @Expose
    private Object officialStoreId;
    @SerializedName("domain_id")
    @Expose
    private String domainId;
    @SerializedName("catalog_product_id")
    @Expose
    private String catalogProductId;
    @SerializedName("tags")
    @Expose
    private List<String> tags = new ArrayList<>();
    private static final long serialVersionUID = 762281334836362809L;

    /**
     * No args constructor for use in serialization
     */
    public ResultDTO() {
    }

    /**
     * @param seller
     * @param originalPrice
     * @param officialStoreId
     * @param catalogProductId
     * @param listingTypeId
     * @param sellerAddress
     * @param title
     * @param soldQuantity
     * @param shipping
     * @param installments
     * @param price
     * @param acceptsMercadopago
     * @param buyingMode
     * @param stopTime
     * @param id
     * @param currencyId
     * @param availableQuantity
     * @param thumbnail
     * @param address
     * @param domainId
     * @param tags
     * @param condition
     * @param siteId
     * @param attributes
     * @param permalink
     * @param categoryId
     */
    public ResultDTO(String id, String siteId, String title, SellerDTO seller, Long price, String currencyId, Long availableQuantity, Long soldQuantity, String buyingMode, String listingTypeId, String stopTime, String condition, String permalink, String thumbnail, Boolean acceptsMercadopago, InstallmentsDTO installments, AddressDTO address, ShippingDTO shipping, SellerAddress sellerAddress, List<AttributeDTO> attributes, Long originalPrice, String categoryId, Object officialStoreId, String domainId, String catalogProductId, List<String> tags) {
        super();
        this.id = id;
        this.siteId = siteId;
        this.title = title;
        this.seller = seller;
        this.price = price;
        this.currencyId = currencyId;
        this.availableQuantity = availableQuantity;
        this.soldQuantity = soldQuantity;
        this.buyingMode = buyingMode;
        this.listingTypeId = listingTypeId;
        this.stopTime = stopTime;
        this.condition = condition;
        this.permalink = permalink;
        this.thumbnail = thumbnail;
        this.acceptsMercadopago = acceptsMercadopago;
        this.installments = installments;
        this.address = address;
        this.shipping = shipping;
        this.sellerAddress = sellerAddress;
        this.attributes = attributes;
        this.originalPrice = originalPrice;
        this.categoryId = categoryId;
        this.officialStoreId = officialStoreId;
        this.domainId = domainId;
        this.catalogProductId = catalogProductId;
        this.tags = tags;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSiteId() {
        return siteId;
    }

    public void setSiteId(String siteId) {
        this.siteId = siteId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SellerDTO getSeller() {
        return seller;
    }

    public void setSeller(SellerDTO seller) {
        this.seller = seller;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public String getCurrencyId() {
        return currencyId;
    }

    public void setCurrencyId(String currencyId) {
        this.currencyId = currencyId;
    }

    public Long getAvailableQuantity() {
        return availableQuantity;
    }

    public void setAvailableQuantity(Long availableQuantity) {
        this.availableQuantity = availableQuantity;
    }

    public Long getSoldQuantity() {
        return soldQuantity;
    }

    public void setSoldQuantity(Long soldQuantity) {
        this.soldQuantity = soldQuantity;
    }

    public String getBuyingMode() {
        return buyingMode;
    }

    public void setBuyingMode(String buyingMode) {
        this.buyingMode = buyingMode;
    }

    public String getListingTypeId() {
        return listingTypeId;
    }

    public void setListingTypeId(String listingTypeId) {
        this.listingTypeId = listingTypeId;
    }

    public String getStopTime() {
        return stopTime;
    }

    public void setStopTime(String stopTime) {
        this.stopTime = stopTime;
    }

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
    }

    public String getPermalink() {
        return permalink;
    }

    public void setPermalink(String permalink) {
        this.permalink = permalink;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public Boolean getAcceptsMercadopago() {
        return acceptsMercadopago;
    }

    public void setAcceptsMercadopago(Boolean acceptsMercadopago) {
        this.acceptsMercadopago = acceptsMercadopago;
    }

    public InstallmentsDTO getInstallments() {
        return installments;
    }

    public void setInstallments(InstallmentsDTO installments) {
        this.installments = installments;
    }

    public AddressDTO getAddress() {
        return address;
    }

    public void setAddress(AddressDTO address) {
        this.address = address;
    }

    public ShippingDTO getShipping() {
        return shipping;
    }

    public void setShipping(ShippingDTO shipping) {
        this.shipping = shipping;
    }

    public SellerAddress getSellerAddress() {
        return sellerAddress;
    }

    public void setSellerAddress(SellerAddress sellerAddress) {
        this.sellerAddress = sellerAddress;
    }

    public List<AttributeDTO> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<AttributeDTO> attributes) {
        this.attributes = attributes;
    }

    public Long getOriginalPrice() {
        return originalPrice;
    }

    public void setOriginalPrice(Long originalPrice) {
        this.originalPrice = originalPrice;
    }

    public String getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(String categoryId) {
        this.categoryId = categoryId;
    }

    public Object getOfficialStoreId() {
        return officialStoreId;
    }

    public void setOfficialStoreId(Object officialStoreId) {
        this.officialStoreId = officialStoreId;
    }

    public String getDomainId() {
        return domainId;
    }

    public void setDomainId(String domainId) {
        this.domainId = domainId;
    }

    public String getCatalogProductId() {
        return catalogProductId;
    }

    public void setCatalogProductId(String catalogProductId) {
        this.catalogProductId = catalogProductId;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    @NonNull
    @Override
    public String toString() {
        return "ResultDTO{" +
                "id='" + id + '\'' +
                ", siteId='" + siteId + '\'' +
                ", title='" + title + '\'' +
                ", seller=" + seller +
                ", price=" + price +
                ", currencyId='" + currencyId + '\'' +
                ", availableQuantity=" + availableQuantity +
                ", soldQuantity=" + soldQuantity +
                ", buyingMode='" + buyingMode + '\'' +
                ", listingTypeId='" + listingTypeId + '\'' +
                ", stopTime='" + stopTime + '\'' +
                ", condition='" + condition + '\'' +
                ", permalink='" + permalink + '\'' +
                ", thumbnail='" + thumbnail + '\'' +
                ", acceptsMercadopago=" + acceptsMercadopago +
                ", installments=" + installments +
                ", address=" + address +
                ", shipping=" + shipping +
                ", sellerAddress=" + sellerAddress +
                ", attributes=" + attributes +
                ", originalPrice=" + originalPrice +
                ", categoryId='" + categoryId + '\'' +
                ", officialStoreId=" + officialStoreId +
                ", domainId='" + domainId + '\'' +
                ", catalogProductId='" + catalogProductId + '\'' +
                ", tags=" + tags +
                '}';
    }
}
