package com.app.thinkfit.ui.auth.sign_up.register_option;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/19
 */

import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.support.v7.widget.RecyclerView;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.DayAdapter;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.Day;
import com.app.thinkfit.ui.auth.sign_up.register_confirm.RegisterConfirmActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class RegisterOptionActivity extends BaseMVPDialogActivity implements RegisterOptionMVPView {

    @Inject
    RegisterOptionPresenter presenter;

    @BindView(R.id.rcv_day)
    RecyclerView rcvDay;

    @BindView(R.id.layout_average_start_time)
    LinearLayout layoutAverageStartTime;

    @BindView(R.id.tv_average_start_time)
    TextView tvAverageStartTime;

    private DayAdapter dayAdapter;
    private List<Day> mListDay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        dayAdapter = new DayAdapter(this, new DayAdapter.IClickItemListener() {
            @Override
            public void onClickItem(int position) {
                dayAdapter.reloadItem(position);
            }
        });
        dayAdapter.injectInto(rcvDay);

        presenter.getListDay();
        onClickLayoutAverageStartTime();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_register_option;
    }

    @Override
    protected void onDestroy() {
        presenter.destroyView();
        if (dayAdapter != null) {
            dayAdapter.release();
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
    public void loadListDay(List<Day> listDay) {
        mListDay = listDay;
        dayAdapter.setListData(mListDay);
    }

    public void onClickLayoutAverageStartTime() {
        layoutAverageStartTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(RegisterOptionActivity.this, v);
                popup.getMenuInflater().inflate(R.menu.menu_average_start_time, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        tvAverageStartTime.setText(item.getTitle());
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    @OnClick(R.id.tv_continue)
    public void onClickContinue() {
        GlobalFuntion.startActivity(this, RegisterConfirmActivity.class);
    }
}
