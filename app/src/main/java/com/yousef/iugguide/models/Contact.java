package com.yousef.iugguide.models;

public class Contact {

    private int id;
    private String title;
    private String email;
    private String url;
    private String about;
    private String type;

    public Contact() {
    }

    public Contact(int id, String title, String email, String url, String about, String type) {
        this.id = id;
        this.title = title;
        this.email = email;
        this.url = url;
        this.about = about;
        this.type = type;
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

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", email='" + email + '\'' +
                ", url='" + url + '\'' +
                ", about='" + about + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
