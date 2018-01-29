package com.xinmang.mvpdatabindingdemo.utils;

import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.xinmang.mvpdatabindingdemo.R;

/**
 * Created by lipei on 2018/1/29.
 */

public class picUtils {
    // 下载一个图片 设置到ImageView
    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url){
        if (url == null){
            view.setImageResource(R.mipmap.ic_launcher);
        } else {
            // Glide代替Volley
            Glide.with(view.getContext()).load(url).placeholder(R.mipmap.ic_launcher).into(view);
        }
    }
}
