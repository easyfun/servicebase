package com.efun.userapi.enums.data;

import com.efun.framework.common.mybatis.IntegerValuedEnum;

public class UserDetailEnums {
    public enum Gender implements IntegerValuedEnum {
        unknown(1),

        woman(2),

        man(3),
        ;

        private int value;

        private Gender(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

    public enum MarriageStatus implements IntegerValuedEnum {
        married(1),

        unmarried(2),

        secret(3),
        ;

        private int value;

        private MarriageStatus(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }


    public enum SecurityLevel implements IntegerValuedEnum {
        normal(1),

        ;

        private int value;

        private SecurityLevel(int value) {
            this.value = value;
        }

        @Override
        public int getValue() {
            return value;
        }
    }

}
