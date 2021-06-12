package com.wilies.livre20.models;

import java.util.List;

public class VolumeInfo {
    private String title;
    private List authors;
    private String publisher;
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
