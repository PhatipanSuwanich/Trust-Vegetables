package com.kmitl.phatipan.trustvegetable.dao;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public class CookingItemCollectionDao {
    @SerializedName("items") private List<CookingItemDao> item;

    public List<CookingItemDao> getItem() {
        return item;
    }

    public void setItem(List<CookingItemDao> item) {
        this.item = item;
    }
}
