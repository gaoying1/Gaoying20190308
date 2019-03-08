package com.example.gaoying20190308;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.gaoying20190308.adapter.MyAdapter;
import com.example.gaoying20190308.bean.UserBean;
import com.example.gaoying20190308.contrant.Clacontrant;
import com.example.gaoying20190308.persenter.Clapersenter;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Main2Activity extends AppCompatActivity implements Clacontrant.IclaView {

    private RecyclerView recx;
    private MyAdapter adapter;
    private Clapersenter clapersenter;
    private CheckBox check;
    private List<UserBean.DataEntity>lists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        recx=findViewById(R.id.recx);
        check= findViewById(R.id.check);
        lists=new ArrayList<>();
        check.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked){
                    for (UserBean.DataEntity bean:lists){
                        bean.ischeck=true;
                        adapter.notifyDataSetChanged();
                    }
                }else{
                    for (UserBean.DataEntity bean:lists){
                        bean.ischeck=false;
                        adapter.notifyDataSetChanged();
                    }
                }
            }
        });


        recx.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this);
        clapersenter = new Clapersenter(this);
        HashMap<String,String>map=new HashMap<>();
        clapersenter.clalist(map);
    }

    @Override
    public void success(String result) {
        UserBean userBean = new Gson().fromJson(result, UserBean.class);
        adapter.setLists(userBean.getData());
        recx.setAdapter(adapter);
        lists=userBean.getData();



    }

    @Override
    public void Failure(String msg) {

    }
}
