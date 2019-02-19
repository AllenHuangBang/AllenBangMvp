package com.example.allen.allenbasemvp.base.vi;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;

import com.example.allen.allenbasemvp.base.presenter.BasePresenter;
import com.example.allen.allenbasemvp.base.vh.BaseViewHolder;
import com.example.allen.allenbasemvp.base.Contract;
import com.example.allen.allenbasemvp.utility.ProgressBar;

/**
 * Created by allen on 2018/12/16.
 */
public abstract class BaseActivity<V extends BaseViewImpl, P extends BasePresenter<V,M>, VH extends BaseViewHolder,M> extends AppCompatActivity implements BaseViewImpl{

    private V view;
    private P presenter;
    private VH viewholder;
    private M model;
    private Contract<V,P,VH,M> contract;
    private ProgressBar progressBar;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        progressBar = ProgressBar.getInstance();
        this.contract = createContract();

        if (viewholder == null) {
            this.viewholder = contract.getViewHolder();
        }
        setContentView(this.viewholder.getLayoutId());

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
        this.viewholder.initview(this.getWindow().getDecorView());
        this.presenter.viewCreated();
    }

    protected void addFragment(BaseFragment mFragment){
        if(mFragment!=null){
            getSupportFragmentManager().beginTransaction().replace(getContentId(),mFragment,mFragment.getClass().getSimpleName()).addToBackStack(mFragment.getClass().getSimpleName()).commitAllowingStateLoss();
        }
    }
    protected void removeFragment(){
        if(getSupportFragmentManager().getBackStackEntryCount()>1){
            getSupportFragmentManager().popBackStack();
        }else {
            finish();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (KeyEvent.KEYCODE_BACK == keyCode) {
            Log.v("count",getSupportFragmentManager().getBackStackEntryCount()+"");
            if (getSupportFragmentManager().getBackStackEntryCount() == 1) {
                finish();
                return true;
            }
        }
        return super.onKeyDown(keyCode, event);    }
        
    @Override
    protected void onDestroy() {
        super.onDestroy();
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


    public abstract int getContentId();

    @Override
    public void onLoading() {
        progressBar.createDialog(this).show();
    }

    @Override
    public void disLoading() {
        progressBar.dismiss();
    }
}
