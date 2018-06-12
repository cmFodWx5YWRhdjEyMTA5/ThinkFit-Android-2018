package com.app.thinkfit.ui.auth.sign_up;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.os.Bundle;
import android.support.v7.widget.PopupMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.listener.IGetDateListener;
import com.app.thinkfit.ui.auth.sign_up.register_password.RegisterPasswordActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;
import com.app.thinkfit.utils.Utils;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SignUpActivity extends BaseMVPDialogActivity implements SignUpMVPView {

    @Inject
    SignUpPresenter presenter;

    @BindView(R.id.tv_date_of_birth)
    TextView tvDateOfBirth;

    @BindView(R.id.tv_gender)
    TextView tvGender;

    @BindView(R.id.layout_gender)
    LinearLayout layoutGender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        onClickLayoutGender();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_sign_up;
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

    @OnClick(R.id.layout_date_of_birth)
    public void onClickLayoutDateOfBirth() {
        Utils.showDatePicker(this, new IGetDateListener() {
            @Override
            public void getDate(String date) {
                tvDateOfBirth.setText(date);
            }
        });
    }

    public void onClickLayoutGender() {
        layoutGender.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PopupMenu popup = new PopupMenu(SignUpActivity.this, v);
                popup.getMenuInflater().inflate(R.menu.menu_gender, popup.getMenu());

                //registering popup with OnMenuItemClickListener
                popup.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                    public boolean onMenuItemClick(MenuItem item) {
                        tvGender.setText(item.getTitle());
                        return true;
                    }
                });
                popup.show();
            }
        });
    }

    @OnClick(R.id.tv_proceed)
    public void onClickProceed() {
        GlobalFuntion.startActivity(this, RegisterPasswordActivity.class);
    }
}
