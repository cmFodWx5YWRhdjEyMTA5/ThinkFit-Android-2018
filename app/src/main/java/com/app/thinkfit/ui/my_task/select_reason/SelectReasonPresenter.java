package com.app.thinkfit.ui.my_task.select_reason;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/29
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.models.Reason;
import com.app.thinkfit.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

public class SelectReasonPresenter extends BasePresenter<SelectReasonMVPView> {

    @Inject
    public SelectReasonPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(SelectReasonMVPView mvpView) {
        super.initialView(mvpView);
    }

    public void getListReason() {
        List<Reason> list = new ArrayList<>();
        list.add(new Reason(Reason.TYPE_NORMAL, "Telephone Call"));
        list.add(new Reason(Reason.TYPE_NORMAL, "Personal Interruption"));
        list.add(new Reason(Reason.TYPE_NORMAL, "Social Media Notification"));
        list.add(new Reason(Reason.TYPE_NORMAL, "Email Notification"));
        list.add(new Reason(Reason.TYPE_NORMAL, "Toilet Emergency"));
        list.add(new Reason(Reason.TYPE_NORMAL, "No problem, Task Completed"));
        list.add(new Reason(Reason.TYPE_OTHER, "Others"));

        getMvpView().loadListReason(list);
    }
}
