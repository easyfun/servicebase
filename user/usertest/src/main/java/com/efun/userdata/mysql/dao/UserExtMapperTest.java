package com.efun.userdata.mysql.dao;

import com.efun.framework.test.SpringTestCase;
import com.efun.userdata.mysql.po.User;
import com.efun.userimpl.builder.UserBuilder;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class UserExtMapperTest extends SpringTestCase {
    private static final Logger logger = LoggerFactory.getLogger(UserExtMapperTest.class);

    @Autowired
    private UserMapper userMapper;

    @Test
    public void insert() {
        User user = UserBuilder.buildTest();
        userMapper.insert(user);
    }

}
