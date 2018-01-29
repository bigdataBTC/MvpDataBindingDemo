package com.xinmang.mvpdatabindingdemo.mvp.view;

import com.xinmang.mvpdatabindingdemo.base.BaseMvpView;
import com.xinmang.mvpdatabindingdemo.bean.TextBean;

/**
 * Created by lipei on 2018/1/27.
 */

public interface MianView extends BaseMvpView {
    void success(TextBean textBean);
    void fail(String error);
}
