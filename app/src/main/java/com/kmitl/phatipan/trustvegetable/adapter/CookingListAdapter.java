package com.kmitl.phatipan.trustvegetable.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.kmitl.phatipan.trustvegetable.R;
import com.kmitl.phatipan.trustvegetable.dao.CookingItemDao;
import com.kmitl.phatipan.trustvegetable.manager.CookingListManager;
import com.kmitl.phatipan.trustvegetable.view.CookingListItem;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public class CookingListAdapter extends BaseAdapter {
    int lastPosition = -1;


    @Override
    public int getCount() {
        if (CookingListManager.getInstance().getDao() == null)
            return 0;
        if (CookingListManager.getInstance().getDao().getItem() == null)
            return 0;

        return CookingListManager.getInstance().getDao().getItem().size();
    }

    @Override
    public Object getItem(int position) {
        return CookingListManager.getInstance().getDao().getItem().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        CookingListItem item;
        if (convertView != null)
            item = (CookingListItem) convertView;
        else
            item = new CookingListItem(parent.getContext());

        CookingItemDao dao = (CookingItemDao) getItem(position);
        item.setNameText(dao.getTitle());
        item.setDescriptionText(dao.getDescription());
        item.setImage(dao.getGuid());

        if (position > lastPosition) {
            Animation anim = AnimationUtils.loadAnimation(parent.getContext(), R.anim.up_from_bottom);
            item.startAnimation(anim);
            lastPosition=position;
        }
        return item;

    }

    @Nullable
    @Override
    public CharSequence[] getAutofillOptions() {
        return new CharSequence[0];
    }
}
