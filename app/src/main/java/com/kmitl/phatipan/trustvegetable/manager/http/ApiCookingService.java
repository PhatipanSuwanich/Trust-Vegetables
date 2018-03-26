package com.kmitl.phatipan.trustvegetable.manager.http;

import com.kmitl.phatipan.trustvegetable.dao.CookingItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public interface ApiCookingService {
    @POST("api.json?rss_url=http%3A%2F%2Filoapp.bkk96.com%2Fblog%2Fmat%3FRSS")
    Call<CookingItemCollectionDao> loadPhotoList();
}
