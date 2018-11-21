package com.efun.codedata.mysql.dao;

import com.efun.codedata.mysql.po.CodeApply;
import com.efun.codedata.mysql.po.builder.CodeApplyBuilder;
import com.efun.framework.test.SpringTestCase;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class CodeApplyMapperTest extends SpringTestCase {
    private static final Logger logger = LoggerFactory.getLogger(CodeApplyMapperTest.class);

    @Autowired
    private CodeApplyMapper codeApplyMapper;

    @Test
    public void insertSelective() {
        CodeApply codeApply = CodeApplyBuilder.buildTest();
        codeApplyMapper.insertSelective(codeApply);
    }


}
