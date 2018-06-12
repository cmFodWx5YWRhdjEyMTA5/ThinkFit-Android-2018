package com.app.thinkfit.ui.notification;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.NotificationAdapter;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.Notification;
import com.app.thinkfit.ui.base.BaseMVPFragmentWithDialog;
import com.app.thinkfit.ui.main.MainActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class NotificationFragment extends BaseMVPFragmentWithDialog implements NotificationMVPView {

    @Inject
    NotificationPresenter presenter;

    @BindView(R.id.rcv_notification)
    RecyclerView rcvNotification;

    private NotificationAdapter notificationAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_notifications, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this, view);
        presenter.initialView(this);
        ((MainActivity) getActivity()).showAndHiddenItemToolbar(false, true);

        presenter.getListNotification();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroyView();

        if (notificationAdapter != null) {
            notificationAdapter.release();
        }
    }

    @Override
    protected void initToolbar() {
        ((MainActivity) getActivity()).setToolbarTitle(getString(R.string.notifications));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(getActivity(), code);
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (notificationAdapter != null) {
            notificationAdapter.saveStates(outState);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            // Only if you need to restore open/close state when
            // the orientation is changed
            if (notificationAdapter != null) {
                notificationAdapter.restoreStates(savedInstanceState);
            }
        }
    }

    @Override
    public void updateListNotification(List<Notification> listNotification) {
        rcvNotification.setLayoutManager(new LinearLayoutManager(getActivity()));

        notificationAdapter = new NotificationAdapter(getActivity(), listNotification);
        rcvNotification.setAdapter(notificationAdapter);
    }

    @OnClick(R.id.layout_remove_all)
    public void onClickRemoveAll() {
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.layout_dialog_confirm_remove_notification);
        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.MATCH_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);
        window.setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        WindowManager.LayoutParams windowAttributes = window.getAttributes();
        windowAttributes.gravity = Gravity.BOTTOM;
        window.setAttributes(windowAttributes);
        dialog.setCancelable(false);

        // Get view
        final TextView tvActionYes = dialog.findViewById(R.id.tv_action_yes);
        final TextView tvActionNo = dialog.findViewById(R.id.tv_action_no);

        tvActionYes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Todo delete all notification
            }
        });

        tvActionNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}
