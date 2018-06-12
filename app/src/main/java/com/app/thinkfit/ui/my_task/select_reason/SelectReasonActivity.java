package com.app.thinkfit.ui.my_task.select_reason;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.ListReasonAdapter;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.Reason;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;
import com.app.thinkfit.ui.my_task.complete_task.CompleteTaskActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SelectReasonActivity extends BaseMVPDialogActivity implements SelectReasonMVPView {

    @Inject
    SelectReasonPresenter presenter;

    @BindView(R.id.tv_title_toolbar)
    TextView tvTitleToolbar;

    @BindView(R.id.rcv_reason)
    RecyclerView rcvReason;

    @Inject
    ListReasonAdapter listReasonAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        tvTitleToolbar.setText(getString(R.string.focus_time));

        listReasonAdapter.injectInto(rcvReason);
        presenter.getListReason();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_select_reason;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();

        if (listReasonAdapter != null) {
            listReasonAdapter.release();
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
    public void loadListReason(List<Reason> listReason) {
        listReasonAdapter.setData(listReason);
    }

    @OnClick(R.id.tv_submit)
    public void onClickSubmit() {
        GlobalFuntion.startActivity(this, CompleteTaskActivity.class);
    }
}
