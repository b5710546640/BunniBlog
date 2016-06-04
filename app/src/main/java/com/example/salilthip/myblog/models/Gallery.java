package com.example.salilthip.myblog.models;

import android.graphics.Bitmap;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Gallery {

    private List<Bitmap> gall;
    private Blog blog;

    public Gallery(Blog blog){
        this.blog = blog;
        gall = new ArrayList<Bitmap>();
    }


    public List<Bitmap> getGallery(){
        return gall;
    }

    public void clear(){ gall.clear(); }

    public void saveImageToGallery(List<Bitmap> images) {
        gall.addAll(images);
    }
}
