package com.app.thinkfit.ui.auth.sign_in;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.os.Bundle;
import android.view.View;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.auth.forgot_password.ForgotPasswordActivity;
import com.app.thinkfit.ui.auth.sign_up.SignUpActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;
import com.app.thinkfit.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignInActivity extends BaseMVPDialogActivity implements SignInMVPView {

    @Inject
    SignInPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_sign_in;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
        super.onDestroy();
    }

    @Override
    public void showNoNetworkAlert() {
        showAlert(getString(R.string.error_not_connect_to_internet));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(this, code);
    }

    @OnClick({R.id.tv_sign_up, R.id.tv_forgot_password, R.id.tv_sign_in})
    public void onClickView(View view) {
        switch (view.getId()) {
            case R.id.tv_sign_up:
                GlobalFuntion.startActivity(this, SignUpActivity.class);
                break;

            case R.id.tv_forgot_password:
                GlobalFuntion.startActivity(this, ForgotPasswordActivity.class);
                break;

            case R.id.tv_sign_in:
                GlobalFuntion.startActivity(this, MainActivity.class);
                break;
        }
    }
}
