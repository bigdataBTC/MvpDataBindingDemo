package com.xinmang.mvpdatabindingdemo.net;

import com.xinmang.mvpdatabindingdemo.api.ServiceApi;
import com.xinmang.mvpdatabindingdemo.app.Application;
import com.xinmang.mvpdatabindingdemo.app.Contants;
import com.xinmang.mvpdatabindingdemo.utils.StateUtils;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 李佩
 * @date 2018/01/28
 * @desrcption Retrofit的封装
 */

public class ApiRetrofit {

    public static final String BASE_URL = Contants.BASE_URL;

    private ServiceApi serviceApi;

    public ServiceApi getZhihuApiService() {
        return serviceApi;
    }

    ApiRetrofit(){
        //cache url
        File httpCacheDirectory=new File(Application.getInstance().getCacheDir(), Contants.cacaheFileName);//缓存路径
        int cacheSize=10*1024*1024;//缓存大小10Mib
        Cache cache=new Cache(httpCacheDirectory,cacheSize);

        Interceptor REWRITE_CACHE_CONTROL_INTERCEPTOR=chain -> {
            CacheControl.Builder cacheBuilder=new CacheControl.Builder();
            cacheBuilder.maxAge(0, TimeUnit.SECONDS);
            cacheBuilder.maxStale(365,TimeUnit.DAYS);
            CacheControl cacheControl=cacheBuilder.build();

            Request request=chain.request();
            if (!StateUtils.isNetworkAvailable(Application.getInstance())) {
                request = request.newBuilder()
                        .cacheControl(cacheControl)
                        .build();

            }
            Response originalResponse = chain.proceed(request);
            if (StateUtils.isNetworkAvailable(Application.getInstance())) {
                int maxAge = 0; // read from cache
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public ,max-age=" + maxAge)
                        .build();
            } else {
                int maxStale = 60 * 60 * 24 * 28; // tolerate 4-weeks stale
                return originalResponse.newBuilder()
                        .removeHeader("Pragma")
                        .header("Cache-Control", "public, only-if-cached, max-stale=" + maxStale)
                        .build();
            }
        };

        OkHttpClient okHttpClient=new OkHttpClient.Builder()
                .addInterceptor(REWRITE_CACHE_CONTROL_INTERCEPTOR)
                .cache(cache).build();

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        serviceApi=retrofit.create(ServiceApi.class);

    }
}
