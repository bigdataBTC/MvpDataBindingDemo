package com.xinmang.mvpdatabindingdemo.api;

import com.xinmang.mvpdatabindingdemo.bean.TextBean;

import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by lipei on 2018/1/29.
 */

public interface ServiceApi {
    @GET(ApiContants.TEXT_URL)
    Observable<TextBean> getTextContent();

}
