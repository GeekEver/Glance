package com.ea.glance.glance.bean;

/**
 * Created by yangzikang on 2017/4/1.
 */

public class ATNewsModel{
    private String newsTitle;
    private String newsContent;
    private String time;
    private String newsImageURL;

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsImageURL() {
        return newsImageURL;
    }

    public void setNewsImageURL(String newsImageURL) {
        this.newsImageURL = newsImageURL;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
