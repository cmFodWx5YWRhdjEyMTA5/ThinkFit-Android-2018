package com.app.thinkfit.ui.my_task.add_task;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/29
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.ui.base.BasePresenter;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class AddTaskPresenter extends BasePresenter<AddTaskMVPView> {

    @Inject
    public AddTaskPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(AddTaskMVPView mvpView) {
        super.initialView(mvpView);
    }
}
