package com.app.thinkfit.common;

/*
 *  Copyright Ⓒ 2018. All rights reserved
 *  Author DangTin. Create on 2018/05/13
 */

import retrofit2.Response;

public class UncaughtHttpException extends RuntimeException {
    private final int code;
    private final String message;
    private final transient Response<?> response;

    public UncaughtHttpException(Response<?> response) {
        super("HTTP " + response.code() + " " + response.message());
        this.code = response.code();
        this.message = response.message();
        this.response = response;
    }

    /**
     * HTTP status code.
     */
    public int code() {
        return code;
    }

    /**
     * HTTP status message.
     */
    public String message() {
        return message;
    }

    /**
     * The full HTTP response. This may be null if the exception was serialized.
     */
    public Response<?> response() {
        return response;
    }
}
