package com.example.salilthip.myblog.models;

import android.graphics.Bitmap;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Thumbnail {

    private Blog blog;
    private String title;
    private String intro;

    public Thumbnail(Blog b){
        blog = b;
        title = b.getTitle();
        intro = b.getDescription();
    }

    public String getTitle() {
        return title;
    }

    public String getIntro() {
        return intro;
    }
}
