package com.efun.codeimpl.service;

import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codeapi.dto.VerifyMobileCodeParamDTO;
import com.efun.framework.common.dto.base.BaseResultDTO;

public interface MobileCodeService {
    BaseResultDTO applyMobileCode(ApplyMobileCodeParamDTO applyMobileCodeParamDTO);

    BaseResultDTO verifyMobileCode(VerifyMobileCodeParamDTO verifyMobileCodeParamDTO);
}
