package com.efun.codeimpl.service;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.framework.common.dto.base.BaseResultDTO;

public interface EmailCodeService {
    BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO applyEmailCodeParamDTO);

    BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO verifyEmailCodeParamDTO);
}
