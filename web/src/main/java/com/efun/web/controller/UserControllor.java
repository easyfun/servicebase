package com.efun.web.controller;

import com.efun.web.service.WebService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/web")
public class UserControllor {
    private static final Logger logger = LoggerFactory.getLogger(UserControllor.class);

    @Autowired
    private WebService webService;

    @RequestMapping(value = "/signUp")
    @ResponseBody
    public String signUp() {
        return webService.signUp();
    }

}
