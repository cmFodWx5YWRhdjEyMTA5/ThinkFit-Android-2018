package com.app.thinkfit.ui.auth.forgot_password;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class ForgotPasswordPresenter extends BasePresenter<ForgotPasswordMVPView> {

    @Inject
    public ForgotPasswordPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(ForgotPasswordMVPView mvpView) {
        super.initialView(mvpView);
    }
}
