package com.example.salilthip.myblog.activities;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.adapters.GalleryAdapter;
import com.example.salilthip.myblog.adapters.ThumbnailAdapter;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.models.Thumbnail;
import com.example.salilthip.myblog.utils.Storage;

import java.util.List;

public class EditBlogActivity extends AppCompatActivity {

    private EditText titleBlog;
    private EditText descriptDetail;
    private EditText tags;
    private GridView gallery;
    private List<Bitmap> gall;
    protected GalleryAdapter adapterGalleryEditPage;
    private Blog blog;
    private int locationList;
    private FloatingActionButton finishEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_blog);
        Intent intent = getIntent();
        locationList = (int) intent.getSerializableExtra("pos_blog");
        Log.i("hello", locationList + "");
        blog = Storage.getInstance().getBlogList().get(locationList);
        gall = blog.getGallery().getGallery();
        initComponenets();
    }

    private void refreshText(){

        titleBlog.setText(blog.getTitle());
        descriptDetail.setText(blog.getDescription());

        String s="";
        for(String a: blog.getTags()) s+=a+",";
        tags.setText(s.substring(0,s.length()-1));
    }


    private void initComponenets() {

        gallery = (GridView) findViewById(R.id.gallery_editpage);
        adapterGalleryEditPage = new GalleryAdapter(this,R.layout.image_cell,gall);

        gallery.setAdapter(adapterGalleryEditPage);

        titleBlog = (EditText)findViewById(R.id.title_edit_editpage);

        descriptDetail = (EditText)findViewById(R.id.descipt_edit_editpage);

        finishEdit = (FloatingActionButton) findViewById(R.id.finish_edit_blog);

        tags = (EditText) findViewById(R.id.insert_tag_editpage);

        refreshText();

        finishEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Storage.getInstance().getBlogList().get(locationList).setTitle(titleBlog.getText()+"");
                Storage.getInstance().getBlogList().get(locationList).setDescription(descriptDetail.getText() + "");
                Storage.getInstance().getBlogList().get(locationList).setTag(tags.getText()+"");
                finish();
            }
        });



    }
}
