package com.efun.userimpl.rpcimpl;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.framework.test.SpringTestCase;
import com.efun.userapi.dto.SignUpParamDTO;
import com.efun.userapi.enums.data.UserSignInLogEnums;
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
        SignUpParamDTO paramDTO = new SignUpParamDTO();
        paramDTO.setAccountMode(UserSignInLogEnums.AccountMode.email);
        paramDTO.setAccount("1060887552@qq.com");
        paramDTO.setCode("123456");
        paramDTO.setPassword("123456");
        BaseResultDTO baseResultDTO = userRpcService.signUp(paramDTO);
        logger.info("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
    }
}
