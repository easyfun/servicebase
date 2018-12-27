package com.efun.userapi.enums.data;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

public class UserEnums {
    public enum MobileStatus implements IntegerValuedEnum {
        /**
         * 未启用
         */
        disable(1),

        /**
         * 已启用
         */
        enable(2),
        ;

        private int value;

        MobileStatus(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    public enum EmailStatus implements IntegerValuedEnum {
        /**
         * 未启用
         */
        disable(1),

        /**
         * 已启用
         */
        enable(2),
        ;

        private int value;

        EmailStatus(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    public enum CardStatus implements IntegerValuedEnum {
        /**
         * 未启用
         */
        disable(1),

        /**
         * 已启用
         */
        enable(2),
        ;

        private int value;

        CardStatus(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    public enum CardMode implements IntegerValuedEnum {
        /**
         * 中国大陆居民身分证
         */
        chinaIdCard(1),

        ;

        private int value;

        CardMode(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    public enum RealNameStatus implements IntegerValuedEnum {
        /**
         * 未实名
         */
        unRealName(1),

        /**
         * 已实名
         */
        realName(2),

        ;

        private int value;

        RealNameStatus(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    public enum UserStatus implements IntegerValuedEnum {
        /**
         * 未启用
         */
        disable(1),

        /**
         * 已启用
         */
        enable(2),
        ;

        private int value;

        UserStatus(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }


}
