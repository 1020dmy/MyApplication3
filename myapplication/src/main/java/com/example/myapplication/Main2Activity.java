package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.bean.MsgE;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    private ProgressBar mPb;
    private TextView tv;
    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        EventBus.getDefault().register(this);
        initView();
    }

    private void initView() {
        mPb = (ProgressBar) findViewById(R.id.pb);
        tv = (TextView) findViewById(R.id.tv);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyService myService = new MyService();
                Intent intent = new Intent(Main2Activity.this, MyService.class);
                startService(intent);
            }
        });

    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void changemPb(MsgE msgE) {

        switch (msgE.getFlag()) {
            case 1:
                mPb.setMax((int) msgE.getMax());
                break;
            case 2:
                //把新的进度追加到旧的进度上，算出当前最新的进度
                long allPro = mPb.getProgress() + msgE.getProgress();
                mPb.setProgress((int) allPro);

                break;
            case 3:
                Toast.makeText(this, "下载完成", Toast.LENGTH_SHORT).show();
                break;
        }

    }
}