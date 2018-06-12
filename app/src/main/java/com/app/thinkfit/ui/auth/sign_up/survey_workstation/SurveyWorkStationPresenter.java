package com.app.thinkfit.ui.auth.sign_up.survey_workstation;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SurveyWorkStationPresenter extends BasePresenter<SurveyWorkStationMVPView> {

    @Inject
    public SurveyWorkStationPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SurveyWorkStationMVPView mvpView) {
        super.initialView(mvpView);
    }
}
