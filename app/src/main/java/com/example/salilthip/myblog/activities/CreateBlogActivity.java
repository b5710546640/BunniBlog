package com.example.salilthip.myblog.activities;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.adapters.GalleryAdapter;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.utils.Storage;

import java.util.ArrayList;
import java.util.List;

public class CreateBlogActivity extends AppCompatActivity {

    private EditText titleEdt,descriptEdt;
    private static int RESULT_LOAD_IMAGE = 1;
    private ImageButton addImage;
    private GridView gallery;
    private GalleryAdapter adapterGallery;
    private List<Bitmap> gall;

    public void initComponent(){
        gall = new ArrayList<Bitmap>();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titleEdt = (EditText) findViewById(R.id.title_edit);

        descriptEdt = (EditText) findViewById(R.id.descipt_edit);

        addImage = (ImageButton) findViewById(R.id.add_image);
        gallery = (GridView) findViewById(R.id.gallery);
        adapterGallery = new GalleryAdapter(this,R.layout.image_cell,gall);
        gallery.setAdapter(adapterGallery);
        addImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {

                Intent i = new Intent(
                        Intent.ACTION_PICK,
                        android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);

                startActivityForResult(i, RESULT_LOAD_IMAGE);
            }
        });

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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.i("kk","l");
        if (requestCode == RESULT_LOAD_IMAGE && resultCode == RESULT_OK && null != data) {
            Uri selectedImage = data.getData();
            String[] filePathColumn = { MediaStore.Images.Media.DATA };

            Cursor cursor = getContentResolver().query(selectedImage,
                    filePathColumn, null, null, null);
            cursor.moveToFirst();

            int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
            String picturePath = cursor.getString(columnIndex);
            cursor.close();

            gall.add(BitmapFactory.decodeFile(picturePath));
            adapterGallery.notifyDataSetChanged();

        }


    }

}
