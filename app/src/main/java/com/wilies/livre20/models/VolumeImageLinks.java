package com.wilies.livre20.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VolumeImageLinks {
    @SerializedName("smallThumbnail")
    @Expose
    private String smallThumbnail;

    @SerializedName("thumbnail")
    @Expose
    private String thumbnail;

    public String getSmall() {
        return smallThumbnail;
    }

    public void setSmall(String small) {
        this.smallThumbnail = small;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    @Override
    public String toString() {
        return "VolumeImageLinks{" +
                "small='" + smallThumbnail + '\'' +
                ", large='" + thumbnail + '\'' +
                '}';
    }
}
