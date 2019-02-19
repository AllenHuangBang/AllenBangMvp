package com.example.allen.allenbasemvp.presenter;


import com.example.allen.allenbasemvp.base.presenter.BasePresenter;
import com.example.allen.allenbasemvp.impl.LoginViewImpl;
import com.example.allen.allenbasemvp.model.LoginModel;

import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

/**
 * Created by allen on 2018/12/16.
 */
public class LoginPresenter extends BasePresenter<LoginViewImpl,LoginModel> {
    public LoginPresenter() {
    }

    public void login(){
        getModel().getLogin().subscribe(new Observer<String>() {
            @Override
            public void onSubscribe(Disposable d) {
                addDisposable(d);
            }

            @Override
            public void onNext(String s) {
                if(getView()!=null)getView().getLoginResult(s);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {

            }
        });
    }

    @Override
    public void viewCreated() {

    }
}
