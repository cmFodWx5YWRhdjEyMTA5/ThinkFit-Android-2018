package com.app.thinkfit.ui.auth.sign_up.register_mode;

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

public class RegisterModeActivity extends BaseMVPDialogActivity implements RegisterModeMVPView {

    @Inject
    RegisterModePresenter presenter;

    @BindView(R.id.tv_message)
    TextView tvMessage;

    @BindView(R.id.img_back)
    ImageView imgBack;

    @BindView(R.id.rdg_mode)
    RadioGroup rdgMode;

    @BindView(R.id.rdb1)
    RadioButton rdb1;

    @BindView(R.id.rdb2)
    RadioButton rdb2;

    @BindView(R.id.rdb3)
    RadioButton rdb3;

    @BindView(R.id.rdb4)
    RadioButton rdb4;

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
        return R.layout.activity_register_mode;
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
        Spannable message1 = new SpannableString(getString(R.string.message_register_mode_1));
        tvMessage.setText(message1);
        tvMessage.append(" ");

        Spannable message2 = new SpannableString(getString(R.string.moderately));
        ClickableSpan clickModerately = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                GlobalFuntion.showDialogDescription(RegisterModeActivity.this,
                        "Hi, thank you. I set its gravity to top, the dialog goes on the" +
                                " top of the screen, but it also covered my action bar, I would like " +
                                "the dialog on top but just under the action bar...how to adjust this?");
            }

            @Override
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(getResources().getColor(R.color.orange));
            }
        };
        message2.setSpan(clickModerately, 0, message2.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvMessage.append(message2);
        tvMessage.append(" ");

        Spannable message3 = new SpannableString(getString(R.string.message_register_mode_2));
        tvMessage.append(message3);
        tvMessage.append(" ");

        Spannable message4 = new SpannableString(getString(R.string.vigorously));
        ClickableSpan clickVigorously = new ClickableSpan() {
            @Override
            public void onClick(View textView) {
                GlobalFuntion.showDialogDescription(RegisterModeActivity.this, "Content test 2");
            }

            @Override
            public void updateDrawState(TextPaint textPaint) {
                textPaint.setColor(getResources().getColor(R.color.orange));
            }
        };
        message4.setSpan(clickVigorously, 0, message4.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tvMessage.append(message4);
        tvMessage.append(" ");

        Spannable message5 = new SpannableString(getString(R.string.message_register_mode_3));
        tvMessage.append(message5);

        tvMessage.setMovementMethod(LinkMovementMethod.getInstance());
    }

    @OnClick(R.id.img_back)
    public void onClickBack() {
        onBackPressed();
    }

    private void onClickSelectMode() {
        rdgMode.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb1:
                        rdb1.setTextColor(getResources().getColor(R.color.orange));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb2:
                        rdb2.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb3:
                        rdb3.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb4.setTextColor(getResources().getColor(R.color.black));
                        break;

                    case R.id.rdb4:
                        rdb4.setTextColor(getResources().getColor(R.color.orange));
                        rdb1.setTextColor(getResources().getColor(R.color.black));
                        rdb2.setTextColor(getResources().getColor(R.color.black));
                        rdb3.setTextColor(getResources().getColor(R.color.black));
                        break;
                }
            }
        });
    }

    @OnClick(R.id.tv_continue)
    public void onClickContinue() {
        int checkedRadioButtonId = rdgMode.getCheckedRadioButtonId();
        switch (checkedRadioButtonId) {
            case R.id.rdb1:
                GlobalFuntion.goToDetailSelected(RegisterModeActivity.this, getString(R.string.title_mode_1),
                        getString(R.string.message_mode_1), Constant.REGISTER_MODE_ACTIVITY);
                break;

            case R.id.rdb2:
                GlobalFuntion.goToDetailSelected(RegisterModeActivity.this, getString(R.string.title_mode_2),
                        getString(R.string.message_mode_2), Constant.REGISTER_MODE_ACTIVITY);
                break;

            case R.id.rdb3:
                GlobalFuntion.goToDetailSelected(RegisterModeActivity.this, getString(R.string.title_mode_3),
                        getString(R.string.message_mode_3), Constant.REGISTER_MODE_ACTIVITY);
                break;

            case R.id.rdb4:
                GlobalFuntion.goToDetailSelected(RegisterModeActivity.this, getString(R.string.title_mode_4),
                        getString(R.string.message_mode_4), Constant.REGISTER_MODE_ACTIVITY);
                break;
        }
    }
}
