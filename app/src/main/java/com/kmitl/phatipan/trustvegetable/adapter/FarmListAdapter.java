package com.kmitl.phatipan.trustvegetable.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.kmitl.phatipan.trustvegetable.R;
import com.kmitl.phatipan.trustvegetable.view.FarmListItem;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public class FarmListAdapter extends BaseAdapter {

    private FarmListItem item;
    private int lastPosition = -1;

    @Override
    public int getCount() {
        return 9;
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
        item = new FarmListItem(parent.getContext());
        item.setNameText(position);
        item.setDescriptionText(position);
        item.setImage(position);

        if (position > lastPosition) {
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(), R.anim.up_from_bottom);
            item.startAnimation(anim);
            lastPosition=position;
        }
       return item ;
    }

}
