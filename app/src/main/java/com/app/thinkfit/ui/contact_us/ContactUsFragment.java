package com.app.thinkfit.ui.contact_us;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPFragmentWithDialog;
import com.app.thinkfit.ui.main.MainActivity;

import javax.inject.Inject;

import butterknife.ButterKnife;

public class ContactUsFragment extends BaseMVPFragmentWithDialog implements ContactUsMVPView {

    @Inject
    ContactUsPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_contact_us, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this, view);
        presenter.initialView(this);
        ((MainActivity)getActivity()).showAndHiddenItemToolbar(false, false);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroyView();
    }

    @Override
    protected void initToolbar() {
        ((MainActivity)getActivity()).setToolbarTitle(getString(R.string.contact_us));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(getActivity(), code);
    }
}
