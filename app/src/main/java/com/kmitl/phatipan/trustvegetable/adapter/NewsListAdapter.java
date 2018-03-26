package com.kmitl.phatipan.trustvegetable.adapter;

import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;

import com.kmitl.phatipan.trustvegetable.R;
import com.kmitl.phatipan.trustvegetable.dao.NewsItemDao;
import com.kmitl.phatipan.trustvegetable.manager.NewsListManager;
import com.kmitl.phatipan.trustvegetable.view.NewsListItem;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public class NewsListAdapter extends BaseAdapter {
    int lastPosition = -1;

    @Override
    public int getCount() {
        if (NewsListManager.getInstance().getDao() == null)
            return 0;
        if (NewsListManager.getInstance().getDao().getItem() == null)
            return 0;

        return NewsListManager.getInstance().getDao().getItem().size();
    }

    @Override
    public Object getItem(int position) {
        return NewsListManager.getInstance().getDao().getItem().get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsListItem item;
        if (convertView != null)
            item = (NewsListItem) convertView;
        else
            item = new NewsListItem(parent.getContext());

        NewsItemDao dao = (NewsItemDao) getItem(position);
        item.setNameText(dao.getTitle());
        item.setDescriptionText(dao.getLink());
        item.setImage(position);

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
