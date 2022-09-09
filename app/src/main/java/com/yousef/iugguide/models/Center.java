package com.yousef.iugguide.models;

public class Center {

    private int id;
    private String title;
    private String email;
    private String url;
    private String about;
    private String imageUrl;

    public Center() {
    }

    public Center(int id, String title, String email, String url, String about, String imageUrl) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.url = url;
        this.about = about;
        this.imageUrl = imageUrl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return "Center{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", about='" + about + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                '}';
    }
}
