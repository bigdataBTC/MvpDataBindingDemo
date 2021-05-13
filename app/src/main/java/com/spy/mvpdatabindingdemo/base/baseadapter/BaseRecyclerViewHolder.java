package com.xinmang.mvpdatabindingdemo.base.baseadapter;

import android.database.DatabaseUtils;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



public abstract class BaseRecyclerViewHolder<T,D extends ViewDataBinding> extends RecyclerView.ViewHolder{
    public D mBinding;
    public BaseRecyclerViewHolder(ViewGroup viewGroup,int layoutId) {
        //注意要依赖viewGroup,不然显示item不全
        super(DataBindingUtil.inflate(LayoutInflater.from(viewGroup.getContext()),layoutId,viewGroup,false).getRoot());
        mBinding=DataBindingUtil.getBinding(this.itemView);
    }

    /**
     *
     * @param object 绑定的数据
     * @param postion RecyclerView的postion
     */
    public abstract void onBindViewHolder(T object,int postion);

    /**
     * 当数据改变时，binding会在下一帧去改变数据，如果我们需要立即改变，就去调用executePendingBindings方法。
     */
    public void onBaseBindViewHolder(T object,int postion){
        onBindViewHolder(object,postion);
        mBinding.executePendingBindings();
    }
}
