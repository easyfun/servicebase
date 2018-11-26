package com.efun.userdata.mysql.dao.base;

import com.efun.userdata.mysql.po.UserDetail;

public interface UserDetailMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}