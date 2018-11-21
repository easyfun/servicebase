package com.efun.codeapi.rpcapi;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.framework.common.dto.base.BaseResultDTO;

/**
 * 邮箱验证码rpc接口
 */
public interface EmailCodeRpcService {

    /**
     * 申请邮箱验证码
     */
    BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO applyEmailCodeParamDTO);

    /**
     * 验证邮箱验证码
     */
    BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO verifyEmailCodeParamDTO);

}