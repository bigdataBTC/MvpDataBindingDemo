package com.xinmang.mvpdatabindingdemo.proxy;

import com.xinmang.mvpdatabindingdemo.base.BaseMvpPresenter;
import com.xinmang.mvpdatabindingdemo.base.BaseMvpView;
import com.xinmang.mvpdatabindingdemo.factory.PresenterMvpFactory;



public interface PresenterProxyInterface<V extends BaseMvpView,P extends BaseMvpPresenter<V>> {
    /**
     * 设置创建Presenter的工厂
     * @param presenterFactory PresenterFactory的类型
     */

    void setPresenterFactory(PresenterMvpFactory<V,P> presenterFactory);

    /**
     * 获取Presenter的工厂类
     * @return PresenterFactory的类型
     */

    PresenterMvpFactory<V,P> getPresenterFactory();

    /**
     * 获取指定类型的Presenter
     * @return 指定类型的Presenter
     */
    P getPresenter();
}
