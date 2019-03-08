package com.example.gaoying20190308.persenter;

import com.example.gaoying20190308.contrant.Clacontrant;
import com.example.gaoying20190308.model.ClaModel;

import java.util.HashMap;

public class Clapersenter extends Clacontrant.Iclapersenter {
    private Clacontrant.IclaView iclaView;
    private ClaModel claModel;

    public Clapersenter(Clacontrant.IclaView iclaView) {
        this.iclaView = iclaView;
        claModel= new ClaModel();

    }


    @Override
    public void clalist(HashMap<String, String> params) {
        claModel.clalist(params, new ClaModel.IclaModelCallBack() {
            @Override
            public void success(String result) {
                iclaView.success(result);
            }

            @Override
            public void Failure(String msg) {
                iclaView.Failure(msg);
            }
        });
    }
}
