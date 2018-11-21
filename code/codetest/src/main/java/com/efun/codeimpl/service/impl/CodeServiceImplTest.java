package com.efun.codeimpl.service.impl;

import com.efun.codeimpl.service.CodeService;
import com.efun.framework.test.SpringTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CodeServiceImplTest extends SpringTestCase {
    private static final Logger logger = LoggerFactory.getLogger(CodeServiceImplTest.class);

    @Autowired
    private CodeService codeService;

    @Test
    public void createDigitalCode() {
        String code = codeService.createDigitalCode(6);
        logger.debug("code={}", code);
    }
}
