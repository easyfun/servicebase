package com.efun.userapi.dto;

import com.efun.framework.common.dto.base.BaseParamDTO;
import org.hibernate.validator.constraints.NotBlank;

public class MobileSignUpParamDTO extends BaseParamDTO {
    @NotBlank
    private String mobile;

    @NotBlank
    private String code;

    @NotBlank
    private String password;

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
