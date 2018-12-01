package com.efun.userapi.rpcapi;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.userapi.dto.EmailSignUpParamDTO;
import com.efun.userapi.dto.MobileSignUpParamDTO;

public interface UserRpcService {
    /**
     * 邮箱注册请求
     */
    BaseResultDTO emailSignUp(EmailSignUpParamDTO paramDTO);


    BaseResultDTO mobileSignUp(MobileSignUpParamDTO paramDTO);

}
