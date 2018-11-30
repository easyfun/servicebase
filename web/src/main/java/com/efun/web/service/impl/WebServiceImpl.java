package com.efun.web.service.impl;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.enums.UserAgent;
import com.efun.framework.common.id.IdUtils;
import com.efun.framework.common.utils.JsonUtil;
import com.efun.userapi.dto.SignUpParamDTO;
import com.efun.userapi.enums.data.UserSignInLogEnums;
import com.efun.userapi.rpcapi.UserRpcService;
import com.efun.web.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WebServiceImpl implements WebService {
    private static final Logger logger = LoggerFactory.getLogger(WebServiceImpl.class);

    @Autowired
    private UserRpcService userRpcService;

    @Override
    public String signUp() {
        SignUpParamDTO paramDTO = new SignUpParamDTO();

        paramDTO.setApplyId(String.valueOf(IdUtils.getInstance().createFlowId()));
        paramDTO.setUserAgent(UserAgent.android);
        paramDTO.setVersion("0.0.0");
        paramDTO.setLang("zh");
        paramDTO.setUserIp("127.0.0.1");
        paramDTO.setUserDeviceId("127001");

        paramDTO.setAccountMode(UserSignInLogEnums.AccountMode.email);
        paramDTO.setAccount("1060887552@qq.com");
        paramDTO.setCode("123456");
        paramDTO.setPassword("123456");

        BaseResultDTO baseResultDTO = userRpcService.signUp(paramDTO);
        logger.info("baseResultDTO={}", JsonUtil.toJSONString(baseResultDTO));
        return JsonUtil.toJSONString(baseResultDTO);
    }
}
