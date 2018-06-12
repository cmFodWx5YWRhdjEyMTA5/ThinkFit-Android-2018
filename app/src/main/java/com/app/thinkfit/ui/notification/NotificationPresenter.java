package com.app.thinkfit.ui.notification;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import com.app.thinkfit.data.DataManager;
import com.app.thinkfit.injection.PerActivity;
import com.app.thinkfit.models.Notification;
import com.app.thinkfit.ui.base.BasePresenter;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Retrofit;

@PerActivity
public class NotificationPresenter extends BasePresenter<NotificationMVPView> {

    @Inject
    public NotificationPresenter(Retrofit mRetrofit, DataManager mDataManager) {
        super(mRetrofit, mDataManager);
    }

    @Override
    public void initialView(NotificationMVPView mvpView) {
        super.initialView(mvpView);
    }

    @Override
    public void destroyView() {
        super.destroyView();
    }

    public void getListNotification() {
        List<Notification> list = new ArrayList<>();
        list.add(new Notification("1", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("2", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("3", "Lorem Ipsum is simply", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("4", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("5", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("6", "Lorem and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("7", "Lorem Ipsum is simply dummy text of the and typesetting industry. Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("8", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("9", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));
        list.add(new Notification("10", "Lorem Ipsum is simply dummy text of the and typesetting industry.", "12 - Mar - 2018, 07.30 PM"));

        getMvpView().updateListNotification(list);
    }
}
