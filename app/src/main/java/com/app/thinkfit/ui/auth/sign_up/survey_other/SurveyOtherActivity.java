package com.app.thinkfit.ui.auth.sign_up.survey_other;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.SurveyOtherAdapter;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.SurveyOther;
import com.app.thinkfit.ui.auth.sign_up.survey_workstation.SurveyWorkStationActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SurveyOtherActivity extends BaseMVPDialogActivity implements SurveyOtherMVPView {

    @Inject
    SurveyOtherPresenter presenter;

    @BindView(R.id.rcv_survey_other)
    RecyclerView rcvSurveyOther;

    @Inject
    public SurveyOtherAdapter surveyOtherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        surveyOtherAdapter.injectInto(rcvSurveyOther);
        presenter.getListFeelClimbingStairs(this);

    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_survey_other;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
        if (surveyOtherAdapter != null) {
            surveyOtherAdapter.release();
        }
        super.onDestroy();
    }

    @Override
    public void showNoNetworkAlert() {
        showAlert(getString(R.string.error_not_connect_to_internet));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(this, code);
    }

    @Override
    public void loadListSurveyOther(List<SurveyOther> listSurveyOther) {
        surveyOtherAdapter.setListData(listSurveyOther);
    }

    @OnClick(R.id.tv_continue)
    public void onClickContinue() {
        GlobalFuntion.startActivity(this, SurveyWorkStationActivity.class);
    }
}
