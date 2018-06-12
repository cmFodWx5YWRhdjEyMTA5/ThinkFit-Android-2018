package com.app.thinkfit.ui.sort_by;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SortByPresenter extends BasePresenter<SortByMVPView> {

    @Inject
    public SortByPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SortByMVPView mvpView) {
        super.initialView(mvpView);
    }
}
