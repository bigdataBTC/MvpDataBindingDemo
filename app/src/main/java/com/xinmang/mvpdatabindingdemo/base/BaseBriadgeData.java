package com.xinmang.mvpdatabindingdemo.base;

import java.util.List;

/**
 * Created by 李佩
 * @date 2018/01/27
 * @description Model层和Presenter数据交互的桥梁
 */

public interface BaseBriadgeData<T> {
    void addData(T mList);

    interface mainData extends BaseBriadgeData<String>{};

}
