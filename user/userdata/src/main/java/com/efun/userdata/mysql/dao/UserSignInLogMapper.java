package com.efun.userdata.mysql.dao;

import com.efun.userdata.mysql.po.UserSignInLog;

public interface UserSignInLogMapper {
    int deleteByPrimaryKey(Long id);

    int insert(UserSignInLog record);

    int insertSelective(UserSignInLog record);

    UserSignInLog selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(UserSignInLog record);

    int updateByPrimaryKey(UserSignInLog record);
}