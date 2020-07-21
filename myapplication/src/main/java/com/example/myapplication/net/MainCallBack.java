package com.example.myapplication.net;

import com.example.myapplication.bean.JavaBean;

public interface MainCallBack {
    void OnSuccess(JavaBean javaBean);
    void OnFeil(String string);
}
