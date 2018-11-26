package com.efun.userapi.enums.data;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

public class UserSignInLogEnums {
    /**
     * 登陆账号类型
     */
    public enum AccountMode implements IntegerValuedEnum {
        mobile(1),

        email(2),

        ;

        private int value;

        private AccountMode(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

}
