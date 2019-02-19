package com.example.allen.allenbasemvp.vi;


import com.example.allen.allenbasemvp.base.vi.BaseActivity;
import com.example.allen.allenbasemvp.base.Contract;
import com.example.allen.allenbasemvp.impl.MainViewImpl;
import com.example.allen.allenbasemvp.model.MainModel;
import com.example.allen.allenbasemvp.presenter.MainPresenter;
import com.example.allen.allenbasemvp.vh.MainViewHolder;

public class MainActivity extends BaseActivity<MainViewImpl, MainPresenter,MainViewHolder, MainModel> implements MainViewImpl {

    @Override
    public Contract<MainViewImpl, MainPresenter,MainViewHolder, MainModel> createContract() {
        return new Contract<>(
                this
                , new MainPresenter()
                , new MainViewHolder()
                , new MainModel());
    }

    @Override
    public int getContentId() {
        return getViewholder().getContainerId();
    }

    @Override
    public void addFragment() {
        addFragment(new LoginFragment());
    }

    @Override
    public void setTitle(String title) {
        getViewholder().setToolbarTitle(title);
    }

    @Override
    public void initToolBar() {
        getViewholder().initToolBar(this);
    }
}
