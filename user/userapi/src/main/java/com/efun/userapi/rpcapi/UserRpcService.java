package com.efun.userapi.rpcapi;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.userapi.dto.SignUpParamDTO;

public interface UserRpcService {
    /**
     * 注册请求
     */
    BaseResultDTO signUp(SignUpParamDTO paramDTO);
}
