package com.xinmang.mvpdatabindingdemo.base;


public interface BaseModel<T> {
    void netWork(T mList);

    interface mainMode extends BaseModel<BaseBriadgeData.mainData>{};


}
