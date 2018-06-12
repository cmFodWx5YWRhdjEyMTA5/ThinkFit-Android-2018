package com.app.thinkfit.ui.my_task.provide_improve;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/06/03
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class ProvideImprovePresenter extends BasePresenter<ProvideImproveMVPView> {

    @Inject
    public ProvideImprovePresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(ProvideImproveMVPView mvpView) {
        super.initialView(mvpView);
    }
}
