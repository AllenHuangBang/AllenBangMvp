package com.example.allen.allenbasemvp.impl;

import com.example.allen.allenbasemvp.base.vi.BaseViewImpl;

/**
 * Created by allen on 2018/12/26.
 */
public interface MainViewImpl extends BaseViewImpl {
    void addFragment();
    void setTitle(String title);
    void initToolBar();
}
