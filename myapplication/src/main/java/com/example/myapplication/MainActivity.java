package com.example.myapplication;

import android.os.Bundle;
import android.widget.Adapter;
import android.widget.Toast;

import com.example.myapplication.adapter.Adapee;
import com.example.myapplication.adapter.MyAdapter;
import com.example.myapplication.base.BaseAtivity;
import com.example.myapplication.bean.JavaBean;
import com.example.myapplication.fragment.BlankFragment;
import com.example.myapplication.fragment.BlankFragment2;
import com.example.myapplication.persenter.MainPersenter;
import com.example.myapplication.view.Mainview;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;


public class MainActivity extends BaseAtivity<MainPersenter> implements Mainview {

    private ArrayList<Fragment> list;
    private MyAdapter myAdapter;
    private ViewPager vp;
    private TabLayout tb;
    private ArrayList<JavaBean.DataBean.DatasBean> mlist;

//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        initView();
//    }

    @Override
    protected void initListener() {

    }

    @Override
    protected void initView() {
        vp = (ViewPager) findViewById(R.id.vp);
        tb = (TabLayout) findViewById(R.id.tb);
        list = new ArrayList<>();
        BlankFragment blankFragment = new BlankFragment();
        BlankFragment2 blankFragment2 = new BlankFragment2();
        list.add(blankFragment);
        list.add(blankFragment2);
        myAdapter = new MyAdapter(getSupportFragmentManager(), 1, list);
        vp.setAdapter(myAdapter);
        tb.setupWithViewPager(vp);
        tb.getTabAt(0).setText("首页").setIcon(R.drawable.select);
        tb.getTabAt(1).setText("我的").setIcon(R.drawable.select);
        mlist = new ArrayList<>();
    }

    @Override
    protected void initData() {
        mPersenter.setData();
    }

    @Override
    protected void initpersenter() {
        mPersenter = new MainPersenter();
    }

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    public void setData(JavaBean data) {

    }

    @Override
    public void showToast(String string) {
        Toast.makeText(this, string, Toast.LENGTH_SHORT).show();
    }

}
