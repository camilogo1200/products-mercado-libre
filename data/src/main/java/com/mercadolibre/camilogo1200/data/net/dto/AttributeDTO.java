
package com.mercadolibre.camilogo1200.data.net.dto;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class AttributeDTO implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("value_id")
    @Expose
    private String valueId;
    @SerializedName("value_name")
    @Expose
    private String valueName;
    @SerializedName("value_struct")
    @Expose
    private ValueStructDTO valueStruct;
    @SerializedName("values")
    @Expose
    private List<ValueDTO> values = new ArrayList<ValueDTO>();
    @SerializedName("attribute_group_id")
    @Expose
    private String attributeGroupId;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("attribute_group_name")
    @Expose
    private String attributeGroupName;
    @SerializedName("source")
    @Expose
    private Long source;
    private static final long serialVersionUID = 3946184975199118178L;

    /**
     * No args constructor for use in serialization
     */
    public AttributeDTO() {
    }

    /**
     * @param valueStruct
     * @param valueId
     * @param valueName
     * @param values
     * @param name
     * @param id
     * @param source
     * @param attributeGroupId
     * @param attributeGroupName
     */
    public AttributeDTO(String id, String valueId, String valueName, ValueStructDTO valueStruct, List<ValueDTO> values, String attributeGroupId, String name, String attributeGroupName, Long source) {
        super();
        this.id = id;
        this.valueId = valueId;
        this.valueName = valueName;
        this.valueStruct = valueStruct;
        this.values = values;
        this.attributeGroupId = attributeGroupId;
        this.name = name;
        this.attributeGroupName = attributeGroupName;
        this.source = source;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValueId() {
        return valueId;
    }

    public void setValueId(String valueId) {
        this.valueId = valueId;
    }

    public String getValueName() {
        return valueName;
    }

    public void setValueName(String valueName) {
        this.valueName = valueName;
    }

    public ValueStructDTO getValueStruct() {
        return valueStruct;
    }

    public void setValueStruct(ValueStructDTO valueStruct) {
        this.valueStruct = valueStruct;
    }

    public List<ValueDTO> getValues() {
        return values;
    }

    public void setValues(List<ValueDTO> values) {
        this.values = values;
    }

    public String getAttributeGroupId() {
        return attributeGroupId;
    }

    public void setAttributeGroupId(String attributeGroupId) {
        this.attributeGroupId = attributeGroupId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAttributeGroupName() {
        return attributeGroupName;
    }

    public void setAttributeGroupName(String attributeGroupName) {
        this.attributeGroupName = attributeGroupName;
    }

    public Long getSource() {
        return source;
    }

    public void setSource(Long source) {
        this.source = source;
    }

    @NonNull
    @Override
    public String toString() {
        return "AttributeDTO{" +
                "id='" + id + '\'' +
                ", valueId='" + valueId + '\'' +
                ", valueName='" + valueName + '\'' +
                ", valueStruct=" + valueStruct +
                ", values=" + values +
                ", attributeGroupId='" + attributeGroupId + '\'' +
                ", name='" + name + '\'' +
                ", attributeGroupName='" + attributeGroupName + '\'' +
                ", source=" + source +
                '}';
    }
}
