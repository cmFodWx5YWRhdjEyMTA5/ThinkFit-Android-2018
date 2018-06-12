package com.app.thinkfit.ui.my_task;

/*
 * ******************************************************************************
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/16
 * ******************************************************************************
 */

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.TaskAdapter;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.Task;
import com.app.thinkfit.ui.base.BaseMVPFragmentWithDialog;
import com.app.thinkfit.ui.main.MainActivity;
import com.app.thinkfit.ui.my_task.add_task.AddTaskActivity;
import com.app.thinkfit.ui.widget.views.VerticalSpaceItemDecoration;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MyTaskFragment extends BaseMVPFragmentWithDialog implements MyTaskMVPView {

    @Inject
    MyTaskPresenter presenter;

    @BindView(R.id.rcv_task)
    RecyclerView rcvTask;

    @BindView(R.id.layout_no_data)
    LinearLayout layoutNoData;

    private TaskAdapter taskAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_home, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        getActivityComponent().inject(this);
        viewUnbind = ButterKnife.bind(this, view);
        presenter.initialView(this);
        ((MainActivity) getActivity()).showAndHiddenItemToolbar(true, false);

        presenter.getListTask();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.destroyView();

        if (taskAdapter != null) {
            taskAdapter.release();
        }
    }

    @Override
    protected void initToolbar() {
        ((MainActivity) getActivity()).setToolbarTitle(getString(R.string.my_task));
    }

    @Override
    public void onErrorCallApi(int code) {
        GlobalFuntion.showMessageError(getActivity(), code);
    }

    @Override
    public void updateListTask(List<Task> listTask) {
        rcvTask.setLayoutManager(new LinearLayoutManager(getActivity()));
        rcvTask.addItemDecoration(new VerticalSpaceItemDecoration(getActivity()));

        taskAdapter = new TaskAdapter(getActivity(), listTask);
        rcvTask.setAdapter(taskAdapter);
        if (listTask != null && listTask.size() > 0) {
            layoutNoData.setVisibility(View.GONE);
        } else {
            layoutNoData.setVisibility(View.VISIBLE);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        // Only if you need to restore open/close state when
        // the orientation is changed
        if (taskAdapter != null) {
            taskAdapter.saveStates(outState);
        }
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            // Only if you need to restore open/close state when
            // the orientation is changed
            if (taskAdapter != null) {
                taskAdapter.restoreStates(savedInstanceState);
            }
        }
    }

    @OnClick(R.id.image_add_task)
    public void onClickAddTask() {
        GlobalFuntion.startActivity(getActivity(), AddTaskActivity.class);
    }
}
