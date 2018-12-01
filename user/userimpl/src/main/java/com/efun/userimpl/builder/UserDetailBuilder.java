package com.efun.userimpl.builder;

import com.efun.userapi.dto.EmailSignUpParamDTO;
import com.efun.userapi.dto.MobileSignUpParamDTO;
import com.efun.userapi.enums.data.UserDetailEnums;
import com.efun.userdata.mysql.po.User;
import com.efun.userdata.mysql.po.UserDetail;

import java.util.Date;

public class UserDetailBuilder {
    public static UserDetail build(User user, EmailSignUpParamDTO paramDTO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(user.getUid());
        userDetail.setNickName(null);
        userDetail.setHeadPictureUrl(null);
        userDetail.setGender(UserDetailEnums.Gender.unknown.name());
        userDetail.setRealName(null);
        userDetail.setBirthday(null);
        userDetail.setAge(-1);
        userDetail.setMarriageStatus(UserDetailEnums.MarriageStatus.secret.name());
        userDetail.setEducation(null);
        userDetail.setSecurityLevel(UserDetailEnums.SecurityLevel.normal.name());
        userDetail.setCityCode(null);
        userDetail.setProvinceCode(null);
        userDetail.setIp(paramDTO.getUserIp());
        userDetail.setUserAgent(paramDTO.getUserAgent().name());
        userDetail.setSignUpDate(user.getCreateTime());
        Date current = new Date();
        userDetail.setCreateTime(current);
        userDetail.setUpdateTime(current);
        return userDetail;
    }

    public static UserDetail build(User user, MobileSignUpParamDTO paramDTO) {
        UserDetail userDetail = new UserDetail();
        userDetail.setUid(user.getUid());
        userDetail.setNickName(null);
        userDetail.setHeadPictureUrl(null);
        userDetail.setGender(UserDetailEnums.Gender.unknown.name());
        userDetail.setRealName(null);
        userDetail.setBirthday(null);
        userDetail.setAge(-1);
        userDetail.setMarriageStatus(UserDetailEnums.MarriageStatus.secret.name());
        userDetail.setEducation(null);
        userDetail.setSecurityLevel(UserDetailEnums.SecurityLevel.normal.name());
        userDetail.setCityCode(null);
        userDetail.setProvinceCode(null);
        userDetail.setIp(paramDTO.getUserIp());
        userDetail.setUserAgent(paramDTO.getUserAgent().name());
        userDetail.setSignUpDate(user.getCreateTime());
        Date current = new Date();
        userDetail.setCreateTime(current);
        userDetail.setUpdateTime(current);
        return userDetail;
    }

}
