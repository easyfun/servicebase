package com.efun.com.efun.framework.common.exception;

import com.efun.framework.common.exception.CommonErrorCode;
import org.junit.Test;

public class BaseExceptionTest {

    @Test
    public void toStringTest() {
        String v = String.format("errorCodeName=%s", CommonErrorCode.requestParamError);
        System.out.println(v);
    }
}
