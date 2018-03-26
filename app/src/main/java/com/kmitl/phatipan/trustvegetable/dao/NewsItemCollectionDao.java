package com.kmitl.phatipan.trustvegetable.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public class NewsItemCollectionDao {
    @SerializedName("items") private List<NewsItemDao> item;

    public List<NewsItemDao> getItem() {
        return item;
    }

    public void setItem(List<NewsItemDao> item) {
        this.item = item;
    }
}
