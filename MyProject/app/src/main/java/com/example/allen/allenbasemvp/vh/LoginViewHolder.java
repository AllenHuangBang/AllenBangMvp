package com.example.allen.allenbasemvp.vh;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.allen.allenbasemvp.R;
import com.example.allen.allenbasemvp.base.vh.BaseViewHolder;
import com.example.allen.allenbasemvp.impl.LoginViewImpl;

/**
 * Created by allen on 2018/12/25.
 */
public class LoginViewHolder extends BaseViewHolder implements View.OnClickListener {
    private Button bt_login;
    private TextView tv_login_result;
    private LoginViewImpl loginView;

    public LoginViewHolder(LoginViewImpl loginView) {
        this.loginView = loginView;
    }


    @Override
    public void initview(View view) {
        bt_login = view.findViewById(R.id.bt_login);
        tv_login_result = view.findViewById(R.id.tv_login_result);
    }

    @Override
    public void initListener() {
        bt_login.setOnClickListener(this);
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_login;
    }

    public void setTv_login_result(String textStr){
        tv_login_result.setText(textStr);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                Log.v("12323","2132321");
                setTv_login_result("");
                loginView.getLogin();
                break;
            case R.id.tv_login_result:
                break;

        }
    }
}
