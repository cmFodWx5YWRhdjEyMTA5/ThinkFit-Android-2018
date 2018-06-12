package com.app.thinkfit.ui.auth.sign_up.register_option;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/19
 */

import com.app.thinkfit.models.Day;
import com.app.thinkfit.ui.base.BaseScreenMvpView;

import java.util.List;

interface RegisterOptionMVPView extends BaseScreenMvpView {

    void loadListDay(List<Day> listDay);
}
