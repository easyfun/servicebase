package com.efun.userdata.mysql.dao;

import com.efun.userdata.mysql.dao.extend.UserDetailExtendMapper;
import com.efun.userdata.mysql.po.UserDetail;

public interface UserDetailMapper extends UserDetailExtendMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(UserDetail record);

    int insertSelective(UserDetail record);

    UserDetail selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(UserDetail record);

    int updateByPrimaryKey(UserDetail record);
}