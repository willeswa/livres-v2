package com.wilies.livre20.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VolumeInfo {

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("authors")
    @Expose
    private List authors;

    @SerializedName("publisher")
    @Expose
    private String publisher;

    @SerializedName("imageLinks")
    @Expose
    private VolumeImageLinks imageLinks;

    public VolumeImageLinks getImageLinks() {
        return imageLinks;
    }

    public void setImageLinks(VolumeImageLinks imageLinks) {
        this.imageLinks = imageLinks;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public List getAuthors() {
        return authors;
    }

    public void setAuthors(List authors) {
        this.authors = authors;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
