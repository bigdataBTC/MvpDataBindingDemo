package com.xinmang.mvpdatabindingdemo.factory;

import com.xinmang.mvpdatabindingdemo.base.BaseMvpPresenter;
import com.xinmang.mvpdatabindingdemo.base.BaseMvpView;



public class PresenterMvpFactoryIml<V extends BaseMvpView,P extends BaseMvpPresenter<V>> implements  PresenterMvpFactory<V,P>{
    /**
     * 需要创建的Presenter的类型
     */

    private final Class<P> mPresenterClass;

    private PresenterMvpFactoryIml(Class<P> mPresenterClass ) {
        this.mPresenterClass=mPresenterClass;
    }

    /**
     * 根据工厂来创建Presenter的实现类
     * @param viewClass 需要创建Presenter的V层实现类
     * @param <V> 当前的View层接口类型
     * @param <P>  当前需要创建的Presenter类型
     * @return 工厂类
     */

    public static <V extends BaseMvpView,P extends BaseMvpPresenter<V>> PresenterMvpFactoryIml<V,P> createFactory(Class<?> viewClass){
        CreatePresenter annotation=viewClass.getAnnotation(CreatePresenter.class);
        Class<P> pClass=null;
        if(annotation!=null){
            pClass= (Class<P>) annotation.value();
        }
        return pClass==null ? null : new PresenterMvpFactoryIml<V,P>(pClass);
    }
    /**
     * 创建Presnetr的方法
     *
     * @return 需要的Presenter
     */
    @Override
    public P createPresenter() {
        try {
            return mPresenterClass.newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Presenter创建失败!，检查是否声明了@CreatePresenter(xx.class)注解");
        }
    }
}
