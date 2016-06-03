package com.example.salilthip.myblog.activities;

import android.content.Intent;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.utils.Storage;

public class EditBlogActivity extends AppCompatActivity {

    private EditText titleBlog;
    private EditText descriptDetail;

    private Blog blog;
    private int locationList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_blog);
        Intent intent = getIntent();
        locationList = (int) intent.getSerializableExtra("pos_blog");
        Log.i("hello", locationList + "");
        blog = Storage.getInstance().getBlogList().get(locationList);
        initComponenets();
    }

    private void initComponenets() {
        titleBlog = (EditText)findViewById(R.id.title_edit_editpage);
        descriptDetail = (EditText)findViewById(R.id.descipt_edit_editpage);
        titleBlog.setText(blog.getTitle());
        descriptDetail.setText(blog.getDescription());



    }
}
