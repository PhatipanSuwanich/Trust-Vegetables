package com.kmitl.phatipan.trustvegetable.manager;

import android.content.Context;

import com.kmitl.phatipan.trustvegetable.dao.NewsItemCollectionDao;


/**
 * Created by nuuneoi on 11/16/2014.
 */
public class NewsListManager {

    private static NewsListManager instance;

    public static NewsListManager getInstance() {
        if (instance == null)
            instance = new NewsListManager();
        return instance;
    }

    private Context mContext;
    private NewsItemCollectionDao dao;

    private NewsListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public NewsItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(NewsItemCollectionDao dao) {
        this.dao = dao;
    }
}
