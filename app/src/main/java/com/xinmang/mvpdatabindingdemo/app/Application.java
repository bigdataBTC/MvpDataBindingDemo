package com.xinmang.mvpdatabindingdemo.app;

/**
 * Created by lipei on 2018/1/29.
 */

public class Application extends android.app.Application {
    private static Application application;

    public static Application getInstance(){
        return application;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        application=this;
    }
}
