package com.efun.userimpl.rpcimpl;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.enums.UserAgent;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.test.SpringTestCase;
import com.efun.userapi.dto.EmailSignUpParamDTO;
import com.efun.userapi.rpcapi.UserRpcService;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserRpcServiceImplTest extends SpringTestCase {
    private static final Logger logger = LoggerFactory.getLogger(UserRpcServiceImplTest.class);

    @Autowired
    private UserRpcService userRpcService;

    @Test
    public void signUp() {
        EmailSignUpParamDTO paramDTO = new EmailSignUpParamDTO();
        paramDTO.setEmail("1060887552@qq.com");
        paramDTO.setCode("123456");
        paramDTO.setPassword("123456");
        paramDTO.setUserAgent(UserAgent.android);
        paramDTO.setUserIp("127.0.0.1");
        BaseResultDTO baseResultDTO = userRpcService.emailSignUp(paramDTO);
        logger.info("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }
}
