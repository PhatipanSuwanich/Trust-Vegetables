package com.kmitl.phatipan.trustvegetable.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.kmitl.phatipan.trustvegetable.R;

/**
 * Created by phatipan on 1/11/2017 AD.
 */

public class StardardGridAdapter extends BaseAdapter {

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ImageView imageView;

        if (convertView == null) {
            imageView = new ImageView(parent.getContext());
            imageView.setLayoutParams(new GridView.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, 500));
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageView.setPadding(20, 20, 20, 20);
        } else {
            imageView = (ImageView) convertView;
        }

        switch (position){
            case 0 : imageView.setImageResource(R.mipmap.stardard);
                break;
            case 1 : imageView.setImageResource(R.mipmap.gmp);
                break;
            case 2 : imageView.setImageResource(R.mipmap.haccp);
                break;
            case 3 : imageView.setImageResource(R.mipmap.gap);
                break;
        }
        return imageView;
    }

}
