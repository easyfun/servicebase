package com.efun.userdata.mysql.dao;

import com.efun.userdata.mysql.dao.extend.UserExtendMapper;
import com.efun.userdata.mysql.po.User;

public interface UserMapper extends UserExtendMapper {
    int deleteByPrimaryKey(Long uid);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long uid);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}