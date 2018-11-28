package com.efun.userimpl.service.impl;

import com.efun.userdata.mysql.dao.UserDetailMapper;
import com.efun.userdata.mysql.dao.UserMapper;
import com.efun.userdata.mysql.po.User;
import com.efun.userdata.mysql.po.UserDetail;
import com.efun.userimpl.service.MysqlRequiresNewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MysqlRequiresNewServiceImpl implements MysqlRequiresNewService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserDetailMapper userDetailMapper;

    @Override
    public void insertUserAndUserDetail(User user, UserDetail userDetail) {
        userMapper.insert(user);
        userDetailMapper.insert(userDetail);
    }
}
