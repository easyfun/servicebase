package com.efun.userapi.exception;

import com.efun.framework.common.exception.ErrorCode;

/**
 * Created by easyfun on 2018/4/28.
 */
public enum UserErrorCode implements ErrorCode {
    /**
     * 账号类型错误
     */
    accountModeError("user00000000"),

    /**
     * 注册数字验证码错误
     */
    signUpDigitalCodeError("user00000001"),
    ;

    private String errorCode;

    UserErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String getFailCode() {
        return errorCode;
    }
}
