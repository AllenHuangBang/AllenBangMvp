package com.example.allen.allenbasemvp.vh;

import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.allen.allenbasemvp.MainApplication;
import com.example.allen.allenbasemvp.R;
import com.example.allen.allenbasemvp.base.vh.BaseViewHolder;

/**
 * Created by allen on 2018/12/26.
 */
public class MainViewHolder extends BaseViewHolder {
    private Toolbar mToolbar;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    public MainViewHolder() {
    }

    @Override
    public void initview(View view) {
        mToolbar = view.findViewById(R.id.toolbar);
        mDrawerLayout = view.findViewById(R.id.draw_layout);
    }

    @Override
    public void initListener() {

    }

    @Override
    public int getLayoutId() {
        return R.layout.activity_main;
    }

    public int getContainerId(){
        return R.id.container;
    }

    public void initToolBar(AppCompatActivity activity){
        setToolbarTitle(MainApplication.getContext().getResources().getString(R.string.toolbar_title_00));
        mToolbar.setTitleTextColor(MainApplication.getContext().getResources().getColor(R.color.blue_00));
        activity.setSupportActionBar(mToolbar);
        activity.getSupportActionBar().setHomeButtonEnabled(true);
        activity.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        mDrawerToggle = new ActionBarDrawerToggle(activity,mDrawerLayout,mToolbar,R.string.drawerlayout_open,R.string.drawerlayout_close){

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }
        };
        mDrawerToggle.syncState();
        mDrawerLayout.addDrawerListener(mDrawerToggle);
    }

    public void setToolbarTitle(String title){
        mToolbar.setTitle(title);
    }
}
