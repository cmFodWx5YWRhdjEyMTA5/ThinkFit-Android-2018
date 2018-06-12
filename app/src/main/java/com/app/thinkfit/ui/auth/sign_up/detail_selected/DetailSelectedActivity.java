package com.app.thinkfit.ui.auth.sign_up.detail_selected;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.Constant;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.auth.sign_up.survey_climbing_stairs.SurveyClimbingStairsActivity;
import com.app.thinkfit.ui.auth.sign_up.survey_other.SurveyOtherActivity;
import com.app.thinkfit.ui.auth.sign_up.survey_strengthen.SurveyStrengthenActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;
import com.app.thinkfit.utils.StringUtil;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DetailSelectedActivity extends BaseMVPDialogActivity implements DetailSelectedMVPView {

    @Inject
    DetailSelectedPresenter presenter;

    @BindView(R.id.layout_page)
    LinearLayout layoutPage;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.tv_description)
    TextView tvDescription;

    @BindView(R.id.tv_continue)
    TextView tvContinue;

    private String mTitle;
    private String mDescription;
    private String mFromActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        loadData();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_detail_selected;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
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

    private void loadData() {
        Bundle bundle = getIntent().getExtras();
        if (null != bundle) {
            mTitle = bundle.getString(Constant.KEY_TITLE);
            mDescription = bundle.getString(Constant.KEY_DESCRIPTION);
            mFromActivity = bundle.getString(Constant.KEY_FROM_ACTIVITY);
        }

        if (Constant.REGISTER_MODE_ACTIVITY.equals(mFromActivity) ||
                Constant.SURVEY_CLIMBING_STAIRS_ACTIVITY.equals(mFromActivity)) {
            layoutPage.setBackgroundResource(R.color.green);
            tvContinue.setTextColor(getResources().getColor(R.color.green));
        } else if (Constant.SURVEY_STRENGTHEN_ACTIVITY.equals(mFromActivity)) {
            layoutPage.setBackgroundResource(R.color.pink);
            tvContinue.setTextColor(getResources().getColor(R.color.pink));
        }

        if (!StringUtil.isEmpty(mTitle)) {
            tvTitle.setText(mTitle);
        }

        if (!StringUtil.isEmpty(mDescription)) {
            tvDescription.setText(mDescription);
        }
    }

    @OnClick(R.id.tv_continue)
    public void onClickContinue() {
        if (Constant.REGISTER_MODE_ACTIVITY.equals(mFromActivity)) {
            GlobalFuntion.startActivity(this, SurveyStrengthenActivity.class);
            finish();
        } else if (Constant.SURVEY_STRENGTHEN_ACTIVITY.equals(mFromActivity)) {
            GlobalFuntion.startActivity(this, SurveyClimbingStairsActivity.class);
            finish();
        } else if (Constant.SURVEY_CLIMBING_STAIRS_ACTIVITY.equals(mFromActivity)) {
            GlobalFuntion.startActivity(this, SurveyOtherActivity.class);
            finish();
        }
    }
}
