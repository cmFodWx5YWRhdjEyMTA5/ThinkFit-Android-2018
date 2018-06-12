package com.app.thinkfit.ui.my_task.stop_recovery_time;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class StopRecoveryTimePresenter extends BasePresenter<StopRecoveryTimeMVPView> {

    @Inject
    public StopRecoveryTimePresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(StopRecoveryTimeMVPView mvpView) {
        super.initialView(mvpView);
    }
}
