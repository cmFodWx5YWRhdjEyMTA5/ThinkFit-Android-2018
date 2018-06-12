package com.app.thinkfit.adapter;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/19
 */

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.base.BaseRecyclerViewAdapter;
import com.app.thinkfit.adapter.base.Releasable;
import com.app.thinkfit.injection.ActivityContext;
import com.app.thinkfit.models.Day;
import com.app.thinkfit.utils.Utils;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class DayAdapter extends RecyclerView.Adapter<DayAdapter.DayViewHolder> implements Releasable {

    private Context context;
    private List<Day> listDay;
    private RecyclerView mRecyclerView;
    private static IClickItemListener iClickItemListener;

    public interface IClickItemListener{
        void onClickItem(int position);
    }

    @Inject
    public DayAdapter(@ActivityContext Context context, IClickItemListener listener) {
        this.context = context;
        this.iClickItemListener = listener;
    }

    @Override
    public DayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        DayViewHolder viewHolder = DayViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(DayViewHolder holder, int position) {
        holder.itemView.setLayoutParams(
                new LinearLayout.LayoutParams(
                        (int) ((Utils.getScreenWidth((Activity) context) - Utils.convertDpToPixel(context, 16)) / 7),
                        (int) ((Utils.getScreenWidth((Activity) context) - Utils.convertDpToPixel(context, 16)) / 7)));
        holder.bindData(context, listDay.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listDay ? 0 : listDay.size();
    }


    public void setListData(List<Day> list) {
        this.listDay = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        GridLayoutManager layoutManager = new GridLayoutManager(context, 7);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
    }

    public void reloadItem(int position) {
        if (listDay.get(position).isSelect()) {
            listDay.get(position).setSelect(false);
        } else {
            listDay.get(position).setSelect(true);
        }
        notifyItemChanged(position);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class DayViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<Day> {

        @BindView(R.id.tv_title_day)
        TextView tvTitleDay;

        public DayViewHolder(View itemView) {
            super(itemView);
        }

        public static DayViewHolder create(ViewGroup parent) {
            return new DayViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_day, parent, false));
        }

        @Override
        public void bindData(Context context, Day day, int position) {
            if (day != null) {
                tvTitleDay.setText(day.getTitle());
                if (day.isSelect()) {
                    tvTitleDay.setTextColor(context.getResources().getColor(R.color.white));
                    tvTitleDay.setBackgroundResource(R.drawable.shape_circle_orange);
                } else {
                    tvTitleDay.setTextColor(context.getResources().getColor(R.color.textColorSecondary));
                    tvTitleDay.setBackgroundResource(R.drawable.shape_circle_white_border_grey);
                }

                tvTitleDay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        iClickItemListener.onClickItem(position);
                    }
                });
            }
        }
    }
}
