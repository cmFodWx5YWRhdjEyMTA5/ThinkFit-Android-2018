package com.app.thinkfit.ui.auth.sign_up.survey_climbing_stairs;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SurveyClimbingStairsPresenter extends BasePresenter<SurveyClimbingStairsMVPView> {

    @Inject
    public SurveyClimbingStairsPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SurveyClimbingStairsMVPView mvpView) {
        super.initialView(mvpView);
    }
}
