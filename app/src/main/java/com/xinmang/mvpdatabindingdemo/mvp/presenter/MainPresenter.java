package com.xinmang.mvpdatabindingdemo.mvp.presenter;

import com.xinmang.mvpdatabindingdemo.base.BaseBriadgeData;
import com.xinmang.mvpdatabindingdemo.base.BaseModel;
import com.xinmang.mvpdatabindingdemo.base.BaseMvpPresenter;
import com.xinmang.mvpdatabindingdemo.mvp.model.MainModelLml;
import com.xinmang.mvpdatabindingdemo.mvp.view.MianView;

/**
 * Created by lipei on 2018/1/27.
 */

public class MainPresenter extends BaseMvpPresenter<MianView> implements BaseBriadgeData.mainData{
    private BaseModel.mainMode mainMode;
    public MainPresenter(){
        mainMode=new MainModelLml();
    }


    public void Login(){
        getView().LoginLoading();
        mainMode.netWork(this);
    }
    @Override
    public void addData(String mList) {
        if(mList.equals("success")){
            getView().LoginSuccess();

        }else{
            getView().LoginFail();
        }

    }
}
