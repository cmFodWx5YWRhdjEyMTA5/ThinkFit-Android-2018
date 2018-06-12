package com.app.thinkfit.ui.main;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.about_app.AboutAppFragment;
import com.app.thinkfit.ui.base.BaseMVPDialogActivity;
import com.app.thinkfit.ui.contact_us.ContactUsFragment;
import com.app.thinkfit.ui.my_task.MyTaskFragment;
import com.app.thinkfit.ui.notification.NotificationFragment;
import com.app.thinkfit.ui.sort_by.SortByFragment;
import com.app.thinkfit.ui.term_and_condition.TermAndConditionFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends BaseMVPDialogActivity implements MainMVPView {

    @Inject
    MainPresenter presenter;

    @BindView(R.id.drawer_layout)
    public DrawerLayout mDrawerLayout;

    @BindView(R.id.tv_title)
    TextView tvTitle;

    @BindView(R.id.img_sort)
    ImageView imgSort;

    @BindView(R.id.sw_notification)
    Switch swNotification;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this);
        presenter.initialView(this);

        setListenerDrawer();
        replaceFragment(new MyTaskFragment(), MyTaskFragment.class.getName());
    }

    @Override
    protected boolean bindView() {
        return true;
    }

    @Override
    protected int addContextView() {
        return R.layout.activity_main;
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

    private void setListenerDrawer() {
        mDrawerLayout.addDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(@NonNull View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(@NonNull View drawerView) {
                GlobalFuntion.hideSoftKeyboard(MainActivity.this);
            }

            @Override
            public void onDrawerClosed(@NonNull View drawerView) {

            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
    }

    @Override
    public void onBackPressed() {
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            showDialogLogout();
        }
    }

    private void showDialogLogout() {
        MaterialDialog materialDialog = new MaterialDialog.Builder(this)
                .title(getString(R.string.app_name))
                .content(getString(R.string.msg_exit_app))
                .positiveText(getString(R.string.action_ok))
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        finish();
                    }
                })
                .negativeText(getString(R.string.action_cancel))
                .cancelable(false)
                .show();
    }

    public void replaceFragment(Fragment fragment, String tag) {
        final FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
        ft.replace(R.id.content_frame, fragment, tag);
        ft.commit();
    }

    public void setToolbarTitle(String title) {
        tvTitle.setText(title);
    }

    public void showAndHiddenItemToolbar(boolean isShowSort, boolean isShowSwitch) {
        if (isShowSort) {
            imgSort.setVisibility(View.VISIBLE);
        } else {
            imgSort.setVisibility(View.INVISIBLE);
        }

        if (isShowSwitch) {
            swNotification.setVisibility(View.VISIBLE);
        } else {
            swNotification.setVisibility(View.INVISIBLE);
        }
    }

    @OnClick({R.id.img_close, R.id.img_menu, R.id.tv_menu_home, R.id.tv_menu_about_app,
            R.id.tv_menu_notification, R.id.tv_menu_contact_us, R.id.tv_menu_term_and_condition,
            R.id.img_sort})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.img_close:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                break;

            case R.id.img_menu:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;

            case R.id.tv_menu_home:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                replaceFragment(new MyTaskFragment(), MyTaskFragment.class.getName());
                break;

            case R.id.tv_menu_about_app:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                replaceFragment(new AboutAppFragment(), AboutAppFragment.class.getName());
                break;

            case R.id.tv_menu_notification:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                replaceFragment(new NotificationFragment(), NotificationFragment.class.getName());
                break;

            case R.id.tv_menu_contact_us:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                replaceFragment(new ContactUsFragment(), ContactUsFragment.class.getName());
                break;

            case R.id.tv_menu_term_and_condition:
                mDrawerLayout.closeDrawer(GravityCompat.START);
                replaceFragment(new TermAndConditionFragment(), TermAndConditionFragment.class.getName());
                break;

            case R.id.img_sort:
                replaceFragment(new SortByFragment(), SortByFragment.class.getName());
                break;
        }
    }
}
