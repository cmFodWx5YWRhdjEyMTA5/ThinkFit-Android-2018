package com.app.thinkfit.ui.my_task.recovery_time;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import android.os.Bundle;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;
import com.app.thinkfit.ui.my_task.provide_improve.ProvideImproveActivity;
import com.app.thinkfit.ui.my_task.stop_recovery_time.StopRecoveryTimeActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RecoveryTimeActivity extends BaseMVPDialogActivity implements RecoveryTimeMVPView {

    @Inject
    RecoveryTimePresenter presenter;

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        tvTitleToolbar.setText(getString(R.string.active_recovery_time));
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_recovery_time;
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

    @OnClick(R.id.layout_rolling_wheel)
    public void onClickLayoutRollingWheel() {
        GlobalFuntion.startActivity(this, StopRecoveryTimeActivity.class);
    }

    @OnClick(R.id.tv_skip)
    public void onClickSkip() {
        GlobalFuntion.startActivity(this, ProvideImproveActivity.class);
    }
}
