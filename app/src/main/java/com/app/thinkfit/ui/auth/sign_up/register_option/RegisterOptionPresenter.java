package com.app.thinkfit.ui.auth.sign_up.register_option;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/19
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.models.Day;
import com.app.thinkfit.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class RegisterOptionPresenter extends BasePresenter<RegisterOptionMVPView> {

    @Inject
    public RegisterOptionPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(RegisterOptionMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getListDay() {
        List<Day> listDay = new ArrayList<>();
        listDay.add(new Day("S", false));
        listDay.add(new Day("M", true));
        listDay.add(new Day("T", false));
        listDay.add(new Day("W", true));
        listDay.add(new Day("T", false));
        listDay.add(new Day("F", false));
        listDay.add(new Day("S", false));

        getMvpView().loadListDay(listDay);
    }
}
