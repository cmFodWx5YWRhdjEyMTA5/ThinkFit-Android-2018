package com.app.thinkfit.ui.my_task;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.injection.PerActivity;
import com.app.thinkfit.models.Task;
import com.app.thinkfit.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

@PerActivity
public class MyTaskPresenter extends BasePresenter<MyTaskMVPView> {

    @Inject
    public MyTaskPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(MyTaskMVPView mvpView) {
        super.initialView(mvpView);
    }

    @Override
    public void destroyView() {
        super.destroyView();
    }

    public void getListTask() {
        List<Task> list = new ArrayList<>();
        list.add(new Task("1", "Pomodoro task name goes here for very important"));
        list.add(new Task("2", "Pomodoro task name"));
        list.add(new Task("3", "Pomodoro task name goes here for very important"));
        list.add(new Task("4", "Pomodoro task name goes here for very important"));
        list.add(new Task("5", "Pomodoro task name"));
        list.add(new Task("6", "Pomodoro task name goes here for very important"));
        list.add(new Task("7", "Pomodoro task name goes here for very important. Pomodoro task name goes here for very important"));
        list.add(new Task("8", "Pomodoro task name goes here for very important"));
        list.add(new Task("9", "Pomodoro task name goes here for very important. Pomodoro task name goes here for very important"));
        list.add(new Task("10", "Pomodoro task name goes here for very important"));

        getMvpView().updateListTask(list);
    }
}
