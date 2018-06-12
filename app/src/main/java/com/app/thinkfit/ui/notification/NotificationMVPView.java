package com.app.thinkfit.ui.notification;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import com.app.thinkfit.models.Notification;
import com.app.thinkfit.ui.base.BaseScreenMvpView;

import java.util.List;

interface NotificationMVPView extends BaseScreenMvpView {

    void updateListNotification(List<Notification> listNotification);
}
