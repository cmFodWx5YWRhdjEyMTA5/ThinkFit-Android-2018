package com.app.thinkfit.models;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/30
 */

public class Reason {

    public static final int TYPE_NORMAL = 0;
    public static final int TYPE_OTHER = 1;

    private int type;
    private String title;

    public Reason(int type, String title) {
        this.type = type;
        this.title = title;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
