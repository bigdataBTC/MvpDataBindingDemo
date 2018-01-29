package com.xinmang.mvpdatabindingdemo.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.xinmang.mvpdatabindingdemo.R;
import com.xinmang.mvpdatabindingdemo.factory.PresenterMvpFactory;
import com.xinmang.mvpdatabindingdemo.factory.PresenterMvpFactoryIml;
import com.xinmang.mvpdatabindingdemo.proxy.BaseProxy;
import com.xinmang.mvpdatabindingdemo.proxy.PresenterProxyInterface;
import com.xinmang.mvpdatabindingdemo.utils.LogUtils;

/**
 * Created by lipei on 2018/1/27.
 */

public abstract class BaseActivity<V extends BaseMvpView,P extends BaseMvpPresenter<V>> extends AppCompatActivity implements PresenterProxyInterface<V,P>{
    public final static String TAG=BaseActivity.class.getName();
    private static final String PRESENTER_SAVE_KEY = "presenter_save_key";
    /**
     * 创建被代理的对象,传入默认Presenter的工厂
     */
    private BaseProxy<V,P> mProxy=new BaseProxy<>(PresenterMvpFactoryIml.<V,P>createFactory(getClass()));

    protected Context mContext;

    private boolean isShowToolBar=true;//是否显示通用的ToolBar,默认显示

    private int backPic= R.drawable.back_white;//默认返回图标,可修改

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        onRestore(savedInstanceState);
        mContext=this;
    }


    /**
     * 获取布局文件
     */
    protected abstract void getLayoutContent();

    /**
     * 初始化的方法
     */
    protected abstract void init();

    /**
     * 初始化数据
     */

    protected abstract void initData();

    /**
     *初始化监听
     */

    protected abstract void initEventer();


    private void onRestore(Bundle savedInstanceState){
        LogUtils.e(TAG,"onCreate");
        LogUtils.e(TAG,"mProxy="+mProxy);
        if(savedInstanceState!=null){
            mProxy.onRestoreInstanceState(savedInstanceState);
        }
        mProxy.onAttachView((V) this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mProxy.onDestory();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putBundle(PRESENTER_SAVE_KEY,mProxy.onSaveInstanceState());
    }

    @Override
    public void setPresenterFactory(PresenterMvpFactory<V, P> presenterFactory) {
        mProxy.setPresenterFactory(presenterFactory);
    }

    @Override
    public PresenterMvpFactory<V, P> getPresenterFactory() {
        return mProxy.getPresenterFactory();
    }

    @Override
    public P getPresenter() {
        return mProxy.getPresenter();
    }
}
