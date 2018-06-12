package com.app.thinkfit.ui.my_task.add_task;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/29
 */

import android.os.Bundle;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AddTaskActivity extends BaseMVPDialogActivity implements AddTaskMVPView {

    @Inject
    AddTaskPresenter presenter;

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        tvTitleToolbar.setText(getString(R.string.new_task));
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_add_task;
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

    @OnClick(R.id.layout_select_category)
    public void onClickLayoutSelectCategory() {
        GlobalFuntion.showDialogDescription(this, "Explanation Of Categories");
    }
}
