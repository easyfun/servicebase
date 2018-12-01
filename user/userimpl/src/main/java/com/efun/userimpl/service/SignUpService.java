package com.efun.userimpl.service;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.userapi.dto.EmailSignUpParamDTO;
import com.efun.userapi.dto.MobileSignUpParamDTO;

public interface SignUpService {
    BaseResultDTO emailSignUpWithTX(EmailSignUpParamDTO paramDTO);

    BaseResultDTO mobileSignUp(MobileSignUpParamDTO paramDTO);

}
