package com.xinmang.mvpdatabindingdemo.net;

import com.xinmang.mvpdatabindingdemo.bean.TextBean;
import com.xinmang.mvpdatabindingdemo.utils.RxUtils;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by 李佩
 * @date 2018/01/28
 * @desrcption 所有网络请求的封装
 */

public class NetWorkRequest {
    private static <M> void addObservable(Observable<M> observable, Subscriber<M> subscriber){
        RxUtils.getInstance().addSubscription(observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber));
    }

    /**
     * 这个网络请求是访问我自己定义的接口,可根据实际开发传入对应的参数
     * @param subscriber
     */
    public static void textNetWork(Subscriber<TextBean> subscriber){
        addObservable(ApiFactory.getServiceApi().getTextContent(),subscriber);
    }
}
