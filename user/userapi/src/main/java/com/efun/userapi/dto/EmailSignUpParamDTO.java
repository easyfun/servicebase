package com.efun.userapi.dto;

import com.efun.framework.common.dto.base.BaseParamDTO;
import org.hibernate.validator.constraints.NotBlank;

public class EmailSignUpParamDTO extends BaseParamDTO {
    @NotBlank
    private String email;

    @NotBlank
    private String code;

    @NotBlank
    private String password;

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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
