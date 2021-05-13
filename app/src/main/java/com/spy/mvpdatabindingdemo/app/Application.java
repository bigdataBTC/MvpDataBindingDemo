package com.xinmang.mvpdatabindingdemo.app;



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
