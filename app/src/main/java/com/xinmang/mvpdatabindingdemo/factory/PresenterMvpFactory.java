package com.xinmang.mvpdatabindingdemo.factory;

import com.xinmang.mvpdatabindingdemo.base.BaseMvpPresenter;
import com.xinmang.mvpdatabindingdemo.base.BaseMvpView;

/**
 * @author 李佩
 * @date 2018/1/27
 * @description Presenter的工厂接口
 */

public interface PresenterMvpFactory<V extends BaseMvpView,P extends BaseMvpPresenter<V>>{
    /**
     * 创建Presnetr的方法
     * @return 需要的Presenter
     */

    P createPresenter();

}
