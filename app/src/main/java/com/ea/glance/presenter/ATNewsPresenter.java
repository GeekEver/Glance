package com.ea.glance.presenter;

import com.ea.glance.engine.EVNewsGainer;
import com.ea.glance.entity.EVNewsList;
import com.ea.glance.view.ATINewsView;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by yangzikang on 2017/4/1.
 */

public class ATNewsPresenter {
    private ATINewsView mNewsView;

    public ATNewsPresenter(ATINewsView view) {
        mNewsView = view;
    }

    public void loadNews() {
        EVNewsGainer.getInstance().getNews(0, new Observer<EVNewsList>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(EVNewsList evNewsList) {
                mNewsView.setList(evNewsList.getNewsList());
                mNewsView.initList();
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
        //mNewsView.setList(mNewsModelList.getLL());
    }
}
