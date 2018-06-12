package com.app.thinkfit.ui.tutorial;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/18
 */

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.TutorialAdapter;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.Tutorial;
import com.app.thinkfit.ui.auth.sign_in.SignInActivity;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import me.relex.circleindicator.CircleIndicator;

public class TutorialActivity extends BaseMVPDialogActivity implements TutorialMVPView {

    @Inject
    TutorialPresenter presenter;

    @BindView(R.id.viewpager)
    public ViewPager mViewPage;

    @BindView(R.id.indicator)
    public CircleIndicator mIndicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        presenter.getListTutorial();
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_tutorial;
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

    @Override
    public void updateListTutorial(List<Tutorial> listTutorial) {
        TutorialAdapter tutorialAdapter = new TutorialAdapter(this, listTutorial);
        mViewPage.setAdapter(tutorialAdapter);
        mIndicator.setViewPager(mViewPage);
        tutorialAdapter.registerDataSetObserver(mIndicator.getDataSetObserver());
    }

    @OnClick(R.id.tv_skip)
    public void onClickSkip() {
        GlobalFuntion.startActivity(this, SignInActivity.class);
    }
}
