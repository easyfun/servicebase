package com.efun.codeapi.enums.data;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

public class CodeApplyEnums {

    public enum ApplyMode implements IntegerValuedEnum {
        apply(1),

        verify(2),

        ;

        private int value;

        ApplyMode(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }


    public enum BusinessIdMode implements IntegerValuedEnum {
        mobile(1),

        email(2),

        ;

        private int value;

        BusinessIdMode(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    /**
     * 验证码类型
     * 按照功能划分
     **/
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


}
