package com.xinmang.mvpdatabindingdemo.base;

/**
 * Created by 李佩
 * @date 2018/01/27
 * @description model层的基类
 */

public interface BaseModel<T> {
    void netWork(T mList);

    interface mainMode extends BaseModel<BaseBriadgeData.mainData>{};


}
