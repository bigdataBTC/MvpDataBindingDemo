package com.xinmang.mvpdatabindingdemo.mvp.model;

import android.os.Handler;

import com.xinmang.mvpdatabindingdemo.base.BaseBriadgeData;
import com.xinmang.mvpdatabindingdemo.base.BaseModel;

/**
 * Created by huwei on 2018/1/27.
 */

public class MainModelLml implements BaseModel.mainMode {

    @Override
    public void netWork(final BaseBriadgeData.mainData mList) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                mList.addData("success");
            }
        },1000);
    }
}
