package com.wilies.livre20.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeResponse {
    @SerializedName("kind")
    @Expose
    private String kind;

    @SerializedName("items")
    @Expose
    private List<Volume> items = null;

    @SerializedName("totalItems")
    @Expose
    private int totalItems;

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public void setTotalItems(int totalItems) {
        this.totalItems = totalItems;
    }

    public List<Volume> getItems() {
        return items;
    }

    public void setItems(List<Volume> items) {
        this.items = items;
    }
}
