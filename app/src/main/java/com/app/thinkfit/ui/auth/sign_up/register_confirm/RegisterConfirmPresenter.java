package com.app.thinkfit.ui.auth.sign_up.register_confirm;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/19
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class RegisterConfirmPresenter extends BasePresenter<RegisterConfirmMVPView> {

    @Inject
    public RegisterConfirmPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(RegisterConfirmMVPView mvpView) {
        super.initialView(mvpView);
    }
}
