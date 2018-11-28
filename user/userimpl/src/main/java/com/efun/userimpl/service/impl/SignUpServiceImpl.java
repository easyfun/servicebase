package com.efun.userimpl.service.impl;

import com.efun.codeapi.dto.VerifyEmailCodeParamDTO;
import com.efun.codeapi.dto.VerifyMobileCodeParamDTO;
import com.efun.codeapi.enums.CodeMode;
import com.efun.codeapi.rpcapi.CodeRpcService;
import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.enums.Result;
import com.efun.framework.common.exception.BusinessException;
import com.efun.userapi.dto.SignUpParamDTO;
import com.efun.userapi.exception.UserErrorCode;
import com.efun.userdata.mysql.dao.UserDetailMapper;
import com.efun.userdata.mysql.dao.UserMapper;
import com.efun.userdata.mysql.po.User;
import com.efun.userdata.mysql.po.UserDetail;
import com.efun.userimpl.builder.UserBuilder;
import com.efun.userimpl.builder.UserDetailBuilder;
import com.efun.userimpl.service.MysqlRequiresNewService;
import com.efun.userimpl.service.SignUpService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SignUpServiceImpl implements SignUpService {
    private static final Logger logger = LoggerFactory.getLogger(SignUpServiceImpl.class);

    @Autowired
    private CodeRpcService codeRpcService;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Autowired
    private MysqlRequiresNewService mysqlRequiresNewService;

    @Override
    public BaseResultDTO emailSignUp(SignUpParamDTO paramDTO) {
        //校验邮箱数字验证码
        VerifyEmailCodeParamDTO verifyEmailCodeParamDTO = new VerifyEmailCodeParamDTO();
        verifyEmailCodeParamDTO.setCodeMode(CodeMode.signUp);
        verifyEmailCodeParamDTO.setCode(paramDTO.getCode());
        verifyEmailCodeParamDTO.setEmail(paramDTO.getAccount());
        BaseResultDTO validateCodeResult = codeRpcService.verifyEmailCode(verifyEmailCodeParamDTO);
        if (validateCodeResult.getResult() != Result.success) {
            throw new BusinessException(UserErrorCode.signUpDigitalCodeError);
        }

        //生产用户记录
        User user = UserBuilder.buildWithEmail(paramDTO);
        UserDetail userDetail = UserDetailBuilder.build(user, paramDTO);
        //独立事务
        mysqlRequiresNewService.insertUserAndUserDetail(user, userDetail);

        //TODO:异步生成资金账号
        return BaseResultDTO.success();
    }

    @Override
    public BaseResultDTO mobileSignUp(SignUpParamDTO paramDTO) {
        //校验手机数字验证码
        VerifyMobileCodeParamDTO verifyMobileCodeParamDTO = new VerifyMobileCodeParamDTO();
        verifyMobileCodeParamDTO.setCodeMode(CodeMode.signUp);
        verifyMobileCodeParamDTO.setCode(paramDTO.getCode());
        verifyMobileCodeParamDTO.setMobile(paramDTO.getAccount());
        BaseResultDTO validateCodeResult = codeRpcService.verifyMobileCode(verifyMobileCodeParamDTO);
        if (validateCodeResult.getResult() != Result.success) {
            throw new BusinessException(UserErrorCode.signUpDigitalCodeError);
        }

        //生产用户记录
        User user = UserBuilder.buildWithMobile(paramDTO);
        UserDetail userDetail = UserDetailBuilder.build(user, paramDTO);
        //独立事务
        mysqlRequiresNewService.insertUserAndUserDetail(user, userDetail);

        //TODO:异步生成资金账号
        return BaseResultDTO.success();
    }
}
