package com.app.thinkfit.ui.auth.sign_up.register_password;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/19
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class RegisterPasswordPresenter extends BasePresenter<RegisterPasswordMVPView> {

    @Inject
    public RegisterPasswordPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(RegisterPasswordMVPView mvpView) {
        super.initialView(mvpView);
    }
}
