package com.xinmang.mvpdatabindingdemo.api;

import com.xinmang.mvpdatabindingdemo.bean.TextBean;

import retrofit2.http.GET;
import rx.Observable;



public interface ServiceApi {
    @GET(ApiContants.TEXT_URL)
    Observable<TextBean> getTextContent();

}
