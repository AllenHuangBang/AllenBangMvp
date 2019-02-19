package com.example.allen.allenbasemvp.base.vi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.allen.allenbasemvp.base.presenter.BasePresenter;
import com.example.allen.allenbasemvp.base.vh.BaseViewHolder;
import com.example.allen.allenbasemvp.base.Contract;
import com.example.allen.allenbasemvp.utility.ProgressBar;

/**
 * Created by allen on 2018/12/16.
 */
public abstract class BaseFragment <V extends BaseViewImpl,P extends BasePresenter<V,M>,VH extends BaseViewHolder,M> extends Fragment implements BaseViewImpl{

    private V view;
    private P presenter;
    private M model;
    private VH viewholder;
    private Contract<V,P,VH,M> contract;
    private BaseActivity mActivity;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        this.mActivity = (BaseActivity)context;
        this.contract = createContract();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (viewholder == null) {
            this.viewholder = contract.getViewHolder();
        }
        View view = LayoutInflater.from(mActivity).inflate(this.viewholder.getLayoutId(),container,false);
        this.viewholder.initview(view);
        this.viewholder.initListener();
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if (presenter == null) {
            this.presenter = contract.getPresenter();
        }
        if (view == null) {
            this.view = contract.getView();
        }
        if(model==null){
            this.model = contract.getModel();
        }

        if (presenter != null && view != null && model!=null && viewholder !=null) {
            this.presenter.attachView(view,model);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        if (presenter != null && view != null) {
            this.presenter.detachView();
            this.contract = null;
        }
    }
    public abstract Contract<V,P,VH,M> createContract();

    public P getPresenter() {
        return this.presenter;
    }

    public VH getViewholder() {
        return this.viewholder;
    }

    @Override
    public void onLoading() {
        mActivity.onLoading();
    }

    @Override
    public void disLoading() {
        mActivity.disLoading();
    }
}
