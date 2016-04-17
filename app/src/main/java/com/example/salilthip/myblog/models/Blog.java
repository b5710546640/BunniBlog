package com.example.salilthip.myblog.models;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Blog {

    String title;
    String description;
    Thumbnail thumbnail;

    public Blog(String title,String description){
        this.title = title;
        this.description = description;
        thumbnail = new Thumbnail(this);
    }

    public Thumbnail getThumbnail(){ return thumbnail; }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getTitle() {

        return title;
    }

    public String getDescription() {
        return description;
    }
}
