package com.example.allen.allenbasemvp.base.presenter;


import com.example.allen.allenbasemvp.base.vi.BaseViewImpl;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by allen on 2018/12/16.
 */
public abstract class BasePresenter<V extends BaseViewImpl,M> implements BasePresenterImp<V,M> {
    private V view;
    private M model;
    private CompositeDisposable compositeDisposable;
    public V getView(){
        return view;
    }
    protected M getModel(){
        return model;
    }
    public void addDisposable(Disposable disposable){
        this.compositeDisposable.add(disposable);
    }

    @Override
    public void attachView(V view,M model) {
        this.view = view;
        this.model = model;
        this.compositeDisposable = new CompositeDisposable();
    }

    @Override
    public void detachView() {
        this.compositeDisposable.clear();
        this.compositeDisposable = null;
        this.view = null;
        this.model = null;
    }

    public abstract void viewCreated();
}
