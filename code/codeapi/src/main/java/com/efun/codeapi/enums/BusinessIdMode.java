package com.efun.codeapi.enums;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

/**
 * 业务id类型
 * 手机号，邮箱
 */
public enum BusinessIdMode implements IntegerValuedEnum {
    /**
     * 手机号
     */
    mobile(1),

    /**
     * 邮箱
     */
    email(10),

    ;

    private int value;

    private BusinessIdMode(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
