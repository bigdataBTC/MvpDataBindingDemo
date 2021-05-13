package com.xinmang.mvpdatabindingdemo.base;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.xinmang.mvpdatabindingdemo.utils.LogUtils;

import java.lang.ref.WeakReference;



public class BaseMvpPresenter<V extends BaseMvpView>{
    private WeakReference actReference;
    public final static String TAG=BaseMvpPresenter.class.getName();
    /**
     * V层view
     */
    private V mView;

    /**
     * Presenter被创建后调用
     * @param savedState 意外销毁后重建后的Bundle
     */

    public void onCreatePersenter(@Nullable Bundle savedState){
        LogUtils.e(TAG,"onCreatePersenter");
    }

    /**
     * 绑定view
     * @param mView
     */
    public void onAttachView(V mView){
        actReference = new WeakReference(mView);
        LogUtils.e(TAG,"onAttachView");

    }

    /**
     * 解绑view
     */
    public void onDetachView(){
        if (actReference != null) {
            actReference.clear();
            actReference = null;
        }
        LogUtils.e(TAG,"onDetachView");
    }

    /**
     * Presenter被销毁的时候调用
     */
    public void onDestroyPresenter(){
        LogUtils.e(TAG,"onDestroyPresenter");
    }

    /**
     * 在Presenter意外被销毁的时候被调用,其实和Activity、Fragment和View中onSaveInstanceStates被调用的时机相同
     * @param bundle
     */
    public void onSaveInstanceState(Bundle bundle){
        LogUtils.e(TAG,"onSaveInstanceState");
    }

    /**
     * 获取V层的view
     * @return
     */
    public V getView(){
        return (V) actReference.get();
    }
}
