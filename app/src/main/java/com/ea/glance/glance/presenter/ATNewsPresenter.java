package com.ea.glance.glance.presenter;

import com.ea.glance.glance.bean.ATNewsModel;
import com.ea.glance.glance.bean.ATNewsModelList;
import com.ea.glance.glance.model.ATINewsModelList;
import com.ea.glance.glance.view.ATINewsView;

import java.util.List;

/**
 * Created by yangzikang on 2017/4/1.
 */

public class ATNewsPresenter {
    private ATINewsView mNewsView;
    private ATINewsModelList mNewsModelList;

    public ATNewsPresenter(ATINewsView view) {
        mNewsView = view;
        mNewsModelList = new ATNewsModelList();
    }

    public void loadNews() {
        mNewsView.setList(mNewsModelList.getLL());
    }
}
