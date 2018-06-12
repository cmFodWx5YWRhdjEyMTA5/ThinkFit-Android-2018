package com.app.thinkfit.ui.my_task;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import com.app.thinkfit.models.Task;
import com.app.thinkfit.ui.base.BaseScreenMvpView;

import java.util.List;

interface MyTaskMVPView extends BaseScreenMvpView {

    void updateListTask(List<Task> listTask);
}
