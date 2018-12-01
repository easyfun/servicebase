package com.efun.userimpl.builder;

import com.efun.framework.common.id.IdUtils;
import com.efun.userapi.dto.EmailSignUpParamDTO;
import com.efun.userapi.dto.MobileSignUpParamDTO;
import com.efun.userapi.enums.data.UserEnums.*;
import com.efun.userdata.mysql.po.User;

import java.util.Date;

public class UserBuilder {
    public static User buildTest() {
        User user = new User();
        user.setUid(IdUtils.getInstance().createUid());
        user.setMobileStatus(MobileStatus.disable.name());
        user.setEmailStatus(EmailStatus.disable.name());
        user.setRealNameStatus(RealNameStatus.unRealName.name());
        user.setUserStatus(UserStatus.disable.name());
        user.setPassword("123456");
        user.setUserStatus(UserStatus.disable.name());
        Date current = new Date();
        user.setCreateTime(current);
        user.setUpdateTime(current);
        return user;
    }

    public static User buildWithEmail(EmailSignUpParamDTO paramDTO) {
        User user = new User();
        user.setUid(IdUtils.getInstance().createUid());
        user.setMobile(null);
        user.setMobileStatus(MobileStatus.disable.name());
        user.setEmail(paramDTO.getEmail());
        user.setEmailStatus(EmailStatus.enable.name());
        user.setCardNo(null);
        user.setCardMode(null);
        user.setRealNameStatus(RealNameStatus.unRealName.name());
        user.setPassword(paramDTO.getPassword());
        user.setUserStatus(UserStatus.enable.name());
        Date current = new Date();
        user.setCreateTime(current);
        user.setUpdateTime(current);
        return user;
    }

    public static User buildWithMobile(MobileSignUpParamDTO paramDTO) {
        User user = new User();
        user.setUid(IdUtils.getInstance().createUid());
        user.setMobile(paramDTO.getMobile());
        user.setMobileStatus(MobileStatus.enable.name());
        user.setEmail(null);
        user.setEmailStatus(null);
        user.setCardNo(null);
        user.setCardMode(null);
        user.setRealNameStatus(RealNameStatus.unRealName.name());
        user.setPassword(paramDTO.getPassword());
        user.setUserStatus(UserStatus.enable.name());
        Date current = new Date();
        user.setCreateTime(current);
        user.setUpdateTime(current);
        return user;
    }

}
