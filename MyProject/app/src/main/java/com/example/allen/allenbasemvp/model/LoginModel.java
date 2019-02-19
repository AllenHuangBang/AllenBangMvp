package com.example.allen.allenbasemvp.model;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by allen on 2018/12/16.
 */
public class LoginModel {
    public Observable<String> getLogin(){
        return Observable.create((ObservableOnSubscribe<String>) emitter -> {
            emitter.onNext("Success");
            emitter.onComplete();
        }).subscribeOn(Schedulers.io()).delay(3000,TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread());
    }
}
