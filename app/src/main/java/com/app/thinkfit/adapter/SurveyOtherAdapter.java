package com.app.thinkfit.adapter;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/20
 */

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.adapter.base.BaseRecyclerViewAdapter;
import com.app.thinkfit.adapter.base.Releasable;
import com.app.thinkfit.injection.ActivityContext;
import com.app.thinkfit.models.SurveyOther;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;

public class SurveyOtherAdapter extends RecyclerView.Adapter<SurveyOtherAdapter.SurveyOtherViewHolder> implements Releasable {

    private Context context;
    private List<SurveyOther> listSurveyOther;
    private RecyclerView mRecyclerView;

    @Inject
    public SurveyOtherAdapter(@ActivityContext Context context) {
        this.context = context;
    }

    @Override
    public SurveyOtherViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SurveyOtherViewHolder viewHolder = SurveyOtherViewHolder.create(parent);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(SurveyOtherViewHolder holder, int position) {
        holder.bindData(context, listSurveyOther.get(position), position);
    }

    @Override
    public int getItemCount() {
        return null == listSurveyOther ? 0 : listSurveyOther.size();
    }


    public void setListData(List<SurveyOther> list) {
        this.listSurveyOther = list;
        notifyDataSetChanged();
    }

    public void injectInto(RecyclerView recyclerView) {
        mRecyclerView = recyclerView;
        LinearLayoutManager layoutManager = new LinearLayoutManager(context);
        mRecyclerView.setNestedScrollingEnabled(false);
        mRecyclerView.setFocusable(false);
        mRecyclerView.setLayoutManager(layoutManager);
        mRecyclerView.setAdapter(this);
    }

    @Override
    public void release() {
        context = null;
    }

    public static class SurveyOtherViewHolder extends BaseRecyclerViewAdapter.BaseViewHolder<SurveyOther> {

        @BindView(R.id.chb_feel)
        CheckBox chbFeel;

        @BindView(R.id.tv_title)
        TextView tvTitle;

        public SurveyOtherViewHolder(View itemView) {
            super(itemView);
        }

        public static SurveyOtherViewHolder create(ViewGroup parent) {
            return new SurveyOtherViewHolder(LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_survey_other, parent, false));
        }

        @Override
        public void bindData(Context context, SurveyOther surveyOther, int position) {
            if (surveyOther != null) {
                tvTitle.setText(surveyOther.getTitle());
                chbFeel.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                    }
                });
            }
        }
    }
}
