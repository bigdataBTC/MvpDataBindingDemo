package com.xinmang.mvpdatabindingdemo.adapter;

import android.view.ViewGroup;

import com.xinmang.mvpdatabindingdemo.R;
import com.xinmang.mvpdatabindingdemo.base.baseadapter.BaseRecyclerViewAdapter;
import com.xinmang.mvpdatabindingdemo.base.baseadapter.BaseRecyclerViewHolder;
import com.xinmang.mvpdatabindingdemo.bean.TextBean;
import com.xinmang.mvpdatabindingdemo.databinding.ItemMainBinding;


public class MaintextAdapter extends BaseRecyclerViewAdapter<TextBean.DataBean> {

    @Override
    public BaseRecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(parent, R.layout.item_main);
    }

    private class ViewHolder extends BaseRecyclerViewHolder<TextBean.DataBean,ItemMainBinding>{

        ViewHolder(ViewGroup parent, int layout) {
            super(parent, layout);
        }
        /**
         * @param object  绑定的数据
         * @param postion RecyclerView的postion
         */
        @Override
        public void onBindViewHolder(TextBean.DataBean object, int postion) {
            mBinding.setTextBean(object);
            mBinding.executePendingBindings();

        }
    }
}
