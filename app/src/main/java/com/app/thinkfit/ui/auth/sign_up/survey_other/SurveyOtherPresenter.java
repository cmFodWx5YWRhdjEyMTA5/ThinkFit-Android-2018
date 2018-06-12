package com.app.thinkfit.ui.auth.sign_up.survey_other;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import android.content.Context;

import com.app.thinkfit.R;
import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.models.SurveyOther;
import com.app.thinkfit.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SurveyOtherPresenter extends BasePresenter<SurveyOtherMVPView> {

    @Inject
    public SurveyOtherPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SurveyOtherMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getListFeelClimbingStairs(Context context) {
        List<SurveyOther> listSurveyOther = new ArrayList<>();
        listSurveyOther.add(new SurveyOther(context.getString(R.string.survey_other_1)));
        listSurveyOther.add(new SurveyOther(context.getString(R.string.survey_other_2)));
        listSurveyOther.add(new SurveyOther(context.getString(R.string.survey_other_3)));
        listSurveyOther.add(new SurveyOther(context.getString(R.string.survey_other_4)));
        listSurveyOther.add(new SurveyOther(context.getString(R.string.survey_other_5)));

        getMvpView().loadListSurveyOther(listSurveyOther);
    }
}
