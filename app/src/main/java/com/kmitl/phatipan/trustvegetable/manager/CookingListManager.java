package com.kmitl.phatipan.trustvegetable.manager;

import android.content.Context;

import com.kmitl.phatipan.trustvegetable.dao.CookingItemCollectionDao;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class CookingListManager {

    private static CookingListManager instance;

    public static CookingListManager getInstance() {
        if (instance == null)
            instance = new CookingListManager();
        return instance;
    }

    private Context mContext;
    private CookingItemCollectionDao dao;

    private CookingListManager() {
        mContext = Contextor.getInstance().getContext();
    }

    public CookingItemCollectionDao getDao() {
        return dao;
    }

    public void setDao(CookingItemCollectionDao dao) {
        this.dao = dao;
    }
}
