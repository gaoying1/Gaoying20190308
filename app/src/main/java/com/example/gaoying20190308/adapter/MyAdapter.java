package com.example.gaoying20190308.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.gaoying20190308.R;
import com.example.gaoying20190308.bean.UserBean;

import java.util.ArrayList;
import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Myvh> {
    private Context context;
    private List<UserBean.DataEntity>lists;

    public MyAdapter(Context context) {
        this.context = context;
        lists=new ArrayList<>();
    }

    public void setLists(List<UserBean.DataEntity> lists) {
        this.lists = lists;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public MyAdapter.Myvh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.item2,parent,false);
        return new Myvh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.Myvh holder, int position) {
            holder.title.setText(lists.get(position).getSellerName());
            holder.checkboxs.setChecked(lists.get(position).ischeck);
            Glide.with(context).load("http://172.17.8.100/images/small/commodity/xbsd/sjb/5/1.jpg").into(holder.image);
    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    public class Myvh extends RecyclerView.ViewHolder {

        private final TextView title;
        private final CheckBox checkboxs;
        private final ImageView image;

        public Myvh(View itemView) {
            super(itemView);
            checkboxs=itemView.findViewById(R.id.checkboxs);
            title=itemView.findViewById(R.id.title);
            image= itemView.findViewById(R.id.image);
        }
    }
}
