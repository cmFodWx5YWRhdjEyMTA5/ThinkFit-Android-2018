package com.app.thinkfit.ui.widget.textview;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.app.thinkfit.utils.Utils;

public class RobotoRegularTextView extends AppCompatTextView {
    public RobotoRegularTextView(Context context) {
        super(context);
        setFont();
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setFont();
    }

    public RobotoRegularTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        setFont();
    }


    private void setFont() {
        Typeface textViewTypeface = Utils.getRobotoRegularTypeFace(getContext());
        setTypeface(textViewTypeface);
    }
}
