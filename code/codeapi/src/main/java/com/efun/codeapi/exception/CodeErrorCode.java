package com.efun.codeapi.exception;

import com.efun.framework.common.exception.ErrorCode;

public enum CodeErrorCode implements ErrorCode {
    /**
     * 请求太快稍后重试
     */
    applyTooFast("code00000000"),

    ;

    private String errorCode;

    private CodeErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getFailCode() {
        return errorCode;
    }

}
