package com.xinmang.mvpdatabindingdemo.net;

import com.xinmang.mvpdatabindingdemo.api.ServiceApi;



public class ApiFactory {
    protected static  final  Object monitor=new Object();
    static ServiceApi serviceApi=null;

    public static ServiceApi getServiceApi(){
        synchronized (monitor){
            if(serviceApi==null){
                serviceApi=new ApiRetrofit().getZhihuApiService();
            }
            return serviceApi;
        }
    }
}
