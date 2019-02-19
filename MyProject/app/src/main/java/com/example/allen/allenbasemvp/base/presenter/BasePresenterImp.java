package com.example.allen.allenbasemvp.base.presenter;

import android.support.annotation.UiThread;

import com.example.allen.allenbasemvp.base.vi.BaseViewImpl;

/**
 * Created by allen on 2018/12/17.
 */
public interface BasePresenterImp<V extends BaseViewImpl,M> {
    @UiThread
    void attachView(V view,M model);

    @UiThread
    void detachView();
}
