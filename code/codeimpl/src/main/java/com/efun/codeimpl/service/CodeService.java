package com.efun.codeimpl.service;

public interface CodeService {
    /**
     * 生成数字验证码
     */
    String createDigitalCode(int digit);

    /**
     * 生成6位数字验证码
     */
    String createDigitalCode6();

}
