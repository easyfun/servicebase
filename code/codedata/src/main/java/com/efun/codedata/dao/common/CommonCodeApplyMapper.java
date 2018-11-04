package com.efun.codedata.dao.common;

import com.efun.codedata.po.CodeApply;

public interface CommonCodeApplyMapper {
    int deleteByPrimaryKey(String applyId);

    int insert(CodeApply record);

    int insertSelective(CodeApply record);

    CodeApply selectByPrimaryKey(String applyId);

    int updateByPrimaryKeySelective(CodeApply record);

    int updateByPrimaryKey(CodeApply record);
}