package com.efun.codeimpl.rpcimpl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyMobileCodeParamDTO;
import com.efun.codeapi.rpcapi.CodeRpcService;
import com.efun.codedata.mysql.po.CodeApply;
import com.efun.codedata.mysql.po.builder.CodeApplyBuilder;
import com.efun.codeimpl.service.CodeMysqlRequiresNewService;
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
    EmailCodeService emailCodeService;

    @Autowired
    MobileCodeService mobileCodeService;

    @Autowired
    CodeMysqlRequiresNewService codeMysqlRequiresNewService;

    @Override
    public BaseResultDTO applyEmailCode(ApplyEmailCodeParamDTO paramDTO) {
        CodeApply codeApply = CodeApplyBuilder.build(paramDTO);
        codeMysqlRequiresNewService.insertCodeApply(codeApply);

        try {
            return emailCodeService.applyEmailCode(paramDTO, codeApply);
        } catch (Exception e) {
            BaseResultDTO fail = BaseResultDTO.fail(e);
            CodeApply update = CodeApplyBuilder.buildUpdate(codeApply, fail);
            codeMysqlRequiresNewService.updateCodeApply(update);
            return fail;
        }
    }

    @Override
    public BaseResultDTO verifyEmailCode(VerifyEmailCodeParamDTO paramDTO) {
        CodeApply codeApply = CodeApplyBuilder.build(paramDTO);
        codeMysqlRequiresNewService.insertCodeApply(codeApply);

        try {
            return emailCodeService.verifyEmailCode(paramDTO, codeApply);
        } catch (Exception e) {
            BaseResultDTO fail = BaseResultDTO.fail(e);
            CodeApply update = CodeApplyBuilder.buildUpdate(codeApply, fail);
            codeMysqlRequiresNewService.updateCodeApply(update);
            return fail;
        }
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
