package com.app.thinkfit.ui.my_task.time_over;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import android.os.Bundle;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class TimeOverActivity extends BaseMVPDialogActivity implements TimeOverMVPView {

    @Inject
    TimeOverPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_time_over;
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
}
