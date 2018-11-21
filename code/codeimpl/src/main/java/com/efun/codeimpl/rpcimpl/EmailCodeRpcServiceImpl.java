package com.efun.codeimpl.rpcimpl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.rpcapi.EmailCodeRpcService;
import com.efun.codeimpl.service.EmailCodeService;
import com.efun.framework.common.dto.base.BaseResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailCodeRpcServiceImpl implements EmailCodeRpcService {
    private static final Logger logger = LoggerFactory.getLogger(EmailCodeRpcServiceImpl.class);

    @Autowired
    private EmailCodeService emailCodeService;

    @Override
    public BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO applyEmailCodeParamDTO) {
        return emailCodeService.applyEmailCode(applyEmailCodeParamDTO);
    }

    @Override
    public BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO verifyEmailCodeParamDTO) {
        return null;
    }
}
