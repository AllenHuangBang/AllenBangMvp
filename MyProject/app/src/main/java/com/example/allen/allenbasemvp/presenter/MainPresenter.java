package com.example.allen.allenbasemvp.presenter;

import com.example.allen.allenbasemvp.base.presenter.BasePresenter;
import com.example.allen.allenbasemvp.impl.MainViewImpl;
import com.example.allen.allenbasemvp.model.MainModel;

/**
 * Created by allen on 2018/12/26.
 */
public class MainPresenter extends BasePresenter<MainViewImpl,MainModel> {

    public MainPresenter() {
    }

    @Override
    public void attachView(MainViewImpl view, MainModel model) {
        super.attachView(view, model);
        getView().addFragment();
    }

    @Override
    public void viewCreated() {
        getView().initToolBar();
    }
}
