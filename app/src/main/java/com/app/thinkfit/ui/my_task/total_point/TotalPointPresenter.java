package com.app.thinkfit.ui.my_task.total_point;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/06/03
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class TotalPointPresenter extends BasePresenter<TotalPointMVPView> {

    @Inject
    public TotalPointPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(TotalPointMVPView mvpView) {
        super.initialView(mvpView);
    }
}
