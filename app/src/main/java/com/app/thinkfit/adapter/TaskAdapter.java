package com.app.thinkfit.adapter;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/28
 */

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.base.Releasable;
import com.app.thinkfit.constant.Constant;
import com.app.thinkfit.constant.GlobalFuntion;
import com.app.thinkfit.models.Task;
import com.app.thinkfit.ui.my_task.doing_task.DoingTaskActivity;
import com.chauthai.swipereveallayout.SwipeRevealLayout;
import com.chauthai.swipereveallayout.ViewBinderHelper;

import java.util.ArrayList;
import java.util.List;

public class TaskAdapter extends RecyclerView.Adapter implements Releasable {
    private List<Task> mData = new ArrayList<>();
    private LayoutInflater mInflater;
    private Context mContext;
    private final ViewBinderHelper binderHelper = new ViewBinderHelper();


    public TaskAdapter(Context context, List<Task> dataSet) {
        mContext = context;
        mData = dataSet;
        mInflater = LayoutInflater.from(context);

        // uncomment if you want to open only one row at a time
        // binderHelper.setOpenOnlyOne(true);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_task, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder h, int position) {
        final ViewHolder holder = (ViewHolder) h;

        if (mData != null && 0 <= position && position < mData.size()) {
            final Task task = mData.get(position);

            // Use ViewBindHelper to restore and save the open/close state of the SwipeRevealView
            // put an unique string id as value, can be any string which uniquely define the data
            binderHelper.bind(holder.swipeLayout, task.getId());

            // Bind your data here
            holder.bind(task);
        }
    }

    @Override
    public int getItemCount() {
        if (mData == null)
            return 0;
        return mData.size();
    }

    /**
     * Only if you need to restore open/close state when the orientation is changed.
     * Call this method in {@link android.app.Activity#onSaveInstanceState(Bundle)}
     */
    public void saveStates(Bundle outState) {
        binderHelper.saveStates(outState);
    }

    /**
     * Only if you need to restore open/close state when the orientation is changed.
     * Call this method in {@link android.app.Activity#onRestoreInstanceState(Bundle)}
     */
    public void restoreStates(Bundle inState) {
        binderHelper.restoreStates(inState);
    }

    @Override
    public void release() {
        mContext = null;
    }

    private class ViewHolder extends RecyclerView.ViewHolder {
        private SwipeRevealLayout swipeLayout;
        private View deleteLayout;
        private TextView tvTitle;
        private LinearLayout layoutItem;

        public ViewHolder(View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe_layout);
            deleteLayout = itemView.findViewById(R.id.delete_layout);
            tvTitle = itemView.findViewById(R.id.tv_title);
            layoutItem = itemView.findViewById(R.id.layout_item);
        }

        public void bind(final Task task) {
            deleteLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mData.remove(getAdapterPosition());
                    notifyItemRemoved(getAdapterPosition());
                }
            });

            tvTitle.setText(task.getTitle());

            layoutItem.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Bundle bundle = new Bundle();
                    bundle.putSerializable(Constant.OBJECT_TASK, task);
                    GlobalFuntion.startActivity(mContext, DoingTaskActivity.class, bundle);
                }
            });
        }
    }
}
