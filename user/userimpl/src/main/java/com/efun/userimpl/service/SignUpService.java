package com.efun.userimpl.service;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.userapi.dto.SignUpParamDTO;

public interface SignUpService {
    BaseResultDTO emailSignUp(SignUpParamDTO paramDTO);

    BaseResultDTO mobileSignUp(SignUpParamDTO paramDTO);

}
