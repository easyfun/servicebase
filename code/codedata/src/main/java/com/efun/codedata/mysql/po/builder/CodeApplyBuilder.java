package com.efun.codedata.mysql.po.builder;

import com.efun.codedata.mysql.enums.CodeApplyEnums;
import com.efun.codedata.mysql.po.CodeApply;
import com.efun.framework.common.enums.Result;
import com.efun.framework.common.enums.UserAgent;

import java.util.Date;

public class CodeApplyBuilder {
    public static CodeApply buildTest() {
        CodeApply entity  = new CodeApply();
        entity.setApplyId(String.valueOf(System.currentTimeMillis()));
        entity.setApplyType(CodeApplyEnums.ApplyType.apply);
        entity.setBusinessId(String.valueOf(System.currentTimeMillis()));
        entity.setCodeMode(CodeApplyEnums.CodeMode.signUp);
        entity.setCode("123456");
        entity.setIp("127.0.0.1");
        entity.setUserAgent(UserAgent.android);
        entity.setDeviceId("123456789");
        entity.setResult(Result.accepted);
        entity.setFailCode(null);
        entity.setFailReason(null);
        Date current = new Date();
        entity.setCreateTime(current);
        entity.setUpdateTime(current);
        return entity;
    }
}
