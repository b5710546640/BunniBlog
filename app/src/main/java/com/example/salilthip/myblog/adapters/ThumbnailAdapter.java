package com.example.salilthip.myblog.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.salilthip.myblog.R;
import com.example.salilthip.myblog.models.Thumbnail;

import java.util.List;

/**
 * Created by Salilthip on 4/13/2016.
 */
public class ThumbnailAdapter extends ArrayAdapter<Thumbnail> {
    public ThumbnailAdapter(Context context, int resource, List<Thumbnail> thumbnails) {
        super(context, resource ,thumbnails);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.thumb_cell, null);
        }

        TextView title = (TextView) v.findViewById(R.id.title_cell);
        TextView descript = (TextView) v.findViewById(R.id.descript_cell);
        ImageView profile = (ImageView) v.findViewById(R.id.profile_image);

        title.setText(getItem(position).getTitle());
        descript.setText(getItem(position).getIntro());
        profile.setImageBitmap(getItem(position).getImageBlog());
        return v;
    }
}
