package com.efun.codeapi.enums;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

public enum CodeMode implements IntegerValuedEnum {
    /** 注册 */
    signUp(1),

    /** 重置登录密码 */
    resetLoginPassword(10),

    /** 重置支付密码 */
    resetPayPassword(20),

    ;

    private int value;

    private CodeMode(int value) {
            this.value = value;
        }

    @Override
    public int getValue() {
            return value;
        }
}
