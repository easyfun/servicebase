package com.efun.userapi.enums.data;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

public class UserSignInLogEnums {
    /**
     * 账号类型
     */
    public enum AccountMode implements IntegerValuedEnum {
        mobile(1),

        email(2),

        ;

        private int value;

        AccountMode(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

}
