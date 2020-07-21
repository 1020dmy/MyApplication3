package com.example.myapplication.net;

import com.example.myapplication.bean.JavaBean;

import io.reactivex.Observable;
import okhttp3.ResponseBody;
import retrofit2.http.GET;

public interface ApiService {

    String BASE_URL="https://www.wanandroid.com/project/";

    @GET("list/1/json?cid=294")
    Observable<JavaBean> getjava();

    String B="http://cdn.banmi.com/banmiapp/apk/";
    @GET("banmi_330.apk")
    Observable<ResponseBody> getxiazai();

}
