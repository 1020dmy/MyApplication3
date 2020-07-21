package com.example.myapplication.base;

import android.os.Bundle;

import com.example.myapplication.R;

import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseAtivity<P extends BasePersenter> extends AppCompatActivity implements BaseView {
    public P mPersenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayout());
        initpersenter();
        if (mPersenter != null){
            mPersenter.bindview(this);
        }
        initView();
        initData();
        initListener();
    }

    protected abstract void initListener();

    protected abstract void initView();

    protected abstract void initData();

    protected abstract void initpersenter();

    protected abstract int getLayout();

}
