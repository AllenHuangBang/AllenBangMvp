package com.example.allen.allenbasemvp.base.vh;

import android.support.v7.app.AppCompatDelegate;
import android.view.View;

/**
 * Created by allen on 2018/12/25.
 */
public abstract class BaseViewHolder {
    public abstract void initview(View view);
    public abstract void initListener();
    public abstract int getLayoutId();
}
