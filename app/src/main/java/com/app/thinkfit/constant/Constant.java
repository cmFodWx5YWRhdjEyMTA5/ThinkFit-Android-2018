package com.app.thinkfit.constant;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

public interface Constant {

    int FAIL_CONNECT_CODE = -1;
    int JSON_PARSER_CODE = -10;
    int OTHER_CODE = -20;

    String GENERIC_ERROR = "General error, please try again later";
    String SERVER_ERROR = "Fail to connect to server";

    String HOST_SCHEMA = "http://";
    String DOMAIN_NAME = "stg2.passp.asia";
    String HOST = HOST_SCHEMA + DOMAIN_NAME + "/api/";

    // Key Intent
    String KEY_TITLE = "KEY_TITLE";
    String KEY_DESCRIPTION = "KEY_DESCRIPTION";
    String KEY_FROM_ACTIVITY = "KEY_FROM_ACTIVITY";
    String REGISTER_MODE_ACTIVITY = "REGISTER_MODE_ACTIVITY";
    String SURVEY_STRENGTHEN_ACTIVITY = "SURVEY_STRENGTHEN_ACTIVITY";
    String SURVEY_CLIMBING_STAIRS_ACTIVITY = "SURVEY_CLIMBING_STAIRS_ACTIVITY";
    String OBJECT_TASK = "OBJECT_TASK";
}
