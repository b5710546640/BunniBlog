package com.example.salilthip.myblog.models;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Blog {

    private String title;
    private String description;
    private Thumbnail thumbnail;
    private List<String> tags;

    public Blog(String title,String description){
        this.title = title;
        this.description = description;
        thumbnail = new Thumbnail(this);
        tags = new ArrayList<String>();
    }

    public void addTag(String tag){ tags.add(tag); }

    public List<String> getTags(){ return tags; }

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
