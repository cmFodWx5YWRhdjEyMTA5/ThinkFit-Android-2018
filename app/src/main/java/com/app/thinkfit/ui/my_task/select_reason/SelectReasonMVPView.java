package com.app.thinkfit.ui.my_task.select_reason;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/29
 */

import com.app.thinkfit.models.Reason;
import com.app.thinkfit.ui.base.BaseScreenMvpView;

import java.util.List;

interface SelectReasonMVPView extends BaseScreenMvpView {

    void loadListReason(List<Reason> listReason);
}
