package com.efun.userboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by easyfun on 2018/4/23.
 */
public class UserBoot {
    private static final Logger LOGGER = LoggerFactory.getLogger(UserBoot.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.start();

        com.alibaba.dubbo.container.Main.main(args);

        LOGGER.debug("userservice stop running");
    }
}
