package com.efun.userimpl.service;

import com.efun.userdata.mysql.po.User;
import com.efun.userdata.mysql.po.UserDetail;

public interface MysqlRequiresNewService {
    void insertUserAndUserDetail(User user, UserDetail userDetail);
}
