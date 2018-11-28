package com.efun.userapi.dto;

import com.efun.framework.common.dto.base.BaseParamDTO;
import com.efun.userapi.enums.data.UserSignInLogEnums.*;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

public class SignUpParamDTO extends BaseParamDTO {
    @NotNull
    private AccountMode accountMode;

    @NotBlank
    private String account;

    @NotBlank
    private String code;

    @NotBlank
    private String password;

    public AccountMode getAccountMode() {
        return accountMode;
    }

    public void setAccountMode(AccountMode accountMode) {
        this.accountMode = accountMode;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
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
