package com.kmitl.phatipan.trustvegetable.dao;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by phatipan on 29/10/2017 AD.
 */

public class CookingItemDao implements Parcelable {
    @SerializedName("title") private String title;
    @SerializedName("pubDate") private Date time;
    @SerializedName("link") private String link;
    @SerializedName("guid") private String guid;
    @SerializedName("author") private String author;
    @SerializedName("thumbnail") private String thumbnail;
    @SerializedName("description") private String description;
    @SerializedName("content") private String content;
    @SerializedName("enclosure") private List enclosure;
    @SerializedName("categories") private List categories;


    protected CookingItemDao(Parcel in) {
        title = in.readString();
        link = in.readString();
        guid = in.readString();
        author = in.readString();
        thumbnail = in.readString();
        description = in.readString();
        content = in.readString();
    }

    public static final Creator<CookingItemDao> CREATOR = new Creator<CookingItemDao>() {
        @Override
        public CookingItemDao createFromParcel(Parcel in) {
            return new CookingItemDao(in);
        }

        @Override
        public CookingItemDao[] newArray(int size) {
            return new CookingItemDao[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getGuid() {
        return guid;
    }

    public void setGuid(String guid) {
        this.guid = guid;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public List getEnclosure() {
        return enclosure;
    }

    public void setEnclosure(List enclosure) {
        this.enclosure = enclosure;
    }

    public List getCategories() {
        return categories;
    }

    public void setCategories(List categories) {
        this.categories = categories;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(link);
        dest.writeString(guid);
        dest.writeString(author);
        dest.writeString(thumbnail);
        dest.writeString(description);
        dest.writeString(content);
    }
}
