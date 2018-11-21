package com.efun.codeimpl.rpcimpl;

import com.efun.codeapi.dto.ApplyEmailCodeParamDTO;
import com.efun.codeapi.enums.CodeMode;
import com.efun.codeapi.rpcapi.EmailCodeRpcService;
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
    private EmailCodeRpcService emailCodeRpcService;

    @Test
    public void applyEmailCode() {
        ApplyEmailCodeParamDTO paramDTO = new ApplyEmailCodeParamDTO();
        paramDTO.setCodeMode(CodeMode.signUp);
        paramDTO.setEmail("1060887552@qq.com");
        BaseResultDTO baseResultDTO = emailCodeRpcService.applyEmailCode(paramDTO);
        logger.debug("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }

}
