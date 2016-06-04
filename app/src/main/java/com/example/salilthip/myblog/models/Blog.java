package com.example.salilthip.myblog.models;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Blog {

    private String title;
    private String description;
    private Thumbnail thumbnail;
    private Gallery gallery;
    private List<String> tags = new ArrayList<String>();

    public Blog(String title,String description,String tag){
        this.title = title;
        this.description = description;
        gallery = new Gallery(this);
        tags = setTag(tag);
    }

    public void makeThumbnail(){
        thumbnail = new Thumbnail(this);
    }

    public void addAllImage(List<Bitmap> images){
        gallery.clear();
        gallery.saveImageToGallery(images);
    }

    public Bitmap getImageBlog(){
        if(gallery.getGallery()==null){
            Log.i("NULLLL","NULLLLL");
        }
        return gallery.getGallery().get(0);
    }

    public Gallery getGallery(){ return gallery; }


    public Thumbnail getThumbnail(){ return thumbnail; }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public void addTag(String tag){ tags.add(tag); }

    public List<String> setTag(String tag){
        tags.clear();
        if(tag.length()==0){
            tags.add("Have no any tag");
            return tags;
        }
        String[] a = tag.split(",");
        for(int i=0;i<a.length;i++){
            tags.add(a[i]);
        }
        return tags;
    }

    public List<String> getTags(){ return tags; }
}
