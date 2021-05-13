package com.xinmang.mvpdatabindingdemo.base.baseadapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.ArrayList;
import java.util.List;



public abstract class BaseRecyclerViewAdapter<T> extends RecyclerView.Adapter<BaseRecyclerViewHolder> {
    protected List<T> mData=new ArrayList<T>();
    protected OnItemClickLisrener<T> onItemClickLisrener;
    protected OnItemLongClickListener<T> onItemLongClickListener;

    @Override
    public void onBindViewHolder(BaseRecyclerViewHolder holder, int position) {
        holder.onBindViewHolder(mData.get(position),position);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(onItemClickLisrener!=null){
                    onItemClickLisrener.onClick(mData.get(position),position);
                }
            }
        });

        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                if(onItemLongClickListener!=null){
                    onItemLongClickListener.onLongClick(mData.get(position),position);
                }
                return true;
            }
        });
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public void addAll(List<T> data){
        if(this.mData!=null){
            mData.addAll(data);
            notifyDataSetChanged();
        }
    }

    public void add(T object) {
        mData.add(object);
        notifyDataSetChanged();
    }

    public void addData(List<T> mDatas) {
        this.mData.addAll(mDatas);
        notifyDataSetChanged();
    }

    public void clear() {
        mData.clear();
    }

    public void remove(T object) {
        mData.remove(object);
    }
    public void remove(int position) {
        mData.remove(position);
    }
    public void removeAll(List<T> data) {
        this.mData.retainAll(data);
    }

    public void setOnItemClickListener(OnItemClickLisrener<T> listener) {
        this.onItemClickLisrener = listener;
    }


    public List<T> getData() {
        return mData;
    }

    public void setOnItemLongClickListener(OnItemLongClickListener<T> onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public int getSize(){
        return this.mData.size();
    }


}
