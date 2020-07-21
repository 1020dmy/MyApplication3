package com.example.myapplication;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import com.example.myapplication.bean.MsgE;
import com.example.myapplication.net.ApiService;

import org.greenrobot.eventbus.EventBus;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MyService extends Service {
    public MyService() {
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        final String file=("/storage/emulated/0/ab.apk");
        Retrofit build = new Retrofit.Builder()
                .baseUrl(ApiService.B)
                .build();
        ApiService apiService = build.create(ApiService.class);
        Observable<ResponseBody> getxiazai = apiService.getxiazai();
        getxiazai.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ResponseBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ResponseBody responseBody) {
                        InputStream inputStream = responseBody.byteStream();
                        long max = responseBody.contentLength();
                        saveFile(file,inputStream,max);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });


        return super.onStartCommand(intent, flags, startId);
    }
    public   void saveFile(String savaFile, InputStream is, long max) {
        EventBus.getDefault().post(new MsgE(1,0,max));//1表示成功，把进度最大值设置到进度条中
        int len = 0;
        byte[] buff = new byte[4096];//每次读取4k
        int count = 0;//记录当前读取的进度
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(savaFile);
            while ((len = is.read(buff)) != -1){
                fos.write(buff,0,len);//把读取的数据，写入本地文件中，作为保存
                count = count+len;//累加读取的数据
                //2表示更新进度条的进度
                EventBus.getDefault().post(new MsgE(2,len,max));
                Log.i("111", "savaFile: max->"+max+",count->"+count);
            }
            //3表示下载完成，Toast提示
            EventBus.getDefault().post(new MsgE(3,count,max));
        } catch (Exception e) {
            e.printStackTrace();
        }finally {

            try {
                //读取写入完数据后，关闭流
                if(is != null)
                is.close();
                if(fos != null)
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }
}
