package com.app.thinkfit.ui.auth.sign_up.detail_selected;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class DetailSelectedPresenter extends BasePresenter<DetailSelectedMVPView> {

    @Inject
    public DetailSelectedPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(DetailSelectedMVPView mvpView) {
        super.initialView(mvpView);
    }
}
