package com.efun.codeimpl.service.impl;

import com.efun.codedata.mysql.dao.CodeApplyMapper;
import com.efun.codedata.mysql.po.CodeApply;
import com.efun.codeimpl.service.CodeMysqlRequiresNewService;
import com.efun.framework.common.exception.BusinessException;
import com.efun.framework.common.exception.CommonErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CodeMysqlRequiresNewServiceImpl implements CodeMysqlRequiresNewService {

    private static final Logger logger = LoggerFactory.getLogger(CodeMysqlRequiresNewServiceImpl.class);

    @Autowired
    CodeApplyMapper codeApplyMapper;

    @Override
    public void insertCodeApply(CodeApply codeApply) {
        int rows = codeApplyMapper.insertSelective(codeApply);
        if (1 != rows) {
            throw new BusinessException(CommonErrorCode.insertDataError);
        }
    }

    @Override
    public void updateCodeApply(CodeApply update) {
        int rows = codeApplyMapper.updateByPrimaryKeySelective(update);
        if (1 != rows) {
            throw new BusinessException(CommonErrorCode.updateDataError);
        }
    }
}
