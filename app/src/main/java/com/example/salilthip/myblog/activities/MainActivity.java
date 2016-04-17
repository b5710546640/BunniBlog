package com.example.salilthip.myblog.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.test.RenamingDelegatingContext;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.ListView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.adapters.BlogAdapter;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.models.Thumbnail;
import com.example.salilthip.myblog.utils.Storage;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BlogAdapter blogAdapter;
    private ListView blogCellListView;
//    private List<Thumbnail> thumbs;
    private List<Blog> dummyList;

    public void initComponents(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        blogCellListView = (ListView) findViewById(R.id.blog_cell_listview);
//        thumbs = new ArrayList<Thumbnail>();
        dummyList = new ArrayList<Blog>();
        blogAdapter = new BlogAdapter(this,R.layout.blog_cell,dummyList);
        blogCellListView.setAdapter(blogAdapter);

        FloatingActionButton addblog = (FloatingActionButton) findViewById(R.id.add_blog);
        addblog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CreateBlogActivity.class);
                startActivity(intent);
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    public void refresh(){
        dummyList.clear();
//        thumbs.clear();
//        thumbs.addAll(Storage.getInstance().getThumbList());
        dummyList.addAll(Storage.getInstance().getBlogList());
        blogAdapter.notifyDataSetChanged();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initComponents();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
