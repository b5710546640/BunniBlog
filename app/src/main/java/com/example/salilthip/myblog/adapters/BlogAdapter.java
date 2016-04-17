package com.example.salilthip.myblog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.models.Blog;
import com.example.salilthip.myblog.models.Thumbnail;

import java.util.List;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class BlogAdapter extends ArrayAdapter<Blog> {
    public BlogAdapter(Context context, int resource, List<Blog> thumbnails) {
        super(context, resource ,thumbnails);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.blog_cell, null);
        }

        TextView title = (TextView) v.findViewById(R.id.title_cell);
        TextView descript = (TextView) v.findViewById(R.id.descript_cell);

        title.setText(getItem(position).getTitle());
        descript.setText(getItem(position).getDescription());
        return v;
    }
}
