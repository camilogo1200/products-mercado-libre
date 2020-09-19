
package com.mercadolibre.camilogo1200.data.net.dto;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.jetbrains.annotations.NotNull;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;


public class Value_DTO implements Serializable {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("path_from_root")
    @Expose
    private List<PathFromRootDTO> pathFromRoot = new ArrayList<>();
    private static final long serialVersionUID = -42051576961431853L;

    /**
     * No args constructor for use in serialization
     */
    public Value_DTO() {
    }

    /**
     * @param name
     * @param id
     * @param pathFromRoot
     */
    public Value_DTO(String id, String name, List<PathFromRootDTO> pathFromRoot) {
        super();
        this.id = id;
        this.name = name;
        this.pathFromRoot = pathFromRoot;
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

    public List<PathFromRootDTO> getPathFromRoot() {
        return pathFromRoot;
    }

    public void setPathFromRoot(List<PathFromRootDTO> pathFromRoot) {
        this.pathFromRoot = pathFromRoot;
    }

    @NotNull
    @Override
    public String toString() {
        return "Value_DTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", pathFromRoot=" + pathFromRoot +
                '}';
    }
}
