package com.example.salilthip.myblog.activities;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.utils.Storage;

public class CreateBlogActivity extends AppCompatActivity {

    private EditText titleEdt,descriptEdt;

    public void initComponent(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        titleEdt = (EditText) findViewById(R.id.title_edit);
        descriptEdt = (EditText) findViewById(R.id.descipt_edit);
        FloatingActionButton saveBlog = (FloatingActionButton) findViewById(R.id.save_new_blog);
        saveBlog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Blog b = new Blog(titleEdt.getText()+"",descriptEdt.getText()+"");
                Storage.getInstance().addNewBlog(b);
                finish();
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_blog);
        initComponent();
    }

}
