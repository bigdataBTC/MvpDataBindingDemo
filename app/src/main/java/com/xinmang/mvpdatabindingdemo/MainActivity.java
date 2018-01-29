package com.xinmang.mvpdatabindingdemo;
import android.os.Bundle;
import android.widget.TextView;
import com.xinmang.mvpdatabindingdemo.base.BaseActivity;
import com.xinmang.mvpdatabindingdemo.databinding.ActivityMainBinding;
import com.xinmang.mvpdatabindingdemo.factory.CreatePresenter;
import com.xinmang.mvpdatabindingdemo.mvp.presenter.MainPresenter;
import com.xinmang.mvpdatabindingdemo.mvp.view.MianView;

@CreatePresenter(MainPresenter.class)
public class MainActivity extends BaseActivity<MianView, MainPresenter,ActivityMainBinding> implements MianView {
    private TextView login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        login = (TextView) findViewById(R.id.login);
        getPresenter().Login();

    }

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
        login=mBindingView.login;

    }

    /**
     * 初始化数据
     */
    @Override
    protected void initData() {
        getPresenter().Login();
        setmTitle(getString(R.string.mainTitle));

    }

    /**
     * 初始化监听
     */
    @Override
    protected void initEventer() {

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
