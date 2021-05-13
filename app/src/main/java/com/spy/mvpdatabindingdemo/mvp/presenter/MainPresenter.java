package com.xinmang.mvpdatabindingdemo.mvp.presenter;

import com.xinmang.mvpdatabindingdemo.base.BaseBriadgeData;
import com.xinmang.mvpdatabindingdemo.base.BaseModel;
import com.xinmang.mvpdatabindingdemo.base.BaseMvpPresenter;
import com.xinmang.mvpdatabindingdemo.bean.TextBean;
import com.xinmang.mvpdatabindingdemo.mvp.model.MainModelLml;
import com.xinmang.mvpdatabindingdemo.mvp.view.MianView;



public class MainPresenter extends BaseMvpPresenter<MianView> implements BaseBriadgeData.mainData{
    private BaseModel.mainMode mainMode;
    public MainPresenter(){
        mainMode=new MainModelLml();
    }

    public void networkRequest(){
        mainMode.netWork(this);
    }

    @Override
    public void addData(TextBean mList) {
        getView().success(mList);

    }

    @Override
    public void error(String error) {
        getView().fail(error);

    }
}
