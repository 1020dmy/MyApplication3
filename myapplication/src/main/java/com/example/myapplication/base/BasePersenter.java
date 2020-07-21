package com.example.myapplication.base;

import java.util.ArrayList;

public abstract class BasePersenter<V extends BaseView> {
    public V mview;


    public ArrayList<BaseModel> mModel = new ArrayList<>();

    public BasePersenter(){
        ininMModel();
    }

    protected abstract void ininMModel();

    public void bindview(V view){
        mview = view;
    }

    public void addModel(BaseModel baseModel){
        mModel.add(baseModel);
    }
    public  void destroy(){
        mview = null;
        for (int i = 0; i < mModel.size(); i++) {

            BaseModel baseModel = mModel.get(i);
            baseModel.Disposable();

        }
    }
}
