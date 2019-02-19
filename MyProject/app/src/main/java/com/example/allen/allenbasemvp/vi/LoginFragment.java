package com.example.allen.allenbasemvp.vi;

import android.view.View;

import com.example.allen.allenbasemvp.base.vi.BaseFragment;
import com.example.allen.allenbasemvp.base.Contract;
import com.example.allen.allenbasemvp.impl.LoginViewImpl;
import com.example.allen.allenbasemvp.model.LoginModel;
import com.example.allen.allenbasemvp.presenter.LoginPresenter;
import com.example.allen.allenbasemvp.vh.LoginViewHolder;

/**
 * Created by allen on 2018/12/26.
 */
public class LoginFragment extends BaseFragment<LoginViewImpl,LoginPresenter,LoginViewHolder,LoginModel> implements LoginViewImpl {
    @Override
    public Contract<LoginViewImpl, LoginPresenter, LoginViewHolder, LoginModel> createContract() {
        return new Contract<>(
                this,
                new LoginPresenter(),
                new LoginViewHolder(this),
                new LoginModel()
        );
    }

    @Override
    public void getLoginResult(String s) {
        disLoading();
        getViewholder().setTv_login_result(s);
    }

    @Override
    public void getLogin() {
        onLoading();
        getPresenter().login();
    }
}
