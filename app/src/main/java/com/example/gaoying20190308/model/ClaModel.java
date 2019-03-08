package com.example.gaoying20190308.model;

import com.example.gaoying20190308.Api;
import com.example.gaoying20190308.contrant.Clacontrant;
import com.example.gaoying20190308.net.OkHttpCallBack;
import com.example.gaoying20190308.net.OkHttpUtils;

import java.util.HashMap;

public class ClaModel implements Clacontrant.IclaModel {
    @Override
    public void clalist(HashMap<String, String> params, final IclaModelCallBack callBack) {
        OkHttpUtils.getmIntstance().doGet(Api.ss, new OkHttpCallBack() {
            @Override
            public void success(String result) {
                callBack.success(result);
            }

            @Override
            public void Failure(String msg) {
                callBack.Failure(msg);
            }
        });
    }

    public interface IclaModelCallBack{
        void success(String result);
        void Failure(String msg);
    }
}
