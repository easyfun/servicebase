package com.efun.codeapi.dto;

import com.efun.framework.common.dto.base.BaseParamDTO;

public class VerifyEmailCodeParamDTO extends BaseParamDTO {
    private static final long serialVersionUID = -4191532230936764019L;

    /**
     * 验证码类型
     */
    private CodeMode codeMode;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 验证码
     */
    private String code;

    public CodeMode getCodeMode() {
        return codeMode;
    }

    public void setCodeMode(CodeMode codeMode) {
        this.codeMode = codeMode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
