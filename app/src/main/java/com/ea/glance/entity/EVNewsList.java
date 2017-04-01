package com.ea.glance.entity;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by ever on 2017/4/1.
 */

public class EVNewsList {
    @SerializedName("T1348647909107")
    ArrayList<EVNewsEntity> newsList;
    public ArrayList<EVNewsEntity> getNewsList() {
        return newsList;
    }
    public void setNewsList(ArrayList<EVNewsEntity> newsList) {
        this.newsList = newsList;
    }
}
