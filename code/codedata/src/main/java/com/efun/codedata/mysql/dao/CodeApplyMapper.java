package com.efun.codedata.mysql.dao;

import com.efun.codedata.mysql.po.CodeApply;

public interface CodeApplyMapper {
    int deleteByPrimaryKey(Long id);

    int insert(CodeApply record);

    int insertSelective(CodeApply record);

    CodeApply selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(CodeApply record);

    int updateByPrimaryKey(CodeApply record);
}