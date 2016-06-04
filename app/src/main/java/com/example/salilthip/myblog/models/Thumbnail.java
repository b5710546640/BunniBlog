package com.example.salilthip.myblog.models;

import android.graphics.Bitmap;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Thumbnail {

    private Blog blog;
    private String title;
    private String intro;
    private Bitmap imageBlog;

    public void setTitle(String title) {
        this.title = title;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Thumbnail(Blog b){
        blog = b;
        title = b.getTitle();
        intro = b.getDescription();
        if(b.getImageBlog()!=null)
        imageBlog = b.getImageBlog();
    }

    public Bitmap getImageBlog() {
        return imageBlog;
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }
}
