package com.yousef.iugguide.models;

public class HomeItem {

    private String  tag;
    private String title;
    private Integer imageResId;

    public HomeItem(String tag, String title, Integer imageResId) {
        this.tag = tag;
        this.title = title;
        this.imageResId = imageResId;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getImageResId() {
        return imageResId;
    }

    public void setImageResId(Integer imageResId) {
        this.imageResId = imageResId;
    }

    @Override
    public String toString() {
        return "HomeItem{" +
                "tag='" + tag + '\'' +
                ", title='" + title + '\'' +
                ", imageResId=" + imageResId +
                '}';
    }
}
