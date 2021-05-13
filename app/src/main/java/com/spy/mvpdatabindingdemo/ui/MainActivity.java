package com.xinmang.mvpdatabindingdemo.ui;
import android.support.v7.widget.LinearLayoutManager;
import android.widget.TextView;

import com.xinmang.mvpdatabindingdemo.R;
import com.xinmang.mvpdatabindingdemo.adapter.MaintextAdapter;
import com.xinmang.mvpdatabindingdemo.base.BaseActivity;
import com.xinmang.mvpdatabindingdemo.bean.TextBean;
import com.xinmang.mvpdatabindingdemo.databinding.ActivityMainBinding;
import com.xinmang.mvpdatabindingdemo.factory.CreatePresenter;
import com.xinmang.mvpdatabindingdemo.mvp.presenter.MainPresenter;
import com.xinmang.mvpdatabindingdemo.mvp.view.MianView;
import com.xinmang.mvpdatabindingdemo.utils.LogUtils;

@CreatePresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MianView, MainPresenter,ActivityMainBinding> implements MianView {
    public final static String TAG=MainActivity.class.getName();
    private MaintextAdapter maintextAdapter;

    /**
     * 获取布局文件
     */
    @Override
    protected int getLayoutContent() {
        return R.layout.activity_main;
    }

    /**
     * 初始化的方法
     */
    @Override
    protected void init() {
        setmTitle(getString(R.string.mainTitle));
        maintextAdapter=new MaintextAdapter();
        mBindingView.setRvAdapter(maintextAdapter);
        mBindingView.setRvLayoutManager(new LinearLayoutManager(mContext));
    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        getPresenter().networkRequest();
    }

    /**
     * 初始化监听
     */
    @Override
    protected void initEventer() {

    }


    @Override
    public void success(TextBean textBean) {
        maintextAdapter.addData(textBean.getData());


    }

    @Override
    public void fail(String error) {
        LogUtils.e(TAG,error);

    }
}
