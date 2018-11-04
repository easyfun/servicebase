package com.efun.codedata.dao;

import com.efun.codedata.po.CodeApply;
import com.efun.codedata.po.builder.CodeApplyBuilder;
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
