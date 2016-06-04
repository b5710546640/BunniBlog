package com.example.salilthip.myblog.utils;

import android.graphics.Bitmap;
import android.util.Log;

import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.models.Thumbnail;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class Storage {

    private static Storage instance;
    private List<Blog> blogList;
    private List<Thumbnail> thumbList;

    public static Storage getInstance(){
        if(instance==null) instance = new Storage();
        return instance;
    }


    public Storage(){
        blogList = new ArrayList<Blog>();
    }

    public void addNewBlog(Blog blog,List<Bitmap> gall){
        blog.addAllImage(gall);
        blog.makeThumbnail();
        blogList.add(blog);
    }

    public List<Blog> getBlogList(){ return blogList; }

    public List<Thumbnail> getThumbList() {
        return thumbList;
    }

    public static class Memento{

        private char[] stringTitle,stringDescription;

        public Memento(String title,String description){
            this.stringTitle = title.toCharArray();
            stringDescription = description.toCharArray();
        }

    }

}
