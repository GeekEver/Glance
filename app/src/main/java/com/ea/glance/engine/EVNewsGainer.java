package com.ea.glance.engine;

import com.ea.glance.entity.EVNewsList;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
//import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * Created by ever on 2017/4/1.
 */

public class EVNewsGainer {
    private static final String BASE_URL="http://c.m.163.com";
    private static final int DEFAULT_TIMEOUT=5;
    private EVNewsService mEVNewsService;
    private Retrofit mRetrofitForList;
    private Retrofit mRetrofitForDetail;
    private static final EVNewsGainer NEWS_GAINER=new EVNewsGainer();
    private EVNewsGainer(){
        OkHttpClient.Builder httpClientBulider=new OkHttpClient().newBuilder();
        httpClientBulider.connectTimeout(DEFAULT_TIMEOUT, TimeUnit.SECONDS);
        mRetrofitForList = new Retrofit.Builder()
                .client(httpClientBulider.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
        mRetrofitForDetail=new Retrofit.Builder()
                .client(httpClientBulider.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(ScalarsConverterFactory.create())
                .baseUrl(BASE_URL)
                .build();
    }
    public static EVNewsGainer getInstance(){
        return NEWS_GAINER;
    }
    public void getNews(int page,Observer<EVNewsList> observer){
        synchronized (this) {
            mEVNewsService = mRetrofitForList.create(EVNewsService.class);
        }
        mEVNewsService.getNews(page)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }
    public void getNewsDetail(String docid,Observer<String> observer){
        synchronized (this) {
            mEVNewsService = mRetrofitForDetail.create(EVNewsService.class);
        }
        mEVNewsService.getNewsDetail(docid)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
    }

}
