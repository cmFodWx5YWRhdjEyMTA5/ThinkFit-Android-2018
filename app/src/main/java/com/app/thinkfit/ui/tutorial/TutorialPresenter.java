package com.app.thinkfit.ui.tutorial;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/18
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.models.Tutorial;
import com.app.thinkfit.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class TutorialPresenter extends BasePresenter<TutorialMVPView> {

    @Inject
    public TutorialPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(TutorialMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getListTutorial() {
        List<Tutorial> listTutorial = new ArrayList<>();
        listTutorial.add(new Tutorial("Welcom 1"));
        listTutorial.add(new Tutorial("Welcom 2"));
        listTutorial.add(new Tutorial("Welcom 3"));

        getMvpView().updateListTutorial(listTutorial);
    }
}
