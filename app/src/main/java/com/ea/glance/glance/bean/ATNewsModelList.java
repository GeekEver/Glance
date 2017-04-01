package com.ea.glance.glance.bean;

import android.graphics.drawable.Drawable;

import com.ea.glance.glance.model.ATINewsModelList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangzikang on 2017/4/1.
 */

public class ATNewsModelList implements ATINewsModelList {
    private List<ATNewsModel> l = new ArrayList<ATNewsModel>();
    @Override
    public List<ATNewsModel> getL() {
        return l;
    }

    public void setL(List<ATNewsModel> l) {
        this.l = l;
    }
    @Override
    public List<ATNewsModel> getLL(){
        for(int i=0;i<10 ;i++){
            ATNewsModel newsModel = new ATNewsModel();
            newsModel.setNewsTitle("asdhajdnjn sndjkasndk jn涉及到金黄色");
            newsModel.setNewsContent("sdasajksd还是看好的话");
            newsModel.setTime("2001239902");
            newsModel.setNewsImageURL("http://cms-bucket.nosdn.127.net/f47cbc0c20cd42fba19142388f97c9a720160801102146.jpeg");
            l.add(newsModel);
        }
        return  l;
    }
}
