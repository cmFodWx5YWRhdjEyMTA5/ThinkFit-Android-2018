package com.app.thinkfit.ui.my_task.time_over;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class TimeOverPresenter extends BasePresenter<TimeOverMVPView> {

    @Inject
    public TimeOverPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(TimeOverMVPView mvpView) {
        super.initialView(mvpView);
    }
}
