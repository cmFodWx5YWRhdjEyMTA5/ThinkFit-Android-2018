package com.app.thinkfit.ui.auth.sign_up.survey_other;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import com.app.thinkfit.models.SurveyOther;
import com.app.thinkfit.ui.base.BaseScreenMvpView;

import java.util.List;

interface SurveyOtherMVPView extends BaseScreenMvpView {

    void loadListSurveyOther(List<SurveyOther> listSurveyOther);
}
