package com.efun.codeapi.enums;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

/**
 * 验证码类型
 * 按照功能划分
 */
public enum CodeMode implements IntegerValuedEnum {
    /**
     * 注册
     */
    signUp(1),

    /**
     * 重置登录密码
     */
    resetLoginPassword(10),

    /**
     * 重置支付密码
     */
    resetPayPassword(20),

    ;

    private int value;

    CodeMode(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }
}
