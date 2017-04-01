package com.ea.glance.engine;

import com.ea.glance.entity.EVNewsList;

import retrofit2.http.GET;
import retrofit2.http.Path;
import io.reactivex.*;

/**
 * Created by ever on 2017/4/1.
 */

public interface EVINewsService {
    @GET("http://c.m.163.com/nc/article/headline/T1348647909107/{id}-20.html")
    Observable<EVNewsList> getNews(@Path("id") int id );

    @GET("http://c.m.163.com/nc/article/{id}/full.html")
    Observable<String> getNewsDetail(@Path("id") String id);
}
