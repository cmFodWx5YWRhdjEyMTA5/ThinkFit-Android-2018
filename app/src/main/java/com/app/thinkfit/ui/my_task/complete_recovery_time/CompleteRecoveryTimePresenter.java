package com.app.thinkfit.ui.my_task.complete_recovery_time;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class CompleteRecoveryTimePresenter extends BasePresenter<CompleteRecoveryTimeMVPView> {

    @Inject
    public CompleteRecoveryTimePresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(CompleteRecoveryTimeMVPView mvpView) {
        super.initialView(mvpView);
    }
}
