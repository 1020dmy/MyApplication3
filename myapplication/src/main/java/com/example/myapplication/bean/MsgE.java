package com.example.myapplication.bean;

public class MsgE {
    private int flag;
    private long progress;//新下载的数据的大小
    private long max;

    public MsgE(int flag, long progress, long max) {
        this.flag = flag;
        this.progress = progress;
        this.max = max;
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public long getProgress() {
        return progress;
    }

    public void setProgress(long progress) {
        this.progress = progress;
    }

    public long getMax() {
        return max;
    }

    public void setMax(long max) {
        this.max = max;
    }
}
