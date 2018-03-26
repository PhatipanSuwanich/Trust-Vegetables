package com.kmitl.phatipan.trustvegetable.manager.http;

import com.kmitl.phatipan.trustvegetable.dao.NewsItemCollectionDao;

import retrofit2.Call;
import retrofit2.http.POST;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public interface ApiNewsService {
    @POST("api.json?rss_url=http%3A%2F%2Fpandinthong.com%2Frss%2Fotop.xml")
    Call<NewsItemCollectionDao> loadPhotoList();
}
