package com.app.thinkfit.adapter;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.base.BaseRecyclerViewAdapter;
import com.app.thinkfit.adapter.base.Releasable;
import com.app.thinkfit.injection.ActivityContext;
import com.app.thinkfit.models.Reason;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class ListReasonAdapter extends RecyclerView.Adapter<BaseRecyclerViewAdapter.BaseViewHolder>
        implements Releasable {

    private Context context;
    private List<Reason> listReason;

    @Inject
    public ListReasonAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public BaseRecyclerViewAdapter.BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        BaseRecyclerViewAdapter.BaseViewHolder viewHolder = null;
        switch (viewType) {
            case Reason.TYPE_NORMAL:
                viewHolder = ReasonNormalViewHolder.create(parent);
                break;
            case Reason.TYPE_OTHER:
                viewHolder = ReasonOtherViewHolder.create(parent);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BaseRecyclerViewAdapter.BaseViewHolder holder, int position) {
        holder.bindData(context, listReason.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listReason ? 0 : listReason.size();
    }

    @Override
    public int getItemViewType(int position) {
        return listReason.get(position).getType();
    }

    public void setData(List<Reason> listReason) {
        this.listReason = listReason;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        recyclerView.setNestedScrollingEnabled(false);
        recyclerView.setFocusable(false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class ReasonNormalViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Reason> {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        public ReasonNormalViewHolder(View itemView) {
            super(itemView);
        }

        public static ReasonNormalViewHolder create(ViewGroup parent) {
            return new ReasonNormalViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_reason_normal, parent, false));
        }

        @Override
        public void bindData(Context context, Reason reason, int position) {
            tvTitle.setText(reason.getTitle());
        }
    }

    public static class ReasonOtherViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Reason> {

        @BindView(R.id.tv_title)
        TextView tvTitle;

        public ReasonOtherViewHolder(View itemView) {
            super(itemView);
        }

        public static ReasonOtherViewHolder create(ViewGroup parent) {
            return new ReasonOtherViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_reason_other, parent, false));
        }

        @Override
        public void bindData(Context context, Reason reason, int position) {
            tvTitle.setText(reason.getTitle());
        }
    }
}
