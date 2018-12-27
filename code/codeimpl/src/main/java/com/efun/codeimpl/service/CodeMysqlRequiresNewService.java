package com.efun.codeimpl.service;

import com.efun.codedata.mysql.po.CodeApply;

public interface CodeMysqlRequiresNewService {

    void insertCodeApply(CodeApply codeApply);

    void updateCodeApply(CodeApply update);
}
