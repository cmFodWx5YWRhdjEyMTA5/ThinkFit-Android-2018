package com.app.thinkfit.adapter;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.thinkfit.R;
import com.app.thinkfit.models.Tutorial;

import java.util.List;

public class TutorialAdapter extends PagerAdapter {

    private Context mContext;
    private List<Tutorial> mListTutorial;

    public TutorialAdapter(Context context, List<Tutorial> mListData) {
        this.mContext = context;
        this.mListTutorial = mListData;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        Tutorial tutorial = mListTutorial.get(position);
        LayoutInflater inflater = LayoutInflater.from(mContext);
        ViewGroup layout = (ViewGroup) inflater.inflate(R.layout.item_tutorial,
                container, false);
        TextView tvContent = (TextView) layout.findViewById(R.id.tv_content);
        tvContent.setText(tutorial.getContent());

        container.addView(layout);
        return layout;
    }

    @Override
    public int getCount() {
        return mListTutorial.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }
}
