package com.efun.userimpl.rpcimpl;

import com.efun.framework.common.dto.base.BaseResultDTO;
import com.efun.framework.common.exception.BusinessException;
import com.efun.userapi.dto.SignUpParamDTO;
import com.efun.userapi.enums.data.UserSignInLogEnums;
import com.efun.userapi.exception.UserErrorCode;
import com.efun.userapi.rpcapi.UserRpcService;
import com.efun.userimpl.service.SignUpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserRpcServiceImpl implements UserRpcService {

    @Autowired
    private SignUpService signUpService;

    @Override
    public BaseResultDTO signUp(SignUpParamDTO paramDTO) {
        paramDTO.validateBaseParam();

        if (paramDTO.getAccountMode() == UserSignInLogEnums.AccountMode.email) {
            return signUpService.emailSignUp(paramDTO);
        }

        if (paramDTO.getAccountMode() == UserSignInLogEnums.AccountMode.mobile) {
            return signUpService.mobileSignUp(paramDTO);
        }

        throw new BusinessException(UserErrorCode.accountModeError);
    }
}
