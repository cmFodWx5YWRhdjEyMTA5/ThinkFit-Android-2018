package com.app.thinkfit.ui.auth.sign_up.survey_strengthen;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.TextPaint;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.Constant;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SurveyStrengthenActivity extends BaseMVPDialogActivity implements SurveyStrengthenMVPView {

    @Inject
    SurveyStrengthenPresenter presenter;

    @BindView(R.id.tv_question_survey_strengthen)
    TextView tvQuestionSurveyStrengthen;

    @BindView(R.id.rdg_strengthen)
    RadioGroup rdgStrengthen;

    @BindView(R.id.rdb1)
    RadioButton rdb1;

    @BindView(R.id.rdb2)
    RadioButton rdb2;

    @BindView(R.id.rdb3)
    RadioButton rdb3;

    @BindView(R.id.img_back)
    ImageView imgBack;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        imgBack.setVisibility(View.VISIBLE);
        loadData();
        onClickSelectMode();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_survey_strengthen;
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
        Spannable question_1 = new SpannableString(getString(R.string.question_survey_strengthen_1));
        tvQuestionSurveyStrengthen.setText(question_1);
        tvQuestionSurveyStrengthen.append(" ");

        Spannable question_2 = new SpannableString(getString(R.string.strengthen_));
        ClickableSpan clickStrengthen = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                GlobalFuntion.showDialogDescription(
                        SurveyStrengthenActivity.this,
                        "Hi, thank you. I set its gravity to top, the dialog goes on the");
            }

            @Override
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(getResources().getColor(R.color.orange));
            }
        };
        question_2.setSpan(clickStrengthen, 0, question_2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvQuestionSurveyStrengthen.append(question_2);
        tvQuestionSurveyStrengthen.append(" ");

        Spannable question_3 = new SpannableString(getString(R.string.question_survey_strengthen_2));
        tvQuestionSurveyStrengthen.append(question_3);

        tvQuestionSurveyStrengthen.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private void onClickSelectMode() {
        rdgStrengthen.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb1:
                        rdb1.setTextColor(getResources().getColor(R.color.orange));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb2:
                        rdb2.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb3:
                        rdb3.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        break;
                }
            }
        });
    }

    @OnClick(R.id.tv_continue)
    public void onClickContinue() {
        int checkedRadioButtonId = rdgStrengthen.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.rdb1:
                GlobalFuntion.goToDetailSelected(SurveyStrengthenActivity.this,
                        getString(R.string.title_strengthen_1), getString(R.string.message_strengthen_1),
                        Constant.SURVEY_STRENGTHEN_ACTIVITY);
                break;

            case R.id.rdb2:
                GlobalFuntion.goToDetailSelected(SurveyStrengthenActivity.this,
                        getString(R.string.title_strengthen_2), getString(R.string.message_strengthen_2),
                        Constant.SURVEY_STRENGTHEN_ACTIVITY);
                break;

            case R.id.rdb3:
                GlobalFuntion.goToDetailSelected(SurveyStrengthenActivity.this,
                        getString(R.string.title_strengthen_3), getString(R.string.message_strengthen_3),
                        Constant.SURVEY_STRENGTHEN_ACTIVITY);
                break;
        }
    }

    @OnClick(R.id.img_back)
    public void onClickBack() {
        onBackPressed();
    }
}
