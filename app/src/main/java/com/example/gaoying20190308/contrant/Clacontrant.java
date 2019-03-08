package com.example.gaoying20190308.contrant;

import com.example.gaoying20190308.model.ClaModel;

import java.util.HashMap;

public interface Clacontrant {
     abstract class Iclapersenter{
       public abstract void clalist(HashMap<String,String>params);
    }
    interface IclaModel{
        void clalist(HashMap<String,String>params, ClaModel.IclaModelCallBack callBack);
    }

    interface IclaView{
        void success(String result);
        void Failure(String msg);
    }
}
