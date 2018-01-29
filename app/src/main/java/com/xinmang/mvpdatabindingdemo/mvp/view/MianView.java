package com.xinmang.mvpdatabindingdemo.mvp.view;

import com.xinmang.mvpdatabindingdemo.base.BaseMvpView;

/**
 * Created by lipei on 2018/1/27.
 */

public interface MianView extends BaseMvpView {
    void LoginLoading();
    void LoginSuccess();
    void LoginFail();
}
