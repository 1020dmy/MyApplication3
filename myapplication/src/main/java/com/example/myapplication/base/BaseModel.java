package com.example.myapplication.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

public abstract class BaseModel {
    public CompositeDisposable mdisposable = null;
     public void addDisposable(Disposable disposable){
         if (mdisposable == null){
             synchronized (this){
                 mdisposable = new CompositeDisposable();
             }
         }
         mdisposable.add(disposable);
     }
     public void removeDisposable(Disposable disposable){
         mdisposable.remove(disposable);
     }
     public void Disposable(){
         mdisposable.dispose();
     }
}
