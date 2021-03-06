package com.example.myapplication.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.myapplication.R;
import com.example.myapplication.bean.JavaBean;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Adapeer extends RecyclerView.Adapter {
    private ArrayList<JavaBean.DataBean.DatasBean> mlist;
    private Context mcontext;

    public Adapeer(ArrayList<JavaBean.DataBean.DatasBean> mlist, Context mcontext) {
        this.mlist = mlist;
        this.mcontext = mcontext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = View.inflate(mcontext, R.layout.item, null);

        return new ViewHolder(inflate);
    }
    public interface On {
        void Click(int position);
    }
    public On on;

    public void setOn(On on) {
        this.on = on;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        ViewHolder holder1 = (ViewHolder) holder;
        JavaBean.DataBean.DatasBean datasBean = mlist.get(position);
        Glide.with(mcontext).load(datasBean.getEnvelopePic()).into(holder1.image);
        holder1.tv.setText(datasBean.getTitle());
        holder1.rootView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                on.Click(position);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public static
    class ViewHolder extends RecyclerView.ViewHolder {
        public View rootView;
        public ImageView image;
        public TextView tv;

        public ViewHolder(View rootView) {
            super(rootView);
            this.rootView = rootView;
            this.image = (ImageView) rootView.findViewById(R.id.image);
            this.tv = (TextView) rootView.findViewById(R.id.tv);
        }

    }
}
