package com.app.thinkfit.ui.tutorial;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/18
 */

import com.app.thinkfit.models.Tutorial;
import com.app.thinkfit.ui.base.BaseScreenMvpView;

import java.util.List;

interface TutorialMVPView extends BaseScreenMvpView {

    void updateListTutorial(List<Tutorial> listTutorial);
}
