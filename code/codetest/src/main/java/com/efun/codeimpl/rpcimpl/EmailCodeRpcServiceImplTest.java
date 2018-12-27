package com.efun.codeimpl.rpcimpl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyMobileCodeParamDTO;
import com.efun.codeapi.rpcapi.CodeRpcService;
import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.test.SpringTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class EmailCodeRpcServiceImplTest extends SpringTestCase {
    private static final Logger logger = LoggerFactory.getLogger(EmailCodeRpcServiceImplTest.class);

    @Autowired
    private CodeRpcService codeRpcService;

    @Test
    public void applyEmailCode() {
        ApplyEmailCodeParamDTO paramDTO = new ApplyEmailCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setEmail("1060887552@qq.com");
        BaseResultDTO baseResultDTO = codeRpcService.applyEmailCode(paramDTO);
        logger.debug("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }

    @Test
    public void verifyEmailCode() {
        VerifyEmailCodeParamDTO paramDTO = new VerifyEmailCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setEmail("1060887552@qq.com");
        paramDTO.setCode("123456");
        BaseResultDTO resultDTO = codeRpcService.verifyEmailCode(paramDTO);
        logger.debug("resultDTO={}", JsonUtil.toJSONString(resultDTO));
    }

    @Test
    public void applyMobileCode() {
        ApplyMobileCodeParamDTO paramDTO = new ApplyMobileCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setMobile("13517295502");
        BaseResultDTO baseResultDTO = codeRpcService.applyMobileCode(paramDTO);
        logger.debug("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }

    @Test
    public void verifyMobileCode() {
        VerifyMobileCodeParamDTO paramDTO = new VerifyMobileCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setMobile("13517295502");
        paramDTO.setCode("123456");
        BaseResultDTO resultDTO = codeRpcService.verifyMobileCode(paramDTO);
        logger.debug("resultDTO={}", JsonUtil.toJSONString(resultDTO));
    }

}
