package com.example.salilthip.myblog.adapters;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;


import com.example.salilthip.myblog.R;

import java.util.List;


/**
 * Created by Salilthip on 6/3/2016.
 */
public class GalleryAdapter extends ArrayAdapter<Bitmap> {
    public GalleryAdapter(Context context, int resource, List<Bitmap> objects) {
        super(context, resource, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;

        if(v==null){
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            v = vi.inflate(R.layout.image_cell, null);
        }

        ImageView image = (ImageView) v.findViewById(R.id.image_view);

        image.setImageBitmap(getItem(position));
        return v;
    }

}
