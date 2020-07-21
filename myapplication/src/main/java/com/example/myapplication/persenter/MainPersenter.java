package com.example.myapplication.persenter;

import com.example.myapplication.base.BasePersenter;
import com.example.myapplication.bean.JavaBean;
import com.example.myapplication.model.MainModel;
import com.example.myapplication.net.MainCallBack;
import com.example.myapplication.view.Mainview;

public class MainPersenter extends BasePersenter<Mainview> implements MainCallBack{

    private MainModel mainModel;

    @Override
    protected void ininMModel() {
        mainModel = new MainModel();
        addModel(mainModel);

    }

    public void setData() {

        mainModel.setData(this);

    }

    @Override
    public void OnSuccess(JavaBean javaBean) {
        mview.setData(javaBean);
    }

    @Override
    public void OnFeil(String string) {

    }
}
