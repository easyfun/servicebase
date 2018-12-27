package com.efun.codeapi.dto;

import com.efun.framework.common.dto.base.BaseParamDTO;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class ApplyEmailCodeParamDTO extends BaseParamDTO {
    private static final long serialVersionUID = -8086548718137972L;

    /**
     * 验证码类型
     */
    @NotNull
    private CodeMode codeMode;

    /**
     * 邮箱
     */
    @NotBlank
    private String email;

    private String param;

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

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }
}
