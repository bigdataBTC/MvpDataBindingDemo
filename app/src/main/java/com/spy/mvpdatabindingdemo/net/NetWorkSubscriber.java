package com.xinmang.mvpdatabindingdemo.net;

import android.app.Dialog;
import android.text.TextUtils;

import com.xinmang.mvpdatabindingdemo.app.Application;
import com.xinmang.mvpdatabindingdemo.handler.DialogHandler;
import com.xinmang.mvpdatabindingdemo.interfaces.DialogCancelListener;
import com.xinmang.mvpdatabindingdemo.utils.LogUtils;
import com.xinmang.mvpdatabindingdemo.utils.StateUtils;

import java.net.ConnectException;
import java.net.SocketTimeoutException;

import rx.Subscriber;



public class NetWorkSubscriber<T> extends Subscriber<T>  implements DialogCancelListener{
    private boolean isShowDialog;
    private DialogHandler dialogHandler;
    private static final String TAG=NetWorkSubscriber.class.getName();

    /**
     * 需要加载框的构造方法
     * @param dialog
     */
    public NetWorkSubscriber(Dialog dialog,boolean isShowDialog){
        this.isShowDialog=isShowDialog;
        dialogHandler=new DialogHandler(dialog,this);

    }

    /**
     * 不需要加载框的构造方法
     */
    public NetWorkSubscriber(){

    }

    @Override
    public void onStart() {
        LogUtils.e(TAG,"onStart");
        if(!StateUtils.isNetworkAvailable(Application.getInstance())){
            //没有网络
            if(!isUnsubscribed()){
                unsubscribe();
            }
            LogUtils.e(TAG,"没有网络，可根据实际情况来做");
        }else{
            if(isShowDialog){
                showProgressDialog();
            }
        }

    }


    @Override
    public void onCompleted() {
        LogUtils.e(TAG,"onCompleted");

    }


    @Override
    public void onError(Throwable e) {
        LogUtils.e(TAG,"onError");
        dismissProgressDialog();
        String msg;
        if (e instanceof SocketTimeoutException) {
            msg = "请求超时。请稍后重试！";
        } else if (e instanceof ConnectException) {
            msg = "请求超时。请稍后重试！";
        } else {
            msg = "请求未能成功，请稍后重试！";
        }
        if (!TextUtils.isEmpty(msg)) {
//            onFailure(msg);
        }

    }


    @Override
    public void onNext(T t) {
        LogUtils.e(TAG,"onNext");
    }

    /**
     * 取消网络请求
     */
    @Override
    public void onCancel() {
        LogUtils.e(TAG,"onCancel");
        /**
         * 如果订阅者和被订阅者 没有取消订阅 则取消订阅 以取消网络请求
         */
        if (!this.isUnsubscribed()) {
            this.unsubscribe();
        }

    }

    /**
     * 显示对话框 发送一个显示对话框的消息给dialoghandler  由他自己处理（也就是dialog中hanldermesage处理该消息）
     */
    private void showProgressDialog() {
        if (dialogHandler != null) {
            dialogHandler.obtainMessage(DialogHandler.SHOW_PROGRESS_DIALOG).sendToTarget();
        }
    }

    /**
     * 隐藏对话框 ....
     */
    private void dismissProgressDialog() {
        if (dialogHandler != null) {
            dialogHandler.obtainMessage(DialogHandler.DISMISS_PROGRESS_DIALOG).sendToTarget();
            dialogHandler = null;
        }
    }
}
