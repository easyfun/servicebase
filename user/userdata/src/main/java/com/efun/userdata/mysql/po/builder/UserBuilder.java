package com.efun.userdata.mysql.po.builder;

import com.efun.framework.common.id.IdUtils;
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
}
