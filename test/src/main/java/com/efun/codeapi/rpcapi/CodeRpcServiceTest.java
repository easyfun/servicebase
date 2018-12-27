package com.efun.codeapi.rpcapi;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.dto.ApplyMobileCodeParamDTO;
import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.test.SpringTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CodeRpcServiceTest extends SpringTestCase {
    private static final Logger logger = LoggerFactory.getLogger(CodeRpcServiceTest.class);

    @Autowired
    private CodeRpcService codeRpcService;

    @Test
    public void applyEmailCode() {
        ApplyEmailCodeParamDTO paramDTO = new ApplyEmailCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setEmail("1060887552@qq.com");
        BaseResultDTO baseResultDTO = codeRpcService.applyEmailCode(paramDTO);
        logger.info("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }

    @Test
    public void applyMobileCode() {
        ApplyMobileCodeParamDTO paramDTO = new ApplyMobileCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setMobile("1060887552");
        BaseResultDTO baseResultDTO = codeRpcService.applyMobileCode(paramDTO);
        logger.info("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }

}
