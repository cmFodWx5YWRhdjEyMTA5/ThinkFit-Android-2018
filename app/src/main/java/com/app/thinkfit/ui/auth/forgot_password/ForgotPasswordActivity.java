package com.app.thinkfit.ui.auth.forgot_password;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ForgotPasswordActivity extends BaseMVPDialogActivity implements ForgotPasswordMVPView {

    @Inject
    ForgotPasswordPresenter presenter;

    @BindView(R.id.tv_request_password)
    TextView tvRequestPassword;

    @BindView(R.id.tv_message_confirm)
    TextView tvMessageConfirm;

    @BindView(R.id.img_back)
    ImageView imgBack;

    private boolean mIsContinue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        imgBack.setVisibility(View.VISIBLE);
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_forgot_password;
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

    @OnClick(R.id.img_back)
    public void onClickBack() {
        onBackPressed();
    }

    @OnClick(R.id.tv_request_password)
    public void onClickRequestPassword() {
        if (!mIsContinue) {
            mIsContinue = true;
            tvMessageConfirm.setVisibility(View.VISIBLE);
            tvRequestPassword.setText(getString(R.string.label_continue));
        } else {
            finish();
        }
    }
}