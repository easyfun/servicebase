package com.efun.codeimpl.rpcimpl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyMobileCodeParamDTO;
import com.efun.codeapi.rpcapi.CodeRpcService;
import com.efun.codeimpl.service.EmailCodeService;
import com.efun.codeimpl.service.MobileCodeService;
import com.efun.framework.common.dto.base.BaseResultDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeRpcServiceImpl implements CodeRpcService {
    private static final Logger logger = LoggerFactory.getLogger(CodeRpcServiceImpl.class);

    @Autowired
    private EmailCodeService emailCodeService;

    @Autowired
    private MobileCodeService mobileCodeService;

    @Override
    public BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO applyEmailCodeParamDTO) {
        return emailCodeService.applyEmailCode(applyEmailCodeParamDTO);
    }

    @Override
    public BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO verifyEmailCodeParamDTO) {
        return emailCodeService.verifyEmailCode(verifyEmailCodeParamDTO);
    }

    @Override
    public BaseResultDTO applyMobileCode(ApplyMobileCodeParamDTO applyMobileCodeParamDTO) {
        return mobileCodeService.applyMobileCode(applyMobileCodeParamDTO);
    }

    @Override
    public BaseResultDTO verifyMobileCode(VerifyMobileCodeParamDTO verifyMobileCodeParamDTO) {
        return mobileCodeService.verifyMobileCode(verifyMobileCodeParamDTO);
    }

}
