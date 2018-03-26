package com.kmitl.phatipan.trustvegetable.manager.http;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kmitl.phatipan.trustvegetable.manager.Contextor;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by nuuneoi on 11/16/2014.
 */
public class HttpManager {

    private static HttpManager instance;
    private ApiCookingService cookingservice;
    private ApiNewsService newsservice;

    public static HttpManager getInstance() {
        if (instance == null)
            instance = new HttpManager();
        return instance;
    }

    private Context mContext;


    private HttpManager() {

        Gson gson = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();

        mContext = Contextor.getInstance().getContext();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.rss2json.com/v1/")
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        cookingservice = retrofit.create(ApiCookingService.class);
        newsservice = retrofit.create(ApiNewsService.class);
    }

    public ApiCookingService getCookingService(){
        return cookingservice;
    }

    public ApiNewsService getNewsService(){
        return newsservice;
    }
}
