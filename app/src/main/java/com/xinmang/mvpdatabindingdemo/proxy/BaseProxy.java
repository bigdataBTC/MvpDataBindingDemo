package com.xinmang.mvpdatabindingdemo.proxy;

import android.os.Bundle;

import com.xinmang.mvpdatabindingdemo.base.BaseMvpPresenter;
import com.xinmang.mvpdatabindingdemo.base.BaseMvpView;
import com.xinmang.mvpdatabindingdemo.factory.PresenterMvpFactory;
import com.xinmang.mvpdatabindingdemo.utils.LogUtils;

/**
 * Created by lipei on 2018/1/27.
 */

public class BaseProxy<V extends BaseMvpView,P extends BaseMvpPresenter<V>> implements PresenterProxyInterface<V,P>{
    public final static String TAG=BaseProxy.class.getName();

    /**
     * 获取onSaveInstanceState中bundle的key
     */
    private static final String PRESENTER_KEY = "presenter_key";

    /**
     * Presenter工厂类
     */
    private PresenterMvpFactory<V,P> mFactroy;
    private P mPresenter;
    private Bundle mBundle;
    private boolean mIsAttchView;

    public BaseProxy(PresenterMvpFactory<V,P> mFactroy){
        this.mFactroy=mFactroy;

    }


    /**
     * 设置创建Presenter的工厂
     *
     * @param presenterFactory PresenterFactory的类型
     */
    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        if(mPresenter!=null){
            throw new IllegalArgumentException("这个方法只能在getMvpPresenter()之前调用，如果Presenter已经创建则不能再修改");
        }
        this.mFactroy=presenterFactory;

    }

    /**
     * 获取Presenter的工厂类
     *
     * @return PresenterFactory的类型
     */
    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return mFactroy;
    }

    /**
     * 获取指定类型的Presenter
     *
     * @return 指定类型的Presenter
     */
    @Override
    public P getPresenter() {
        if(mFactroy!=null){
            if(mPresenter==null){
                mPresenter=mFactroy.createPresenter();
                mPresenter.onCreatePersenter(mBundle==null ? null:mBundle.getBundle(PRESENTER_KEY));
            }

        }
        LogUtils.e(TAG,"mPresenter="+mPresenter);
        return mPresenter;
    }

    /**
     * 绑定Presenter和View
     * @param mView
     */
    public void onAttachView(V mView){
        getPresenter();
        if(mPresenter!=null && !mIsAttchView){
            mPresenter.onAttachView(mView);
            mIsAttchView=true;
        }

        LogUtils.e(TAG,"onResume");
    }


    /**
     * 销毁Presenter持有的View,解绑
     */
    public void onDetachView(){
        if(mPresenter!=null && mIsAttchView){
            mPresenter.onDetachView();
            mIsAttchView=false;
        }
        LogUtils.e(TAG,"onDetachView");
    }

    /**
     * 销毁Presenter
     */
    public void onDestory(){
        if(mPresenter!=null){
            onDetachView();
            mPresenter.onDestroyPresenter();
            mPresenter=null;
        }

        LogUtils.e(TAG,"onDestory");
    }

    /**
     * 意外销毁的时候调用
     * @return Bundle,存入回调给Presenter的Bundle和当前的Presenter的id
     */
    public Bundle onSaveInstanceState(){
        Bundle bundle=new Bundle();
        getPresenter();
        if(mPresenter!=null){
            Bundle presenterBUndle=new Bundle();
            mPresenter.onSaveInstanceState(presenterBUndle);
            bundle.putBundle(PRESENTER_KEY,presenterBUndle);
        }
        LogUtils.e(TAG,"onSaveInstanceState");
        return bundle;
    }

    /**
     * 意外关闭恢复Presenter
     * @param saveInstanceState 意外关闭时存储的Bundle
     */
    public void onRestoreInstanceState(Bundle saveInstanceState){
        LogUtils.e(TAG,"mPresenter="+mPresenter);
        LogUtils.e(TAG,"onRestoreInstanceState");
        mBundle=saveInstanceState;
    }


}
