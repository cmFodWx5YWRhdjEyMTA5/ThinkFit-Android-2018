package com.app.thinkfit.ui.auth.sign_up.survey_climbing_stairs;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.SurveyOtherAdapter;
import com.app.thinkfit.constant.Constant;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.auth.sign_up.survey_other.SurveyOtherActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SurveyClimbingStairsActivity extends BaseMVPDialogActivity implements SurveyClimbingStairsMVPView {

    @Inject
    SurveyClimbingStairsPresenter presenter;

    @BindView(R.id.img_back)
    ImageView imgBack;

    @BindView(R.id.rdg_survey_climbing_stairs)
    RadioGroup rdgSurveyClimbingStairs;

    @BindView(R.id.rdb1)
    RadioButton rdb1;

    @BindView(R.id.rdb2)
    RadioButton rdb2;

    @BindView(R.id.rdb3)
    RadioButton rdb3;

    @BindView(R.id.rdb4)
    RadioButton rdb4;

    @BindView(R.id.rdb5)
    RadioButton rdb5;

    @Inject
    public SurveyOtherAdapter surveyOtherAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        imgBack.setVisibility(View.VISIBLE);
        onClickSelectMode();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_survey_climbing_stairs;
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

    @OnClick(R.id.img_back)
    public void onClickBack() {
        onBackPressed();
    }

    private void onClickSelectMode() {
        rdgSurveyClimbingStairs.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb1:
                        rdb1.setTextColor(getResources().getColor(R.color.orange));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        rdb5.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb2:
                        rdb2.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        rdb5.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb3:
                        rdb3.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        rdb5.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb4:
                        rdb4.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        rdb5.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb5:
                        rdb5.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        break;
                }
            }
        });
    }

    @OnClick(R.id.tv_continue)
    public void onClickContinue() {
        int checkedRadioButtonId = rdgSurveyClimbingStairs.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.rdb1:
                GlobalFuntion.startActivity(this, SurveyOtherActivity.class);
                break;

            case R.id.rdb2:
                GlobalFuntion.startActivity(this, SurveyOtherActivity.class);
                break;

            case R.id.rdb3:
                GlobalFuntion.goToDetailSelected(SurveyClimbingStairsActivity.this,
                        getString(R.string.title_tip), getString(R.string.message_tip_1),
                        Constant.SURVEY_CLIMBING_STAIRS_ACTIVITY);
                break;

            case R.id.rdb4:
                GlobalFuntion.goToDetailSelected(SurveyClimbingStairsActivity.this,
                        getString(R.string.title_tip), getString(R.string.message_tip_2),
                        Constant.SURVEY_CLIMBING_STAIRS_ACTIVITY);
                break;

            case R.id.rdb5:
                GlobalFuntion.goToDetailSelected(SurveyClimbingStairsActivity.this,
                        getString(R.string.title_tip), getString(R.string.message_tip_3),
                        Constant.SURVEY_CLIMBING_STAIRS_ACTIVITY);
                break;
        }
    }
}
