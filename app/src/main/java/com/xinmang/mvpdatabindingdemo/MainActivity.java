package com.xinmang.mvpdatabindingdemo;
import android.os.Bundle;
import android.widget.TextView;
import com.xinmang.mvpdatabindingdemo.base.BaseActivity;
import com.xinmang.mvpdatabindingdemo.factory.CreatePresenter;
import com.xinmang.mvpdatabindingdemo.mvp.presenter.MainPresenter;
import com.xinmang.mvpdatabindingdemo.mvp.view.MianView;

@CreatePresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MianView, MainPresenter> implements MianView {
    private TextView login;
    private String text="aa";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (TextView) findViewById(R.id.login);
        getPresenter().Login();

    }

    @Override
    public void LoginLoading() {
        login.setText("登录中...");

    }

    @Override
    public void LoginSuccess() {
        login.setText("登录成功...");

    }

    @Override
    public void LoginFail() {
        login.setText("登录失败...");

    }

}
