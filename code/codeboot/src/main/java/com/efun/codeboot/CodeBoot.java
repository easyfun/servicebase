package com.efun.codeboot;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by easyfun on 2018/4/23.
 */
public class CodeBoot {
    private static final Logger LOGGER = LoggerFactory.getLogger(CodeBoot.class);

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("application.xml");
        context.start();

        com.alibaba.dubbo.container.Main.main(args);

        LOGGER.debug("code stop running");
    }
}
