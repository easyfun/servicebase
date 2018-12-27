package com.efun.userimpl.rpcimpl;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.userapi.dto.EmailSignUpParamDTO;
import com.efun.userapi.dto.MobileSignUpParamDTO;
import com.efun.userapi.rpcapi.UserRpcService;
import com.efun.userimpl.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Autowired
    private SignUpService signUpService;

    @Override
    public BaseResultDTO emailSignUp(EmailSignUpParamDTO paramDTO) {
        paramDTO.validateBaseParam();
        return signUpService.emailSignUpWithTX(paramDTO);
    }

    @Override
    public BaseResultDTO mobileSignUp(MobileSignUpParamDTO paramDTO) {
        paramDTO.validateBaseParam();
        return signUpService.mobileSignUp(paramDTO);
    }

}
