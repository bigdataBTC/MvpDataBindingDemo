package com.xinmang.mvpdatabindingdemo.mvp.model;

import android.os.Handler;

import com.xinmang.mvpdatabindingdemo.base.BaseBriadgeData;
import com.xinmang.mvpdatabindingdemo.base.BaseModel;
import com.xinmang.mvpdatabindingdemo.bean.TextBean;
import com.xinmang.mvpdatabindingdemo.net.NetWorkRequest;
import com.xinmang.mvpdatabindingdemo.net.NetWorkSubscriber;

/**
 * Created by huwei on 2018/1/27.
 */

public class MainModelLml implements BaseModel.mainMode {


    @Override
    public void netWork(BaseBriadgeData.mainData mList) {
        NetWorkRequest.textNetWork(new NetWorkSubscriber<TextBean>(){
            @Override
            public void onError(Throwable e) {
                mList.error(e.toString());
            }

            @Override
            public void onNext(TextBean textBean) {
                mList.addData(textBean);

            }
        });

    }
}
