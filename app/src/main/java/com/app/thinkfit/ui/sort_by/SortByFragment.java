package com.app.thinkfit.ui.sort_by;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 * ******************************************************************************
 */

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.ui.base.BaseMVPFragmentWithDialog;
import com.app.thinkfit.ui.main.MainActivity;
import com.app.thinkfit.ui.my_task.MyTaskFragment;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SortByFragment extends BaseMVPFragmentWithDialog implements SortByMVPView {

    @Inject
    SortByPresenter presenter;

    @BindView(R.id.rdg_category)
    RadioGroup rdgCategory;

    @BindView(R.id.rdb_category_1)
    RadioButton rdbCategory1;

    @BindView(R.id.rdb_category_2)
    RadioButton rdbCategory2;

    @BindView(R.id.rdb_category_3)
    RadioButton rdbCategory3;

    @BindView(R.id.rdb_category_4)
    RadioButton rdbCategory4;

    @BindView(R.id.tv_sort)
    TextView tvSort;

    private boolean mIsClick;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_sort_by, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this, view);
        presenter.initialView(this);

        onClickSelectCategoty();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroyView();
    }

    @Override
    protected void initToolbar() {

    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(getActivity(), code);
    }

    private void onClickSelectCategoty() {
        rdgCategory.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @SuppressLint("NewApi")
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.rdb_category_1:
                        rdbCategory1.setBackgroundResource(R.color.colorPrimary);
                        rdbCategory2.setBackgroundResource(R.color.white);
                        rdbCategory3.setBackgroundResource(R.color.white);
                        rdbCategory4.setBackgroundResource(R.color.white);

                        rdbCategory1.setTextColor(getResources().getColor(R.color.white));
                        rdbCategory2.setTextColor(getResources().getColor(R.color.orange));
                        rdbCategory3.setTextColor(getResources().getColor(R.color.green));
                        rdbCategory4.setTextColor(getResources().getColor(R.color.purple));
                        break;

                    case R.id.rdb_category_2:
                        rdbCategory2.setBackgroundResource(R.color.colorPrimary);
                        rdbCategory1.setBackgroundResource(R.color.white);
                        rdbCategory3.setBackgroundResource(R.color.white);
                        rdbCategory4.setBackgroundResource(R.color.white);

                        rdbCategory2.setTextColor(getResources().getColor(R.color.white));
                        rdbCategory1.setTextColor(getResources().getColor(R.color.red));
                        rdbCategory3.setTextColor(getResources().getColor(R.color.green));
                        rdbCategory4.setTextColor(getResources().getColor(R.color.purple));
                        break;

                    case R.id.rdb_category_3:
                        rdbCategory3.setBackgroundResource(R.color.colorPrimary);
                        rdbCategory3.setTextColor(getResources().getColor(R.color.white));
                        rdbCategory1.setBackgroundResource(R.color.white);
                        rdbCategory2.setBackgroundResource(R.color.white);
                        rdbCategory4.setBackgroundResource(R.color.white);

                        rdbCategory3.setTextColor(getResources().getColor(R.color.white));
                        rdbCategory1.setTextColor(getResources().getColor(R.color.red));
                        rdbCategory2.setTextColor(getResources().getColor(R.color.orange));
                        rdbCategory4.setTextColor(getResources().getColor(R.color.purple));
                        break;

                    case R.id.rdb_category_4:
                        rdbCategory4.setBackgroundResource(R.color.colorPrimary);
                        rdbCategory4.setTextColor(getResources().getColor(R.color.white));
                        rdbCategory1.setBackgroundResource(R.color.white);
                        rdbCategory2.setBackgroundResource(R.color.white);
                        rdbCategory3.setBackgroundResource(R.color.white);

                        rdbCategory4.setTextColor(getResources().getColor(R.color.white));
                        rdbCategory1.setTextColor(getResources().getColor(R.color.red));
                        rdbCategory2.setTextColor(getResources().getColor(R.color.orange));
                        rdbCategory3.setTextColor(getResources().getColor(R.color.green));
                        break;
                }
                mIsClick = true;
                tvSort.setBackgroundResource(R.drawable.bg_orange_corner);
                tvSort.setTextColor(getResources().getColor(R.color.white));
            }
        });
    }

    @OnClick(R.id.tv_sort)
    public void onClickSort() {
        if (mIsClick)
            ((MainActivity) getActivity()).replaceFragment(new MyTaskFragment(),
                    MyTaskFragment.class.getName());
    }
}
