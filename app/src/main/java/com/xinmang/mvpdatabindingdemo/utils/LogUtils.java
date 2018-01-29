package com.xinmang.mvpdatabindingdemo.utils;

import android.util.Log;

import com.xinmang.mvpdatabindingdemo.BuildConfig;

/**
 * Created by huwei on 2018/1/27.
 */

public class LogUtils {
    public static final String TAG=LogUtils.class.getName();
    public static final boolean isDebug = BuildConfig.DEBUG;

    /**
     * 打印一个debug等级的 log
     */
    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(TAG + tag, msg+"");
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(String tag, String msg) {
        if (isDebug) {
            Log.e(TAG + tag, msg+"");
        }
    }

    /**
     * 打印一个debug等级的 log
     */
    public static void e(Class cls, String msg) {
        if (isDebug) {
            Log.e(TAG + cls.getSimpleName(), msg+"");
        }
    }

}
